package tn.esprit.health1;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.health1.Database.MyDatabase;


public class MyViewHolder extends RecyclerView.ViewHolder  {





    TextView nameView,priceView;
    Button but;
    Button but1;


    public MyViewHolder( @NonNull View itemView) {
        super(itemView);




        nameView = itemView.findViewById(R.id.name);
        priceView = itemView.findViewById(R.id.price);
        but = itemView.findViewById(R.id.but);
        but1 =itemView.findViewById(R.id.but1);


    }



}
