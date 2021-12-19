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
        Log.d("name :::::: ", "TExt : "+name);
//        switch (name){
//            case "radioButton":
//                textView.setText("Your Symptoms match with : Heart disease");
//                break;
//            case "radioButton2":
//                textView.setText("Your Symptoms match with : Breast cancer");
//                break;
//            case "radioButton3":
//                textView.setText("Your Symptoms match with : Autoimmune diseases");
//                break;
//            case "radioButton4":
//                textView.setText("Your Symptoms match with : Osteoporosis");
//                break;
//            case "radioButton5":
//                textView.setText("Your Symptoms match with : Melanoma");
//                break;
//            case "radioButton6":
//                textView.setText("Your Symptoms match with : Type-2 diabetes");
//                break;
//            case "radioButton7":
//                textView.setText("Your Symptoms match with : Blood pressure");
//                break;
//            case "radioButton8":
//                textView.setText("Your Symptoms match with : Depression");
//                break;
//            case "radioButton9":
//                textView.setText("Your Symptoms match with : Alzheimer’s disease");
//                break;
//
//
//        }
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