package tn.esprit.health1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CardActivity extends AppCompatActivity {

    CardView your,your1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        CardView your =  findViewById(R.id.your);
        CardView your1 = findViewById(R.id.your1);

        your.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CardActivity.this, SpecialiteActivity.class);
                startActivity(i);
            }
        });


    your1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(CardActivity.this, RecycleActivity.class);
            startActivity(i);
        }
    });

}
}