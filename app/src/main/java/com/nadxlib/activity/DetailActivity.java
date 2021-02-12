package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nadxlib.chatOption.ChatScreen;
import com.smnadim21.api.SubscriptionStatusListener;

public class DetailActivity extends AppCompatActivity implements SubscriptionStatusListener {

    Button babyTodd, womanHealth, babyName, contractDoctor;
    boolean flag=false;

    int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //button finding
        babyTodd = findViewById(R.id.babyTodd);
        womanHealth = findViewById(R.id.womanHealth);
        babyName = findViewById(R.id.babyName);
        contractDoctor = findViewById(R.id.contactDoctor);
        Button pmc = findViewById(R.id.pmc);
        Button nbc = findViewById(R.id.nbc);


        final String backuplink = "https://patient.info/doctor/pregnancy-due-date-calculator";
        String link_tran_news = "https://www.goal.com/en-in/transfer-news";



        pmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PMC.class));
            }
        });

        nbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),NewBornCare.class));
            }
        });



        womanHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DeiseasesActivity.class));
            }
        });


         // button actions
        babyTodd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, WV.class);
                intent.putExtra("name", "Pregnancy Calculator");
                intent.putExtra("url", backuplink);
                startActivity(intent);
            }
        });



        babyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, WV.class);
                intent.putExtra("name", babyTodd.getText().toString());
                intent.putExtra("url", "https://www.shutterfly.com/ideas/baby-name-generator/");
                startActivity(intent);
            }
        });

        contractDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChatScreen.class);
                intent.putExtra("tag","users");
                startActivity(intent);
            }
        });

    }

    @Override
    public void onSuccess(boolean isSubscribed) {
        if (!isSubscribed) {
            flag = false;
        }
        else {
            flag = true;
        }
    }

    @Override
    public void onFailed(String message) {

    }
}