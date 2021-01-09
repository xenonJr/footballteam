package com.nadxlib.chatOption;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.library.bubbleview.BubbleTextView;
import com.google.firebase.firestore.auth.User;
import com.nadxlib.activity.DoctorChats;
import com.nadxlib.activity.R;
import com.nadxlib.model.Patient;
import com.nadxlib.model.SingleChatMassage;

import java.util.List;

public class PatientAdapter extends  RecyclerView.Adapter<PatientAdapter.ViewHolder> {

    Context context;
    List<String> singleChatMassage;
    List<String> ids;


    public PatientAdapter(Context context, List<String> singleChatMassage,List<String> ids) {
        this.context = context;
        this.singleChatMassage = singleChatMassage;
        this.ids = ids;
    }



    @NonNull
    @Override
    public PatientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.activity_listview,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PatientAdapter.ViewHolder holder, int position) {
        Log.d("msg","i am here 2");
        holder.m_sender.setText(singleChatMassage.get(position));
        holder.m_sender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DoctorChats.class);
                intent.putExtra("uid",ids.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return singleChatMassage.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView m_sender;

        BubbleTextView m;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            m_sender = itemView.findViewById(R.id.textView);


        }
    }


}
