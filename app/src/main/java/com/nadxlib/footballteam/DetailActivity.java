package com.nadxlib.footballteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailActivity extends AppCompatActivity {

    Button news,fixt,stan,trans;
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
        String link_tran_news = "https://www.goal.com/en-in/transfer-news";


        // ad intrigation


        // bd apps intrigation













        // button actions
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, WV.class);
                intent.putExtra("name", news.getText().toString());
                intent.putExtra("url", link_news);
                startActivity(intent);
            }
        });

        fixt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, WV.class);
                intent.putExtra("name", fixt.getText().toString());
                intent.putExtra("url", link_fixt);
                startActivity(intent);
            }
        });

        stan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, WV.class);
                intent.putExtra("name", stan.getText().toString());
                intent.putExtra("url", link_stan);
                startActivity(intent);
            }
        });

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, WV.class);
                intent.putExtra("name", fixt.getText().toString());
                intent.putExtra("url", link_fixt);
                startActivity(intent);
            }
        });

    }
}