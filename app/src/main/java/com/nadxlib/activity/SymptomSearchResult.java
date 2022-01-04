package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nadxlib.chatOption.ChatScreen;

public class SymptomSearchResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_search_result);
        String name = getIntent().getStringExtra("name");
        ImageView button2 = findViewById(R.id.button2);
        TextView textView = findViewById(R.id.textView5);


        textView.setText(name);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatScreen.class);
                intent.putExtra("tag","users");
                startActivity(intent);
            }
        });

    }
}