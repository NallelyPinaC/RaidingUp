package com.equipo3.radingup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class SelectOptionAuthActivity extends AppCompatActivity {

    Toolbar mToolbar;
    Button mButtonGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option_auth);
        mToolbar = findViewById(R.id.toolbar);

        getSupportActionBar().setTitle("seleccionar opcion");


    mButtonGoToLogin = findViewById(R.id.btnGoToLogin);
    mButtonGoToLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToLogin();
        }


    });
    }
    private void goToLogin() {
        Intent intent = new Intent(SelectOptionAuthActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}