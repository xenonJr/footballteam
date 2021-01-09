package com.nadxlib.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.nadxlib.chatOption.PatientAdapter;
import com.nadxlib.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class DoctorInbox extends AppCompatActivity {

    FirebaseFirestore firebaseFirestore;
    DocumentReference documentReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_inbox);
        Log.d("patient","i am here");
        List<String> users = new ArrayList<>();
        List<String> ids = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.patient_list);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Patient p = document.toObject(Patient.class);
                                users.add(p.getFirstName() +" "+p.getLastName());
                                ids.add(document.getId());
                                Log.d("patient",p.getFirstName());

                            }
                            PatientAdapter patientAdapter = new PatientAdapter(getApplicationContext(),users,ids);
                            recyclerView.setAdapter(patientAdapter);

                        } else {
                            Log.d("patient","error");
                        }
                    }
                });



    }
}