package com.example.googlemapapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener {
    private GoogleMap gMap;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gMap = googleMap;
        LatLng m1 = new LatLng(37.7749, -122.4194);
        LatLng m2 = new LatLng(38.7749, -122.4194);
        LatLng m3 = new LatLng(39, -122.4194);
        LatLng m4 = new LatLng(42, -122.4194);


        gMap.addMarker(new MarkerOptions()
                .position(m1)
                .title("marker").draggable(true)
        );

        PolylineOptions polylineOptions = new PolylineOptions()
                .add(m1)
                .add(m2)
                .add(m3)
                .add(m4)
                ;
        Polyline polyline=gMap.addPolyline(polylineOptions);

//        gMap.setOnMarkerClickListener(this);
        gMap.setOnMarkerDragListener(this);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(m1));


    }


    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {

        Toast.makeText(this, "My Position: " + marker.getPosition().latitude, Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onMarkerDrag(@NonNull Marker marker) {
//        Toast.makeText(this, "Marker dragging ", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onMarkerDragEnd(@NonNull Marker marker) {
        Toast.makeText(this, "My Position: " + marker.getPosition().latitude, Toast.LENGTH_LONG).show();


    }

    @Override
    public void onMarkerDragStart(@NonNull Marker marker) {
//        Toast.makeText(this, "Start dragging ", Toast.LENGTH_LONG).show();


    }
}