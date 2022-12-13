package tn.esprit.health1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.List;
import tn.esprit.health1.Database.MyDatabase;
import tn.esprit.health1.entities.Docteur;
import tn.esprit.health1.entities.Rendezvous;
import tn.esprit.health1.entities.Specialite;

public class CalendarActivity extends AppCompatActivity {

    Spinner spinner2,spinner3;
    TextView usernames;
    DatePicker date_picker;
    Button set;
    TimePicker time_picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        set = findViewById(R.id.set);
        date_picker = (DatePicker) findViewById(R.id.date_picker);
        time_picker = (TimePicker) findViewById(R.id.time_picker);


        int hours =time_picker.getHour();
        int minutes = time_picker.getMinute();
        int day = date_picker.getDayOfMonth();
        int month = date_picker.getMonth() + 1;
        int year = date_picker.getYear();

        Calendar calendar = Calendar.getInstance();

        String oo = day + "/" + month + "/" + year;
        MyDatabase db = MyDatabase.getDatabase(CalendarActivity.this);
        set.setOnClickListener(v -> {
                int foreign = Integer.parseInt(spinner2.getSelectedItem().toString());
                Rendezvous a = new Rendezvous("fdf", foreign, 1, oo, hours, minutes);
                db.rendezVousDAO().insertRendezvous(a);
            });


            List<Specialite> specialiteLists = db.specialiteDAO().findSpecialites();
            spinner2.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, specialiteLists));
            List<Docteur> docteurLists = db.docteurDAO().findDocteurs();
            spinner3.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, docteurLists));


        }
    }




