package com.soaconsultingonline.fastparking.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.QRCodeWriter;
import com.soaconsultingonline.fastparking.R;
import com.soaconsultingonline.fastparking.security.UserSessionManager;
import com.soaconsultingonline.fastparking.services.FPProperties;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CheckinActivity extends AppCompatActivity {

    private Button generarEntradaBtn;
    private Button declinarEntradaBtn;
    private TextView checkinTxtUsuario;
    private TextView checkinTxtParqueadero;
    private TextView checkinTxtFecha;
    private TextView checkinTxtVlrMin;
    private UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        final Date fechaEntrada = new Date();
        final String usuario;
        final String parkingCode;

        session = new UserSessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();

        checkinTxtUsuario = (TextView) findViewById(R.id.checkinTxtUsuario);
        usuario = user.get(UserSessionManager.KEY_EMAIL);
        checkinTxtUsuario.setText(usuario);

        checkinTxtParqueadero = (TextView) findViewById(R.id.checkinTxtParqueadero);
        parkingCode = getIntent().getStringExtra("parkingCode");
        checkinTxtParqueadero.setText(parkingCode);

        checkinTxtFecha = (TextView) findViewById(R.id.checkinTxtFecha);
        checkinTxtFecha.setText(df.format(fechaEntrada));

        checkinTxtVlrMin = (TextView) findViewById(R.id.checkinTxtVlrMin);
        checkinTxtVlrMin.setText("");

        generarEntradaBtn = (Button) findViewById(R.id.aceptCheckinButton);
        generarEntradaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrCodeGeneration(generateQRContent(fechaEntrada, usuario, parkingCode));
            }
        });

        declinarEntradaBtn = (Button) findViewById(R.id.cancelCheckinButton);
        declinarEntradaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            String re = scanResult.getContents();
        }
    }

    @Override public void onConfigurationChanged(final Configuration newConfig) {
        // Ignore orientation change to keep activity from restarting
        super.onConfigurationChanged(newConfig);
    }

    /**
     * Genera código QR
     *
     * @param content
     */
    public void qrCodeGeneration(String content) {
        QRCodeWriter writer = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 512, 512);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
            ((ImageView) findViewById(R.id.imgResultQr)).setImageBitmap(bmp);

        } catch (WriterException e) {
            Log.e("CheckinActivity", e.getMessage(), e);
        }
    }

    /**
     * Genera el contenido del código QR
     *
     * @param parkingCode
     * @param fechaEntrada
     * @param usuario
     *
     * @return
     */
    public String generateQRContent(Date fechaEntrada, String usuario, String parkingCode) {
        StringBuffer qrContent = new StringBuffer();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        qrContent.append("APP=");
        qrContent.append(FPProperties.getInstance(this.getApplicationContext()).getProperty("payparking.app"));
        qrContent.append("|");
        qrContent.append("VER=");
        qrContent.append(FPProperties.getInstance(this.getApplicationContext()).getProperty("payparking.ver"));
        qrContent.append("|");
        qrContent.append("TYP=");
        qrContent.append(FPProperties.getInstance(this.getApplicationContext()).getProperty("payparking.in.typ"));
        qrContent.append("|");
        qrContent.append("DAT=");
        qrContent.append(df.format(fechaEntrada));
        qrContent.append("|");
        qrContent.append("USR=");
        qrContent.append(usuario);
        qrContent.append("|");
        qrContent.append("PAC=");
        qrContent.append(parkingCode);
        return qrContent.toString();
    }

}
