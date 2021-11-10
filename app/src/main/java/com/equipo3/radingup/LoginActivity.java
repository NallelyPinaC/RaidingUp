package com.equipo3.radingup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText mTextInputEmail;
    TextInputEditText getmTextInputPassword;
    Button mButtonLogin;

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mTextInputEmail = findViewById(R.id.textInputEmail);
        getmTextInputPassword  = findViewById(R.id.textInputPassword);
        mButtonLogin  = findViewById(R.id.btnLogin);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }

        });
    }
    private void login() {
    String email = mTextInputEmail.getText().toString();
    String password = getmTextInputPassword.getText().toString();

    if(!email.isEmpty() && !password.isEmpty()){
        if(password.length() >= 6){
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isComplete()){
                        Toast.makeText( LoginActivity.this, "El inicio de seion fue exitoso", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText( LoginActivity.this, "La Contraseña o el Correo son incorrecotos", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
        else {
            Toast.makeText( LoginActivity.this, "La Contraseña de tener mas 6 caracteres", Toast.LENGTH_SHORT).show();
        }
    }
    else {
        Toast.makeText( LoginActivity.this, "La Contraseña o el Correo son obligatorios", Toast.LENGTH_SHORT).show();
    }
    }
}
