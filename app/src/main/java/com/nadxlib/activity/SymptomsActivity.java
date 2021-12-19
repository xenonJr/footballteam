package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SymptomsActivity extends AppCompatActivity {

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private ImageView btnDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
        radioSexGroup=(RadioGroup)findViewById(R.id.radioGroup);

        btnDisplay=(ImageView)findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=radioSexGroup.getCheckedRadioButtonId();
                radioSexButton=(RadioButton)findViewById(selectedId);
              //  Toast.makeText(getApplicationContext(),,Toast.LENGTH_SHORT).show();
                String x = radioSexButton.getText().toString();

                int y = radioSexButton.getId();
                Intent intent = new Intent(getApplicationContext(), SymptomSearchResult.class);
                switch (y){
                    case R.id.radioButton:

                        intent.putExtra("name", "Your Symptoms match with : Heart disease");
                        startActivity(intent);
                        break;
                    case R.id.radioButton2:
                       // textView.setText("Your Symptoms match with : Breast cancer");
                       // Intent intent = new Intent(getApplicationContext(), SymptomSearchResult.class);
                        intent.putExtra("name", "Your Symptoms match with : Breast cancer");
                        startActivity(intent);
                        break;
                    case R.id.radioButton3:
                       // textView.setText("Your Symptoms match with : Autoimmune diseases");
                    //    Intent intent = new Intent(getApplicationContext(), SymptomSearchResult.class);
                        intent.putExtra("name", "Your Symptoms match with : Autoimmune diseases");
                        startActivity(intent);
                        break;
                    case R.id.radioButton4:
                      //  textView.setText("Your Symptoms match with : Osteoporosis");
                      //  Intent intent = new Intent(getApplicationContext(), SymptomSearchResult.class);
                        intent.putExtra("name", "Your Symptoms match with : Osteoporosis");
                        startActivity(intent);
                        break;
                    case R.id.radioButton5:
                      //  textView.setText("Your Symptoms match with : Melanoma");
                      //  Intent intent = new Intent(getApplicationContext(), SymptomSearchResult.class);
                        intent.putExtra("name", "Your Symptoms match with : Melanoma");
                        startActivity(intent);
                        break;
                    case R.id.radioButton6:
                      //  textView.setText("Your Symptoms match with : Type-2 diabetes");
                      //  Intent intent = new Intent(getApplicationContext(), SymptomSearchResult.class);
                        intent.putExtra("name", "Your Symptoms match with : Type-2 diabetes");
                        startActivity(intent);
                        break;
                    case R.id.radioButton7:
                     //   textView.setText("Your Symptoms match with : Blood pressure");
                      //  Intent intent = new Intent(getApplicationContext(), SymptomSearchResult.class);
                        intent.putExtra("name","Your Symptoms match with : Blood pressure" );
                        startActivity(intent);
                        break;
                    case R.id.radioButton8:
                      //  textView.setText("Your Symptoms match with : Depression");
                      //  Intent intent = new Intent(getApplicationContext(), SymptomSearchResult.class);
                        intent.putExtra("name", "Your Symptoms match with : Depression");
                        startActivity(intent);
                        break;
                    case R.id.radioButton9:
                        //textView.setText("Your Symptoms match with : Alzheimer’s disease");
                      //  Intent intent = new Intent(getApplicationContext(), SymptomSearchResult.class);
                        intent.putExtra("name", "Your Symptoms match with : Alzheimer’s disease");
                        startActivity(intent);
                        break;


                }

            }
        });
    }

    }
