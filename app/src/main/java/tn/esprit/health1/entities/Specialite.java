package tn.esprit.health1.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Specialite {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;





    public Specialite(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return
                //"id=" +
                Integer.toString(id);
                                //+
               // ", name='" + name ;
    }

}
