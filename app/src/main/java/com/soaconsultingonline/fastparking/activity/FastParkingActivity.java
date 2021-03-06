package com.soaconsultingonline.fastparking.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;
import com.soaconsultingonline.fastparking.R;
import com.soaconsultingonline.fastparking.security.UserSessionManager;

import java.util.HashMap;

public class FastParkingActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MapsActivityCurrentPlace.OnDataPass {

    // User Session Manager Class
    private UserSessionManager session;
    private Button pagarBtn;
    private Button checkinBtn;
    private String parkingCode;

    @Override
    public void onDataPass(String data) {
        parkingCode = data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_parking);

        // Session class instance
        session = new UserSessionManager(getApplicationContext());
        // Check user login (this is the important point)
        // If User is not logged in , This will redirect user to LoginActivity
        // and finish current activity from activity stack.
        if(session.checkLogin())
            finish();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ProfilePictureView profilePictureView = (ProfilePictureView) navigationView.getHeaderView(0).findViewById(R.id.userProfilePicture);
        TextView userProfileName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.userProfileName);

        // Session class instance
        // session = new UserSessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        profilePictureView.setProfileId(user.get(UserSessionManager.KEY_ID));
        userProfileName.setText(user.get(UserSessionManager.KEY_NAME));

        pagarBtn = (Button) findViewById(R.id.pagarBtn);
        pagarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PaymentActivity.class));
            }
        });

        checkinBtn = (Button) findViewById(R.id.checkinBtn);
        checkinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CheckinActivity.class);
                intent.putExtra("parkingCode", parkingCode);
                startActivity(intent);
            }
        });

        addFragment(new MapsActivityCurrentPlace(), false, "Mapa");

    }

    @Override public void onConfigurationChanged(final Configuration newConfig) {
        // Ignore orientation change to keep activity from restarting
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.fast_parking, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.id) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_buy_parkings) {
            // Compra de Puntos
        } else if (id == R.id.nav_balance_parkings) {
            // Consulta Saldo de Puntos
        } else if (id == R.id.nav_history) {
            // Histórico de Pagos Realizados (Recargas)
            startActivity(new Intent(getApplicationContext(), PagoListActivity.class));
        } else if (id == R.id.nav_map) {
            // Consulta de Parquaderos
            startActivity(new Intent(getApplicationContext(), MapsActivity.class));
        } else if (id == R.id.nav_person) {
            // Datos Personales
            startActivity(new Intent(getApplicationContext(), PersonalDataActivity.class));
        } else if (id == R.id.nav_exit) {
            // Salir
            session.logoutUser();
        }  else if (id == R.id.nav_share) {
            // Compartir
        } else if (id == R.id.nav_ask) {
            // Hablemos
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.container_map, fragment, tag);
        ft.commitAllowingStateLoss();
    }
}
