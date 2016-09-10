package com.soaconsultingonline.fastparking.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.soaconsultingonline.fastparking.R;
import com.soaconsultingonline.fastparking.security.UserSessionManager;

import java.util.HashMap;

public class PersonalDataActivity extends AppCompatActivity {

    // User Session Manager Class
    private UserSessionManager session;
    // User Data
    private EditText nameField;
    private EditText emailField;
    private EditText birthdayField;
    private EditText celularField;
    private RadioGroup generoGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);
        // Session class instance
        session = new UserSessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();

        // Campos del Formulario
        nameField = (EditText) findViewById(R.id.nombreEditText);
        emailField = (EditText) findViewById(R.id.emailEditText);
        celularField = (EditText) findViewById(R.id.celularEditText);
        generoGroup = (RadioGroup) findViewById(R.id.generoRadios);
        birthdayField = (EditText) findViewById(R.id.cumpleEditText);

        // Llena los campos del formulario
        fillPersonalData(user);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void fillPersonalData(HashMap<String, String> usr) {
        TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        String number = tm.getLine1Number();
        nameField.setText(usr.get(UserSessionManager.KEY_NAME));
        emailField.setText(usr.get(UserSessionManager.KEY_EMAIL));
        celularField.setText(number != null && !number.isEmpty() ? number : "");
        if (usr.get(UserSessionManager.KEY_GENDER).equalsIgnoreCase("male"))
            generoGroup.check(R.id.hombreRadioButton);
        else
            generoGroup.check(R.id.mujerRadioButton);
        birthdayField.setText(usr.get(UserSessionManager.KEY_BDAY));
    }

}
