package com.soaconsultingonline.fastparking.activity;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.soaconsultingonline.fastparking.R;
import com.soaconsultingonline.fastparking.animation.BounceAnimation;
import com.soaconsultingonline.fastparking.database.vo.ParqueaderoVO;
import com.soaconsultingonline.fastparking.services.ConsultaParqueaderosService;
import com.soaconsultingonline.fastparking.services.FPProperties;

import java.util.LinkedList;
import java.util.List;

public class MapsActivityCurrentPlace extends Fragment implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private Marker mCurrLocationMarker;
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    //To store longitude and latitude from map
    private double longitude;
    private double latitude;

    List<ParqueaderoVO> parqueaderos = null;
    private AlertDialog alertDialog;
    private List<Circle> parkingCircles = new LinkedList<>();

    private final Handler mHandler;
    private Runnable mAnimation;

    private String parkingCode = null;

    OnDataPass dataPasser;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    }

    public void passData(String data) {
        dataPasser.onDataPass(data);
    }

    public MapsActivityCurrentPlace(){
        mHandler = new Handler();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Mensaje");
        alertDialog.setMessage("No se pudo cargar los Marcadores.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Posición Actual");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18));

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_maps_current, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_current);  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap map) {
                mMap = map;
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                //Initialize Google Play Services
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(getContext(),
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        buildGoogleApiClient();
                        map.setMyLocationEnabled(true);
                        map.getUiSettings().setMyLocationButtonEnabled(true);
                    }
                }
                else {
                    buildGoogleApiClient();
                    map.setMyLocationEnabled(true);
                    map.getUiSettings().setMyLocationButtonEnabled(true);
                }

                ConsultaParqueaderosService service = new ConsultaParqueaderosService(getActivity()) {
                    @Override
                    public void onResponseReceived(Object result) {
                        parqueaderos = (List<ParqueaderoVO>) result;
                        // Se adicionan los marcadores al mapa
                        if (parqueaderos != null && !parqueaderos.isEmpty()) {
                            for(ParqueaderoVO p : parqueaderos) {
                                if (p.getActivo() != null && p.getActivo().equalsIgnoreCase("S")) {
                                    LatLng mark = new LatLng(p.getLatitud().doubleValue(), p.getLongitud().doubleValue());
                                    CircleOptions circleoptions = new CircleOptions().strokeWidth(5).strokeColor(Color.BLUE).fillColor(Color.parseColor("#500084d3"));
                                    mMap.addMarker(new MarkerOptions().position(mark).title(p.getNombre() + ": " + p.getDireccion()));
                                    Circle circle = mMap.addCircle(circleoptions.center(mark).radius(50.0));
                                    parkingCircles.add(circle);
                                }
                            }
                        } else {
                            alertDialog.show();
                        }
                    }
                };

                try {
                    service.execute(FPProperties.getInstance(getActivity().getApplicationContext()).getProperty("ConsultaParqueaderosService"));
                } catch (Throwable t) {
                    Log.e("MapsActivityCurrent", t.getMessage(), t);
                }

            }
        });

        return rootView;
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(getContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        getCurrentLocation();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    //Getting current location
    private void getCurrentLocation() {
        Location location = null;
        mMap.clear();
        //Creating a location object
        if (checkLocationPermission())
            location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (location != null) {
            //Getting longitude and latitude
            longitude = location.getLongitude();
            latitude = location.getLatitude();

            //moving the map to location
            moveMap();
        }
    }

    //Function to move the map
    private void moveMap() {
        //String to display current latitude and longitude
        String msg = "lat: " + latitude + ", lon: " + longitude;

        //Creating a LatLng Object to store Coordinates
        LatLng latLng = new LatLng(latitude, longitude);

        //Adding marker to map
        mMap.addMarker(new MarkerOptions()
                .position(latLng) //setting position
                .draggable(true) //Making the marker draggable
                .title(msg)); //Adding a title

        //Moving the camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        //Animating the camera
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18));

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {

            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                ParqueaderoVO p;
                String msg = null;
                LatLng pos = marker.getPosition();
                longitude = pos.longitude;
                latitude = pos.latitude;
                // This causes the marker at Perth to bounce into position when it is clicked.
                final long start = SystemClock.uptimeMillis();
                final long duration = 1500L;

                // Cancels the previous animation
                mHandler.removeCallbacks(mAnimation);

                // Starts the bounce animation
                mAnimation = new BounceAnimation(start, duration, marker, mHandler);
                mHandler.post(mAnimation);

                p = searchParking(pos);

                if (p != null) {
                    parkingCode = p.getCodigoParqueadero();
                    msg = "Parqueadero: " + p.getNombre() + " [" + parkingCode + "]";
                } else {
                    parkingCode = "No Disponible";
                    msg = "Parqueadero: " + parkingCode;
                }

                passData(parkingCode);

                marker.hideInfoWindow();
                marker.setTitle(msg);
                marker.showInfoWindow();

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }
        });
    }

    /**
     * Check if a circle contains a point
     *
     * @param circle
     * @param point
     */
    private boolean isCircleContains(Circle circle, LatLng point) {
        double r = circle.getRadius();
        LatLng center = circle.getCenter();
        double cX = center.latitude;
        double cY = center.longitude;
        double pX = point.latitude;
        double pY = point.longitude;

        float[] results = new float[1];

        Location.distanceBetween(cX, cY, pX, pY, results);

        if(results[0] < r) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca el código del parqueadero
     *
     * @param point
     */
    private ParqueaderoVO searchParking(LatLng point) {
        ParqueaderoVO park = null;
        for (Circle c : parkingCircles) {
            if (isCircleContains(c, point)) {
                for(ParqueaderoVO p : parqueaderos) {
                    if (p.getLatitud().doubleValue() == c.getCenter().latitude && p.getLongitud().doubleValue() == c.getCenter().longitude) {
                        park = p;
                        break;
                    }
                }
                break;
            } else {
                park = null;
            }
        }
        return park;
    }

    public interface OnDataPass {
        public void onDataPass(String data);
    }
}
