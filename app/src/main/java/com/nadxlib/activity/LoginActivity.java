package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button con , sign , admin ;
    EditText mail,pass;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        con = findViewById(R.id.btn_cancel_save_edit);
        sign = findViewById(R.id.btn_update_edit_info);
        mail = findViewById(R.id.et_email_edit_kt);
        pass = findViewById(R.id.et_password_edit_kt);
        admin = findViewById(R.id.button3);

        mAuth = FirebaseAuth.getInstance();
        String tag = getIntent().getStringExtra("tag");


        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m = mail.getText().toString();
                String p = pass.getText().toString();

                mAuth.signInWithEmailAndPassword(m,p).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        if(tag.equals("user"))
                        {
                            startActivity(new Intent(getApplicationContext(),DetailActivity.class));
                        }if(tag.equals("doc")){
                            startActivity(new Intent(getApplicationContext(),AdminHome.class));
                        }

                    }
                });


            }
        });


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                intent.putExtra("target","users");
                startActivity(intent);
            }
        });


        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AdminLogin.class));
            }
        });

    }




}