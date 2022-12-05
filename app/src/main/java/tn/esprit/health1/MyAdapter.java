package tn.esprit.health1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import tn.esprit.health1.Dao.DocteurDAO;
import tn.esprit.health1.Database.MyDatabase;
import tn.esprit.health1.entities.Docteur;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>  {



    Context context;
    List<Docteur> docteurs;


    public MyAdapter(Context context, List<Docteur> docteurs) {
        this.context = context;
        this.docteurs = docteurs;



    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,   int position) {

        holder.nameView.setText(docteurs.get(holder.getAdapterPosition()).getName());
        holder.priceView.setText(Integer.toString((int) docteurs.get(holder.getAdapterPosition()).getPrice()));
        holder.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               MyDatabase db = MyDatabase.getDatabase(context);
                DocteurDAO docteurDAO = db.docteurDAO();
                docteurDAO.deleteById(docteurs.get(holder.getAdapterPosition()).getId());
                docteurs.remove(holder.getAdapterPosition());
                notifyDataSetChanged();


            }
        });


        holder.but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return docteurs.size();
    }



}

