package com.nadxlib.chatOption;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.library.bubbleview.BubbleTextView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.nadxlib.activity.R;
import com.nadxlib.model.Patient;
import com.nadxlib.model.SingleChatMassage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatScreen extends AppCompatActivity {


    DatabaseReference databaseReference;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    DocumentReference documentReference;
    DocumentReference documentReference2;

    String currentDate;
    String currentTime;
    String name;

    RecyclerView recyclerView;
    ChatAdapter myAdapter;

    EditText massage;
    ImageView submit_button;

    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_chat_layout);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        documentReference = firebaseFirestore.collection("users").document(firebaseAuth.getCurrentUser().getUid());
        documentReference2 = firebaseFirestore.collection("chats").document(firebaseAuth.getCurrentUser().getUid());


        currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());


        massage = findViewById(R.id.type_massage);
        submit_button = findViewById(R.id.submit_button);


         recyclerView = findViewById(R.id.list_of_message);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final Patient[] user = new Patient[1];
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user[0] = documentSnapshot.toObject(Patient.class);
                name = user[0].getFirstName()+ " "+ user[0].getLastName();

            }
        });


        UpdateChatList();






        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleChatMassage singleChatMassage = new SingleChatMassage(name,massage.getText().toString(),currentDate,currentTime);

                FirebaseDatabase.getInstance().getReference("chats").child(firebaseAuth.getCurrentUser().getUid()).child(String.valueOf(System.currentTimeMillis())).setValue(singleChatMassage);
                UpdateChatList();
            }
        });

    }

    private void UpdateChatList() {
        FirebaseDatabase.getInstance().getReference("chats").child(firebaseAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<SingleChatMassage> l = new ArrayList<>();
                if (snapshot.exists()){
                    for (DataSnapshot npsnapshot : snapshot.getChildren()){
                        SingleChatMassage r = npsnapshot.getValue(SingleChatMassage.class);
                        l.add(r);
                        Log.d("msg",r.getMessage());

                    }
//                    Log.d("msg after loop",l.get(2).getMessage());
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