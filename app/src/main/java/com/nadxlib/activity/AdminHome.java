package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHome extends AppCompatActivity {

    Button patientList,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        patientList = findViewById(R.id.babyTodd);
        message = findViewById(R.id.message);





        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DoctorInbox.class);
                intent.putExtra("tag","doctors");
                startActivity(intent);
            }
        });
    }
}