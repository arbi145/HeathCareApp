package tn.esprit.health1.Dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import tn.esprit.health1.entities.User;

@Dao
public interface UserDao {

    @Insert
    public void registerUser(User user);

    @Query("SELECT * from users where name=(:name) and password=(:password)")
    User login(String name, String password);


    @Query("SELECT * FROM users WHERE id = :id")
    User getUser(long id);


}