package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nadxlib.Adapters.PurchaseItemRecyclerViewAdapter;
import com.nadxlib.chatOption.ChatScreen;

import ayalma.ir.expandablerecyclerview.ExpandableRecyclerView;

public class DeiseasesActivity extends AppCompatActivity {

    Button symptomps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diseaseslistview);
        symptomps = findViewById(R.id.symptomps);
        ExpandableRecyclerView eRecyclerView = findViewById(R.id.purchase_list);
        String[] foo_array = getApplicationContext().getResources().getStringArray(R.array.WomensHealthStatement);
        String[] dN = getApplicationContext().getResources().getStringArray(R.array.dname);
        PurchaseItemRecyclerViewAdapter mPIAdapter = new PurchaseItemRecyclerViewAdapter(foo_array,dN); // purchaseItemAdapter
        eRecyclerView.setAdapter(mPIAdapter);


        symptomps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SymptomsActivity.class);
                startActivity(intent);
            }
        });

    }
}