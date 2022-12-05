package tn.esprit.health1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import tn.esprit.health1.Dao.UserDao;
import tn.esprit.health1.Database.MyDatabase;

public class ChatActivity extends AppCompatActivity {

    TextView usernames;
    Button date_time_set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        date_time_set = findViewById(R.id.date_time_set);
        date_time_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker datePicker = (DatePicker)findViewById(R.id.date_picker);
                TimePicker timePicker = (TimePicker)findViewById(R.id.time_picker);

               // String data = getIntent().toString();

                String username = getIntent().getStringExtra("username");
                Log.i(username,"eeeeeeeeeeeeeppppppppppppeeeeeee");

                 TextView usernames =  findViewById(R.id.usernames);
                usernames.setText(username);
            }
        });

    }

    }
