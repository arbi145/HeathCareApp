package tn.esprit.health1.entities;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Docteur" ,
        foreignKeys = @ForeignKey(entity = Specialite.class,
        parentColumns = "id",
        childColumns = "id_fkdocteur",
        onDelete = CASCADE
), indices = @Index("id_fkdocteur") )
public class Docteur {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private float price;
    @ColumnInfo
    private int id_fkdocteur;

    public Docteur() {
    }

    public Docteur(int id, String name, float prix) {
        this.id = id;
        this.name = name;
        this.price = prix;
    }

    public Docteur(String name, float prix) {
        this.name = name;
        this.price = prix;
    }

    public Docteur(String name, float price, int id_fkarticle) {
        this.name = name;
        this.price = price;
        this.id_fkdocteur = id_fkarticle;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int getId_fkdocteur() {
        return id_fkdocteur;
    }

    public void setId_fkdocteur(int id_fkarticle) {
        this.id_fkdocteur = id_fkarticle;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prix=" + price +
                '}';
    }
}
