package tn.esprit.health1.entities;

import static androidx.room.ForeignKey.CASCADE;

import android.widget.DatePicker;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;


@Entity(tableName = "Rendezvous" ,
        foreignKeys ={ @ForeignKey(entity = Docteur.class, parentColumns = "id",
                childColumns = "id_fkrendezvous", onDelete = CASCADE),
                @ForeignKey(entity = User.class, parentColumns = "id",
                        childColumns = "id_fkuser", onDelete = CASCADE)}
        //,
             //   indices = @Index(value={"id_fkrendezvous,id_fkuser"}),

                // indices = {
                        // @Index(value="id_fkrendezvous",unique = true)
                        // ,
                        // @Index(value="id_fkuser", unique = true)
         //}
         )
public class Rendezvous {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private int id_fkrendezvous;
    @ColumnInfo
    private int id_fkuser;
    @ColumnInfo

    private String date;
    @ColumnInfo
    private int hours;
    @ColumnInfo
    private int minutes;

    public Rendezvous() {
    }

    public Rendezvous(String name, int id_fkrendezvous, int id_fkuser, String date, int hours, int minutes) {
        this.name = name;
        this.id_fkrendezvous = id_fkrendezvous;
        this.id_fkuser = id_fkuser;
        this.date = date;
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_fkrendezvous() {
        return id_fkrendezvous;
    }

    public void setId_fkrendezvous(int id_fkrendezvous) {
        this.id_fkrendezvous = id_fkrendezvous;
    }

    public int getId_fkuser() {
        return id_fkuser;
    }

    public void setId_fkuser(int id_fkuser) {
        this.id_fkuser = id_fkuser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}

