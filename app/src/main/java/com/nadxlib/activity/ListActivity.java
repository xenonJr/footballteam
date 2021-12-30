package com.nadxlib.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.nadxlib.chatOption.PatientAdapter;
import com.nadxlib.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    FirebaseFirestore firebaseFirestore;
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);





        List<String> users = new ArrayList<>();
        l = findViewById(R.id.list);

        firebaseFirestore = FirebaseFirestore.getInstance();
        String me = getIntent().getStringExtra("tag");

        firebaseFirestore.collection(me)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Patient p = document.toObject(Patient.class);
                                users.add(p.getFirstName() +" "+p.getLastName());
                                Log.d("patient",p.getFirstName());

                            }
                            ArrayAdapter arr;
                            arr = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,users);
                            l.setAdapter(arr);

                        } else {
                            Log.d("patient","error");
                        }
                    }
                });

    }
}