package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nadxlib.chatOption.ChatScreen;

public class RealAdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_admin_login);
        EditText button = findViewById(R.id.et_password_edit_kt);
        Button button2 = findViewById(R.id.btn_cancel_save_edit);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getText().toString().equals("123456")){
                    Intent intent = new Intent(getApplicationContext(), RealAdminHomePage.class);
                    startActivity(intent);
                }

            }
        });



    }
}