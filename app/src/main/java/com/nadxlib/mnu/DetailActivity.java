package com.nadxlib.mnu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.smnadim21.api.SubscriptionStatusListener;

public class DetailActivity extends AppCompatActivity implements SubscriptionStatusListener {

    Button news,fixt,stan,trans;
    boolean flag=false;

    int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //button finding
        news = findViewById(R.id.button2);
        fixt = findViewById(R.id.button);
        stan = findViewById(R.id.button7);
        trans = findViewById(R.id.button8);

        //links
        final String link_news = "https://www.goal.com/en-in/team/"+getString(R.string.key)+"/"+getString(R.string.key_id);
        final String link_fixt = "https://www.goal.com/en-in/team/"+getString(R.string.key)+"/fixtures-results/"+getString(R.string.key_id);
        final String link_stan = "https://www.goal.com/en-in/team/"+getString(R.string.key)+"/table/"+getString(R.string.key_id);
        final String backuplink = "https://www.goal.com/en-in/team/";
        String link_tran_news = "https://www.goal.com/en-in/transfer-news";






         // button actions
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, WV.class);
                intent.putExtra("name", news.getText().toString());
                intent.putExtra("url", backuplink);
                startActivity(intent);
            }
        });

        fixt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, WV.class);
                intent.putExtra("name", fixt.getText().toString());
                intent.putExtra("url", backuplink);
                startActivity(intent);
            }
        });

        stan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onSuccess(boolean isSubscribed) {
        if (!isSubscribed) {
            flag = false;
        }
        else {
            flag = true;
        }
    }

    @Override
    public void onFailed(String message) {

    }
}