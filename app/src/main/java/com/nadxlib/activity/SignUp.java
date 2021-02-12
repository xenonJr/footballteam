package com.nadxlib.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.nadxlib.model.Patient;
import com.nadxlib.model.SingleChatMassage;

import java.util.ArrayList;
import java.util.HashMap;

public class SignUp extends AppCompatActivity {

    EditText Fname,password,phoneNumber,Lname,email;
    private FirebaseAuth mAuth;
    private FirebaseAuth me;
    DatabaseReference databaseReference;

    String uid,target;
    Button signup;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        Fname = findViewById(R.id.et_first_name_edit_kt);
        password = findViewById(R.id.et_password_edit_kt);
        phoneNumber=findViewById(R.id.et_phone_number_edit_kt);
        Lname =findViewById(R.id.et_last_name_edit_kt);
        email = findViewById(R.id.et_email_edit_kt);
        signup = findViewById(R.id.btn_update_edit_info);
        target = getIntent().getStringExtra("target");
        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }

    private void register() {
        final String mail = email.getText().toString();
        final String pass = password.getText().toString();
        final String nameBar = Fname.getText().toString();
        final String phone =phoneNumber.getText().toString();
        final String address2 = Lname.getText().toString();
       // final int p = Integer.parseInt(phone);

        if(mail.isEmpty()){
            email.setError("Enter mail");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            email.setError("Enter proper mail");
            email.requestFocus();
            return;
        }
        if(pass.isEmpty() || pass.length() < 6){
            password.setError("Proper Pass");
            password.requestFocus();
            return;
        }
        //  final Doner doner = new Doner(nameBar,jelaBAr,blood[0],p);
        ///i work
        final Patient Dprofile = new Patient(nameBar,address2, phone, mail,pass);

        mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //  p.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    uid = mAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = firebaseFirestore.collection(target).document(uid);
                    documentReference.set(Dprofile).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Succefull", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Data input Not Succefull"+e,Toast.LENGTH_SHORT).show();
                        }
                    });
                    finish();
                    Intent intent = new Intent(getApplicationContext(), home.class);
                    // intent.putExtra(MainActivity.EMAIL,pass);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"NOt Succefull",Toast.LENGTH_SHORT).show();
                }
            }
        });
        

    }


}