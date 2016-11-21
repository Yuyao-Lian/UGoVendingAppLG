package com.ugosmoothie.ugovendingapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ugosmoothie.ugovendingapp.Data.CurrentSelection;
import com.ugosmoothie.ugovendingapp.WebServer.AsyncServer;

public class PurchaseSmoothie extends AppCompatActivity {

    private uGoViewPager m_uGoViewPage;
    private AsyncServer asyncServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_smoothie);
        SmoothiePagerAdapter mSmoothiePagerAdapter = new SmoothiePagerAdapter(getSupportFragmentManager());

        m_uGoViewPage = (uGoViewPager)findViewById(R.id.container);
        m_uGoViewPage.setAdapter(mSmoothiePagerAdapter);
        m_uGoViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                if (m_uGoViewPage.getCurrentItem() == 0 || m_uGoViewPage.getCurrentItem() > 4) {
                    findViewById(R.id.startOverButton).setVisibility(View.GONE);
                    findViewById(R.id.goBackButton).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.startOverButton).setVisibility(View.VISIBLE);
                    findViewById(R.id.goBackButton).setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        m_uGoViewPage.setSwipeEnabled(false);

        // start the AsyncServer
        asyncServer = AsyncServer.getInstance();
        asyncServer.registerListener(this, "complete");
        this.registerReceiver(receiver, new IntentFilter("complete"));
    }

    public uGoViewPager GetUGoViewPager() { return m_uGoViewPage; }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //String eventType = intent.getStringExtra("eventType");
            //if (eventType.equals(EventTypes.SmoothieEvent.Complete.getSmoothieEvent())) {
                // we finished a smoothie
            Toast.makeText(getApplicationContext(), "Your Order is ready!!", Toast.LENGTH_SHORT).show();
                //m_uGoViewPage.setCurrentItem(0);

            //}
        }
    };

    public void startOver_Click(View view) {
        CurrentSelection.getInstance().setCurrentSmoothie(null);
        CurrentSelection.getInstance().setCurrentLiquid(null);
        CurrentSelection.getInstance().setCurrentSupplement(null);
        m_uGoViewPage.setCurrentItem(0);
    }

    public void goBack_Click(View view) {
        m_uGoViewPage.setCurrentItem(m_uGoViewPage.getCurrentItem() - 1);
    }

}
