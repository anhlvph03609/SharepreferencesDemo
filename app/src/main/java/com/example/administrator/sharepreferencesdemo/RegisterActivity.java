package com.example.administrator.sharepreferencesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edtUsername,edtEmail,edtPass;
    Button btnReg;
    SessionManager session;
    String username,email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        session = new SessionManager(getApplicationContext());
        edtUsername = (EditText) findViewById(R.id.txtUsername);
        edtEmail = (EditText) findViewById(R.id.txtEmail);
        edtPass = (EditText) findViewById(R.id.txtPassword);
        btnReg = (Button) findViewById(R.id.btnReg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = edtUsername.getText().toString();
                pass =  edtPass.getText().toString();
                email = edtEmail.getText().toString();
                if(username.equals("") || pass.equals("") || email.equals("")){
                    Toast.makeText(getApplicationContext(),"Please fill all feilds!",Toast.LENGTH_LONG).show();
                }
                else {
                    session.createAccount(username,email,pass);
                    Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
