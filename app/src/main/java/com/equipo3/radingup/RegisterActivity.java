package com.equipo3.radingup;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    SharedPreferences mPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mPref = getApplicationContext().getSharedPreferences("typeUser", MODE_PRIVATE);
        String selectedUser= mPref.getString("user","");

        Toast.makeText(this,"El valor selecionado fue " +selectedUser, Toast.LENGTH_SHORT).show();


    }
}
