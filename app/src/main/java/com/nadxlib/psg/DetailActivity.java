package com.nadxlib.psg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.smnadim21.api.BdApps;
import com.smnadim21.api.Constants;
import com.smnadim21.api.SubscriptionStatusListener;

public class DetailActivity extends AppCompatActivity implements SubscriptionStatusListener {

    Button news,fixt,stan,trans;
    boolean flag=false;
    AdView adView;
    int c = 0;
    InterstitialAd mInterstitialAd;
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
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.banner_id));
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.inter_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        // bd apps intrigation
        Constants.MSG_TEXT = "start"+ " "+ getString(R.string.keyword);
        Constants.APP_ID = getString(R.string.appid);
        Constants.APP_PASSWORD = getString(R.string.longpass);
        Constants.USSD = getString(R.string.ussd);
        BdApps.registerAPP();// use this method to register
        BdApps.checkSubscriptionStatus(this);

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
                if(!flag)// this line checks if the content is locked or not
                // your content is locked here
                {
                    //  BdApps.showDialog(MainActivity.this, MainActivity.this);
                    BdApps.showDialogUSSD(DetailActivity.this, DetailActivity.this);

                } else {
                    Intent intent = new Intent(DetailActivity.this, WV.class);
                    intent.putExtra("name",stan.getText().toString());
                    intent.putExtra("url",link_stan);
                    startActivity(intent);
                }
            }
        });

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c==0){
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                        Toast.makeText(getApplicationContext(),"Ad showed",Toast.LENGTH_LONG).show();
                        c++;
                    }
                }else{
                Intent intent = new Intent(DetailActivity.this, WV.class);
                intent.putExtra("name", trans.getText().toString());
                intent.putExtra("url", link_fixt);
                startActivity(intent);
            }
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