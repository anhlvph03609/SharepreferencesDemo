package com.example.administrator.sharepreferencesdemo;

/**
 * Created by Administrator on 12/10/2016.
 */

import java.util.HashMap;

        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.content.SharedPreferences.Editor;

public class SessionManager {

    SharedPreferences pref;


    Editor editor;


    Context _context;


    int PRIVATE_MODE = 0;


    private static final String PREF_NAME = "LoginExample";


    private static final String IS_LOGIN = "IsLoggedIn";


    public static final String KEY_NAME = "name";


    public static final String KEY_EMAIL = "email";

    public static final String KEY_PASS = "password";
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void createLoginSession(){

        editor.putBoolean(IS_LOGIN, true);
        editor.commit();
    }

    public void createAccount(String name, String email,String pass){
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASS,pass);
        editor.commit();
    }

    public boolean checkLogin(){
        return pref.getBoolean(SessionManager.IS_LOGIN,false);

    }




    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();

        user.put(KEY_NAME, pref.getString(KEY_NAME, null));

        user.put(KEY_PASS,pref.getString(KEY_PASS,null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));


        return user;
    }


    public void logoutUser(){

        editor.clear();
        editor.commit();


        Intent i = new Intent(_context, LoginActivity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        _context.startActivity(i);
    }


    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
