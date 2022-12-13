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

public class LoginActivity extends AppCompatActivity {

    EditText name,email,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        login =findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameText = name.getText().toString();
                String passwordText = password.getText().toString();
                if(nameText.isEmpty() || passwordText.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fill Fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    MyDatabase data = MyDatabase.getDatabase(getApplicationContext());
                    final UserDao userDao = data.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            User user =userDao.login(nameText,passwordText);
                            System.out.println(user);
                            if(user == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"Unvalid Credentials",Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }else{

                             //   startActivity(new Intent(LoginActivity.this,HomeActivity.class));

                                if(user.getName().contains("arbi")){
                                    Intent n =new Intent(LoginActivity.this, CardActivity.class);
                                    n.putExtra("username", user.getId().toString());
                                    startActivity(n);

                                }
                                else{
                                    startActivity(new Intent(LoginActivity.this, CalendarActivity.class));

                                }
                            }

                        //    startActivity(new Intent(LoginActivity.this,HomeActivity.class));

                        }
                    }).start();

                }
            }
        });
    }
}