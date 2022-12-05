package tn.esprit.health1.Dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import tn.esprit.health1.entities.Docteur;

@Dao
public interface DocteurDAO {

    @Insert
    public void insertDocteur(Docteur a);

    @Update
    public void updateDocteur(Docteur a);

    @Delete
    public void deleteDocteur(Docteur a);

    @Query("DELETE FROM Docteur WHERE id = :id")
    public void deleteById(int id);

    @Query("SELECT * FROM Docteur")
    public List<Docteur> findDocteurs();

    @Query("SELECT * FROM Docteur WHERE name = :name")
    public  List<Docteur> findDocteursByName(String name);
}
