package tn.esprit.health1.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import tn.esprit.health1.entities.Specialite;

@Dao
public interface SpecialiteDAO {

    @Insert
    public void insertSpecialite(Specialite a);

    @Update
    public void updateSpecialite(Specialite a);

    @Delete
    public void deleteSpecialite(Specialite a);

    @Query("SELECT id,name FROM Specialite")
    public List<Specialite> findSpecialites();
}
