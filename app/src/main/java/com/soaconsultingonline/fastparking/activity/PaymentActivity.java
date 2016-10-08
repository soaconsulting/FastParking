package com.soaconsultingonline.fastparking.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.soaconsultingonline.fastparking.R;

public class PaymentActivity extends AppCompatActivity {

    private Button mButton;
    private TextView barCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Scanner
        barCode = (TextView) findViewById(R.id.barCodeTextView);
        mButton = (Button) findViewById(R.id.scanButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(PaymentActivity.this);
                integrator.initiateScan();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            String re = scanResult.getContents();
            barCode.setText(re);
        }
    }

    @Override public void onConfigurationChanged(final Configuration newConfig) {
        // Ignore orientation change to keep activity from restarting
        super.onConfigurationChanged(newConfig);
    }
}
