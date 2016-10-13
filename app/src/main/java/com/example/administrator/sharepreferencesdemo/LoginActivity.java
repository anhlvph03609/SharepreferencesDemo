package com.example.administrator.sharepreferencesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword;

    String user,pass;
    Button btnLogin;
    Button btnReg;




    SessionManager session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        session = new SessionManager(getApplicationContext());
       if( session.checkLogin()){
           Intent intent = new Intent(LoginActivity.this, WellcomeActivity.class);
           startActivity(intent);
           finish();
        }

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        HashMap<String,String> detail = session.getUserDetails();
        user = detail.get(SessionManager.KEY_NAME);
        pass = detail.get(SessionManager.KEY_PASS);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnReg = (Button) findViewById(R.id.btnReg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();


                if(username.trim().length() > 0 && password.trim().length() > 0){

                    if(username.equals(user) && password.equals(pass)){


                        session.createLoginSession();

                        Toast.makeText(getApplicationContext(),"Successful login",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(LoginActivity.this, WellcomeActivity.class);
                        startActivity(i);
                        finish();

                    }else{

                        Toast.makeText(getApplicationContext(),"Login failed...",Toast.LENGTH_LONG).show();
                    }
                }else{

                    Toast.makeText(getApplicationContext(),"Please enter username and password!",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
