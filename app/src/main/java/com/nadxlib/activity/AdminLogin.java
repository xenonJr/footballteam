package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    Button con , sign , admin ,aSignup ;
    EditText mail,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        con = findViewById(R.id.btn_cancel_save_edit);
        mail = findViewById(R.id.et_email_edit_kt);
        pass = findViewById(R.id.et_password_edit_kt);
        admin = findViewById(R.id.button3);
        aSignup = findViewById(R.id.button3);

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m = mail.getText().toString();
                String p = pass.getText().toString();
                Toast.makeText(getApplicationContext(),m,Toast.LENGTH_LONG).show();
                if( m.matches(getString(R.string.admin_mail))  && p.matches(getString(R.string.admin_pass))  ){
                    startActivity(new Intent(getApplicationContext(),AdminHome.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong email or Password",Toast.LENGTH_LONG).show();
                }

            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        aSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                intent.putExtra("target","doctors");
                startActivity(intent);
            }
        });


    }
}