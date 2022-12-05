package tn.esprit.health1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tn.esprit.health1.Dao.UserDao;
import tn.esprit.health1.Database.MyDatabase;
import tn.esprit.health1.entities.User;

public class RegisterActivity extends AppCompatActivity {

    EditText name,email,password;
    Button register,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.name);
        email=findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login =findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setName(name.getText().toString());
                user.setPassword(password.getText().toString());
                user.setEmail(email.getText().toString());


                if(validateInput(user)){
                    MyDatabase data = MyDatabase.getDatabase(getApplicationContext());
                    UserDao userDao = data.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            userDao.registerUser(user);

                        }
                    }).start();
                    Toast.makeText(getApplicationContext(),"User Registered",Toast.LENGTH_SHORT).show();


                }
                else{
                    Toast.makeText(getApplicationContext(),"Fill all fields",Toast.LENGTH_SHORT).show();

                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }



    private Boolean validateInput(User user){
        if(user.getName().isEmpty()||user.getPassword().isEmpty()){
            return false;

    }
    return true;
}
}