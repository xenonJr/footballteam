package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;

import com.nadxlib.Adapters.PurchaseItemRecyclerViewAdapter;

import ayalma.ir.expandablerecyclerview.ExpandableRecyclerView;

public class DeiseasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diseaseslistview);
        ExpandableRecyclerView eRecyclerView = findViewById(R.id.purchase_list);
        String[] foo_array = getApplicationContext().getResources().getStringArray(R.array.WomensHealthStatement);
        String[] dN = getApplicationContext().getResources().getStringArray(R.array.dname);
        PurchaseItemRecyclerViewAdapter mPIAdapter = new PurchaseItemRecyclerViewAdapter(foo_array,dN); // purchaseItemAdapter
        eRecyclerView.setAdapter(mPIAdapter);
    }
}