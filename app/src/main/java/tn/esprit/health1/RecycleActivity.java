package tn.esprit.health1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import java.util.List;
import tn.esprit.health1.Database.MyDatabase;
import tn.esprit.health1.entities.Docteur;

public  class RecycleActivity extends AppCompatActivity  {


    List<Docteur> docteurs;
    SearchView searchView;
    MyAdapter adapter;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);





        MyDatabase db = MyDatabase.getDatabase(RecycleActivity.this);
        List<Docteur> docteursList = db.docteurDAO().findDocteurs();

      //  list.setText(articleList.toString());
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        button = findViewById(R.id.button);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),docteursList));

      //  MyAdapter adapter = new MyAdapter(getApplicationContext(),articleList);







    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}