package tn.esprit.health1.Dao;


import androidx.room.Dao;
import androidx.room.Insert;


import tn.esprit.health1.entities.Rendezvous;

@Dao
public interface RendezVousDAO {
    @Insert
    public void insertRendezvous(Rendezvous a);
}
