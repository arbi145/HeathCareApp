package tn.esprit.health1.Database;

import android.content.Context;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import tn.esprit.health1.Dao.DocteurDAO;
import tn.esprit.health1.Dao.RendezVousDAO;
import tn.esprit.health1.Dao.SpecialiteDAO;
import tn.esprit.health1.Dao.UserDao;
import tn.esprit.health1.entities.Docteur;
import tn.esprit.health1.entities.Rendezvous;
import tn.esprit.health1.entities.Specialite;
import tn.esprit.health1.entities.User;

@Database(entities = {Docteur.class, Specialite.class, User.class, Rendezvous.class}, version = 11
        ,exportSchema = true)
public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase instance;

    public abstract DocteurDAO docteurDAO();
    public abstract SpecialiteDAO specialiteDAO();
    public abstract RendezVousDAO rendezVousDAO();


    public abstract UserDao userDao();

    public static MyDatabase getDatabase(Context ctx) {
        if (instance == null) {
            instance = Room.databaseBuilder(ctx.getApplicationContext(), MyDatabase.class, "db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }


}
