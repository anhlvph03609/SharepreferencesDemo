package com.example.administrator.sharepreferencesdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class WellcomeActivity extends AppCompatActivity {
    TextView tvUsername,tvEmail;
    Button btnLogout;
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        btnLogout = (Button)findViewById(R.id.btnLogout);
        tvUsername = (TextView)  findViewById(R.id.tvName);
        tvEmail  = (TextView) findViewById(R.id.tvEmail);
        session = new SessionManager(getApplicationContext());
        HashMap<String,String> user = session.getUserDetails();
        tvUsername.setText(user.get(SessionManager.KEY_NAME));
        tvEmail.setText(user.get(SessionManager.KEY_EMAIL));
        //session.checkLogin();
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.logoutUser();
            }
        });
    }
}
