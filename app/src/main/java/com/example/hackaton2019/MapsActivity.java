package com.example.hackaton2019;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1550;
    double mirailLat = 43.5752;
    double mirailLon = 1.401990000000069;
    double stadiumLat = 43.583212;
    double stadiumLon = 1.4308137;
    double ernestLat = 43.6217767;
    double ernestLon = 1.4144804;
    double quaiLat = 43.5945205;
    double quaiLon = 1.4510813;
    double reynerieLat = 43.5708;
    double reynerieLon = 1.4018899999999803;
    double arnaudLat = 43.6109;
    double arnaudLon = 1.439269999999965;
    double palaisLat = 43.5924;
    double palaisLon = 1.4444300000000112;
    double tontonLat = 43.6038;
    double tontonLon = 1.435799999999972;
    double capitoleLat = 43.6044;
    double capitoleLon = 1.4442599999999857;
    double abattoirsLat = 43.6007;
    double abattoirsLon = 1.4289899999999989;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        checkLocationPermission();
    }

    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission not granted : ask for it
            ActivityCompat.requestPermissions(MapsActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        } else {
            // Permission granted
        }
    }

    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
                } else {
                    // Permission denied
                }
                break;
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng toulouse = new LatLng(43.6, 1.433333);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(toulouse));
        float zoomLevel = 13.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(toulouse, zoomLevel));


        LatLng abbatoirs = new LatLng(abattoirsLat, abattoirsLon);
        LatLng capitole = new LatLng(capitoleLat, capitoleLon);
        LatLng quai = new LatLng(quaiLat, quaiLon);
        LatLng reynerie = new LatLng(reynerieLat, reynerieLon);
        LatLng arnaudB = new LatLng(arnaudLat, arnaudLon);
        LatLng palais = new LatLng(palaisLat, palaisLon);
        LatLng cherTonton = new LatLng(tontonLat, tontonLon);
        LatLng mirail = new LatLng(mirailLat, mirailLon);
        LatLng stadium = new LatLng(stadiumLat, stadiumLon);
        LatLng ernestWallon = new LatLng(ernestLat, ernestLon);

        mMap.addMarker(new MarkerOptions().position(abbatoirs).title("Royaume des érudies"));
        mMap.addMarker(new MarkerOptions().position(capitole).title("Place du Roi"));
        mMap.addMarker(new MarkerOptions().position(quai).title("Royaume des Chercheurs"));
        mMap.addMarker(new MarkerOptions().position(reynerie).title("Entrée du marché noir"));
        mMap.addMarker(new MarkerOptions().position(arnaudB).title("Place de l'orient"));
        mMap.addMarker(new MarkerOptions().position(palais).title("Jugement des scélérats"));
        mMap.addMarker(new MarkerOptions().position(cherTonton).title("Royaume des pochards"));
        mMap.addMarker(new MarkerOptions().position(mirail).title("Royaume des exhilées"));
        mMap.addMarker(new MarkerOptions().position(stadium).title("Royaume des Bipeds"));
        mMap.addMarker(new MarkerOptions().position(ernestWallon).title("Royaume des barbares"));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker){
                if (marker.getTitle().equals("Royaume des érudies")){
                    Intent intent1 = new Intent(MapsActivity.this,Enigme1Activity.class);
                    startActivity(intent1);
                }
                if (marker.getTitle().equals("Place du Roi")){
                    Intent intent1 = new Intent(MapsActivity.this,Enigme2Activity.class);
                    startActivity(intent1);
                }
                if (marker.getTitle().equals("Royaume des Chercheurs")){
                    Intent intent1 = new Intent(MapsActivity.this,Enigme3Activity.class);
                    startActivity(intent1);
                }
                if (marker.getTitle().equals("Entrée du marché noir")){
                    Intent intent1 = new Intent(MapsActivity.this,Enigme4Activity.class);
                    startActivity(intent1);
                }
                if (marker.getTitle().equals("Place de l'orient")){
                    Intent intent1 = new Intent(MapsActivity.this,Enigme5Activity.class);
                    startActivity(intent1);
                }
                if (marker.getTitle().equals("Jugement des scélérats")){
                    Intent intent1 = new Intent(MapsActivity.this,Enigme6Activity.class);
                    startActivity(intent1);
                }
                if (marker.getTitle().equals("Royaume des pochards")){
                    Intent intent1 = new Intent(MapsActivity.this,Enigme7Activity.class);
                    startActivity(intent1);
                }
                if (marker.getTitle().equals("Royaume des exhilées")){
                    Intent intent1 = new Intent(MapsActivity.this,Enigme8Activity.class);
                    startActivity(intent1);
                }
                if (marker.getTitle().equals("Royaume des Bipeds")){
                    Intent intent1 = new Intent(MapsActivity.this,Enigme9Activity.class);
                    startActivity(intent1);
                }
                if (marker.getTitle().equals("Royaume des barbares")){
                    Intent intent1 = new Intent(MapsActivity.this,Enigme10Activity.class);
                    startActivity(intent1);
                }

            }
        });

    }


}
