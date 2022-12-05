package tn.esprit.health1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.health1.Database.MyDatabase;
import tn.esprit.health1.entities.Docteur;
import tn.esprit.health1.entities.Specialite;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    EditText name;
    EditText price;
    EditText foreigns;
    Button add;
    Button logout;
    TextView list;
    Spinner spinner;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sp = getSharedPreferences("sp", MODE_PRIVATE);
        setTitle("Hello " + sp.getString("username", "Skander"));
        name = findViewById(R.id.articleName);
        price = findViewById(R.id.articlePrice);
        foreigns = findViewById(R.id.foreign);
        add = findViewById(R.id.add);
        list = findViewById(R.id.articles);
        logout = findViewById(R.id.logout);
        spinner  = findViewById(R.id.spinner);




        MyDatabase db = MyDatabase.getDatabase(HomeActivity.this);
        add.setOnClickListener(v -> {
            String articleName = name.getText().toString();
            float articlePrice = Float.parseFloat(price.getText().toString());
            int foreign = Integer.parseInt(foreigns.getText().toString());
            Docteur a = new Docteur(articleName, articlePrice,foreign);


            if (String.valueOf(name.getText()).equals("")) {
                Toast.makeText(v.getContext(), "Please enter first name", Toast.LENGTH_SHORT).show();
            }

            db.docteurDAO().insertDocteur(a);
            Intent i = new Intent(this, RecycleActivity.class);
            startActivity(i);
            List<Docteur> articleList = db.docteurDAO().findDocteurs();
            list.setText(articleList.toString());






        });

        List<Specialite> specialiteLists = db.specialiteDAO().findSpecialites();
        spinner.setAdapter(
                new ArrayAdapter(
                        this, // Context, Activity etc.,
                        android.R.layout.simple_list_item_1,specialiteLists
                ));


        







        logout.setOnClickListener(v -> {
            sp.edit().clear().apply();
            finish();
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}