package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nadxlib.Adapters.PurchaseItemRecyclerViewAdapter;

import ayalma.ir.expandablerecyclerview.ExpandableRecyclerView;

public class PMC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_m_c);
        ExpandableRecyclerView eRecyclerView = findViewById(R.id.purchase_list);
        String[] foo_array = getApplicationContext().getResources().getStringArray(R.array.PregnantMotherCare);
        String[] dN = getApplicationContext().getResources().getStringArray(R.array.pmc);
        PurchaseItemRecyclerViewAdapter mPIAdapter = new PurchaseItemRecyclerViewAdapter(foo_array,dN); // purchaseItemAdapter
        eRecyclerView.setAdapter(mPIAdapter);
    }
}