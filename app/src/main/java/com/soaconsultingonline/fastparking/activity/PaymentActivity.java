package com.soaconsultingonline.fastparking.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.QRCodeWriter;
import com.soaconsultingonline.fastparking.R;
import com.soaconsultingonline.fastparking.animation.TouchImageView;
import com.soaconsultingonline.fastparking.security.UserSessionManager;
import com.soaconsultingonline.fastparking.services.FPProperties;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class PaymentActivity extends AppCompatActivity {

    private Button pagarButton;
    private Button declinarPagoButton;
    private TextView liqTxtUsuario;
    private TextView liqTxtParqueadero;
    private TextView liqTxtFechaEntrada;
    private TextView liqTxtFechaSalida;
    private TextView liqTxtMinutos;
    private TextView liqTxtVlrMinuto;
    private TextView liqTxtSubtotal;
    private TextView liqTxtDescuento;
    private TextView liqTxtImpuestos;
    private TextView liqTxtTotal;
    private UserSessionManager session;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        final String usuario;
        final Date fechaEntrada = new Date();
        final Date fechaSalida = new Date();

        builder = new AlertDialog.Builder(PaymentActivity.this);

        //Ok Button
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        session = new UserSessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();

        liqTxtUsuario = (TextView) findViewById(R.id.liqTxtUsuario);
        usuario = user.get(UserSessionManager.KEY_EMAIL);
        liqTxtUsuario.setText(usuario);

        liqTxtParqueadero = (TextView) findViewById(R.id.liqTxtParqueadero);
        liqTxtParqueadero.setText("");

        liqTxtFechaEntrada = (TextView) findViewById(R.id.liqTxtFechaEntrada);
        liqTxtFechaEntrada.setText("");

        liqTxtFechaSalida = (TextView) findViewById(R.id.liqTxtFechaSalida);
        liqTxtFechaSalida.setText(df.format(fechaSalida));

        liqTxtMinutos = (TextView) findViewById(R.id.liqTxtMinutos);
        liqTxtMinutos.setText("");

        liqTxtVlrMinuto = (TextView) findViewById(R.id.liqTxtVlrMinuto);
        liqTxtVlrMinuto.setText("");

        liqTxtSubtotal = (TextView) findViewById(R.id.liqTxtSubtotal);
        liqTxtSubtotal.setText("");

        liqTxtDescuento = (TextView) findViewById(R.id.liqTxtDescuento);
        liqTxtDescuento.setText("");

        liqTxtImpuestos = (TextView) findViewById(R.id.liqTxtImpuestos);
        liqTxtImpuestos.setText("");

        liqTxtTotal = (TextView) findViewById(R.id.liqTxtTotal);
        liqTxtTotal.setText("");

        pagarButton = (Button) findViewById(R.id.pagarButton);
        pagarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View dialoglayout = inflater.inflate(R.layout.custom_dialog, null);
                TouchImageView imageView = dialoglayout.findViewById(R.id.imgPagoResultQr);
                Bitmap bmp = qrCodeGeneration(generateQRContent(fechaEntrada, usuario, ""));
                imageView.setImageBitmap(bmp);
                builder.setView(dialoglayout);
                builder.show();
            }
        });

        declinarPagoButton = (Button) findViewById(R.id.declinarPagoButton);
        declinarPagoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TouchImageView img = (TouchImageView) findViewById(R.id.imgPagoResultQr);
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
    public Bitmap qrCodeGeneration(String content) {
        QRCodeWriter writer = new QRCodeWriter();
        Bitmap bmp = null;
        try {
            BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 512, 512);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
        } catch (WriterException e) {
            Log.e("PaymentActivity", e.getMessage(), e);
        }
        return bmp;
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
        qrContent.append(FPProperties.getInstance(this.getApplicationContext()).getProperty("payparking.out.typ"));
        qrContent.append("|");
        qrContent.append("DAT=");
        qrContent.append("");
        qrContent.append("|");
        qrContent.append("USR=");
        qrContent.append(usuario);
        qrContent.append("|");
        qrContent.append("QTY=");
        qrContent.append("");
        qrContent.append("|");
        qrContent.append("UPR=");
        qrContent.append("");
        qrContent.append("|");
        qrContent.append("SUB=");
        qrContent.append("");
        qrContent.append("|");
        qrContent.append("TAX=");
        qrContent.append("");
        qrContent.append("|");
        qrContent.append("TOT=");
        qrContent.append("");
        qrContent.append("|");
        qrContent.append("IND=");
        qrContent.append(df.format(fechaEntrada));
        qrContent.append("|");
        qrContent.append("LAT=");
        qrContent.append("");
        qrContent.append("|");
        qrContent.append("LON=");
        qrContent.append("");
        qrContent.append("|");
        qrContent.append("PAC=");
        qrContent.append(parkingCode);
        return qrContent.toString();
    }

}
