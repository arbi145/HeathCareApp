package tn.esprit.health1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import tn.esprit.health1.Database.MyDatabase;
import tn.esprit.health1.entities.Specialite;

public class SpecialiteActivity extends AppCompatActivity {


    EditText name;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialite);

        SharedPreferences sp = getSharedPreferences("sp", MODE_PRIVATE);
        setTitle("Hello " + sp.getString("username", "Skander"));
        name = findViewById(R.id.SpecialiteName);
        add = findViewById(R.id.add);

        MyDatabase db = MyDatabase.getDatabase(SpecialiteActivity.this);
        add.setOnClickListener(v -> {
            String specialiteName = name.getText().toString();

            Specialite a = new Specialite(specialiteName);

            db.specialiteDAO().insertSpecialite(a);

        });
    }
}