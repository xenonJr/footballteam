package com.nadxlib.chatOption;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.library.bubbleview.BubbleTextView;
import com.nadxlib.activity.R;
import com.nadxlib.model.SingleChatMassage;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    Context context;
    List<SingleChatMassage> singleChatMassage;

    public ChatAdapter(Context context, List<SingleChatMassage> singleChatMassage) {
        this.context = context;
        this.singleChatMassage = singleChatMassage;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.chat_list,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("msg","i am here 2");
        holder.m_sender.setText(singleChatMassage.get(position).getName());
        Log.d("msg","NAme : " +singleChatMassage.get(position).getMessage());
        holder.m_time.setText(singleChatMassage.get(position).getDate()+"   "+singleChatMassage.get(position).getTime());
        holder.m.setText(singleChatMassage.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return singleChatMassage.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView m_sender, m_time;

        BubbleTextView m;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
                m_sender = itemView.findViewById(R.id.message_user);
                m_time = itemView.findViewById(R.id.message_time);
                m = itemView.findViewById(R.id.message_text);

        }
    }
}
