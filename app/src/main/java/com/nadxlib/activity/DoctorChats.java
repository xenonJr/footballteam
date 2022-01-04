package com.nadxlib.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nadxlib.chatOption.ChatAdapter;
import com.nadxlib.model.Patient;
import com.nadxlib.model.SingleChatMassage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DoctorChats extends AppCompatActivity {

    DatabaseReference databaseReference;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    DocumentReference documentReference;
    DocumentReference documentReference2;

    String currentDate;
    String currentTime;
    String name;
    String mail;

    RecyclerView recyclerView;
    ChatAdapter myAdapter;
    String uiD;
    EditText massage;
    ImageView submit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newchat);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        String me = getIntent().getStringExtra("tag");
        Log.d("tag",me);
        documentReference = firebaseFirestore.collection(me).document(firebaseAuth.getCurrentUser().getUid());

        documentReference2 = firebaseFirestore.collection("chats").document(firebaseAuth.getCurrentUser().getUid());
        uiD = getIntent().getStringExtra("uid");
        documentReference2 = firebaseFirestore.collection("users").document(uiD);
        currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());


        massage = findViewById(R.id.type_massage);
        submit_button = findViewById(R.id.submit_button);


        recyclerView = findViewById(R.id.list_of_message);
        ImageView pres = findViewById(R.id.prescription);
        pres.setVisibility(View.VISIBLE);
        pres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("email",mail);
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"+mail)); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, mail);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Your Prescription");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final Patient[] user = new Patient[1];
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user[0] = documentSnapshot.toObject(Patient.class);
                name = user[0].getFirstName()+ " "+ user[0].getLastName();
            }
        });

        final Patient[] user2 = new Patient[1];
        documentReference2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user2[0] = documentSnapshot.toObject(Patient.class);
                mail = user2[0].getEmail();
            }
        });






        UpdateChatList();
        
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleChatMassage singleChatMassage = new SingleChatMassage(name,massage.getText().toString(),currentDate,currentTime);
                FirebaseDatabase.getInstance().getReference("chats").child(uiD).child(String.valueOf(System.currentTimeMillis())).setValue(singleChatMassage);
                UpdateChatList();
            }
        });

    }

    private void UpdateChatList() {
        FirebaseDatabase.getInstance().getReference("chats").child(uiD).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<SingleChatMassage> l = new ArrayList<>();
                if (snapshot.exists()){
                    for (DataSnapshot npsnapshot : snapshot.getChildren()){
                        SingleChatMassage r = npsnapshot.getValue(SingleChatMassage.class);
                        l.add(r);
                        Log.d("msg",r.getMessage());
                    }

                    myAdapter = new ChatAdapter(getApplicationContext(),l);
                    Log.d("msg","i am here");
                    Log.d("msg","L SIZE IS "+l.size());
                    recyclerView.setAdapter(myAdapter);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}