package com.nadxlib.mnu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button con , sign , admin ;
    EditText mail,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        con = findViewById(R.id.btn_cancel_save_edit);
        sign = findViewById(R.id.btn_update_edit_info);
        mail = findViewById(R.id.et_email_edit_kt);
        pass = findViewById(R.id.et_password_edit_kt);
        admin = findViewById(R.id.button3);




        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m = mail.getText().toString();
                String p = pass.getText().toString();
                Toast.makeText(getApplicationContext(),m,Toast.LENGTH_LONG).show();
                if( m.matches(getString(R.string.user_mail))  && p.matches(getString(R.string.user_pass))  ){
                    startActivity(new Intent(getApplicationContext(),DetailActivity.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong email or Password",Toast.LENGTH_LONG).show();
                }

            }
        });


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));
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