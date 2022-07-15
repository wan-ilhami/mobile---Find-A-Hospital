package com.example.findahospital;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.findahospital.databinding.ActivityNearbyHospitalBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.Vector;

public class nearbyHospital extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    MarkerOptions marker;

    LatLng centerlocation;
    Vector<MarkerOptions> markerOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_hospital);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerlocation = new LatLng(3.045170,101.527060);

        markerOptions = new Vector<>();

        markerOptions.add(new MarkerOptions().title("Hospital Nilai")
                .position(new LatLng(2.81203,101.77309))
                .snippet("Open during MCO: 8am - 10pm")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Putrajaya")
                .position(new LatLng(2.92931,101.67418))
                .snippet("Open during MCO: 24 Hours")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Jasin")
                .position(new LatLng(2.3625, 102.4531))
                .snippet("Open during MCO: 8am - 6pm")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Alor Gajah")
                .position(new LatLng(5.29, 100.259))
                .snippet("Open during MCO: 8am - 6pm")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Bandaraya Melaka")
                .position(new LatLng(4.61, 101.88))
                .snippet("Open during MCO: 8am - 6pm")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Seksyen 7")
                .position(new LatLng(3.0723, 101.4909))
                .snippet("Open during MCO: 8am - 6pm")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Subang Jaya")
                .position(new LatLng(3.0798, 101.5938))
                .snippet("Open during MCO: 8am - 6pm")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Klang")
                .position(new LatLng(3.0202, 101.4399))
                .snippet("Open during MCO: 8am - 6pm")
        );markerOptions.add(new MarkerOptions().title("You Are Here")
                .position(new LatLng(3.045170, 101.527060))

        );


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        for (MarkerOptions mark: markerOptions) {
            mMap.addMarker(mark);
        }

        enableMyLocation();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation,8));
    }
    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(this, perms,200);
        }
    }

}