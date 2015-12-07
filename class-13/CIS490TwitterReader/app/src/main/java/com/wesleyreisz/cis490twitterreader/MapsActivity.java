package com.wesleyreisz.cis490twitterreader;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        final LatLngBounds.Builder builder = new LatLngBounds.Builder();
        LatLng latLng;
        MarkerOptions marker;

        //drop a marker
        latLng =  new LatLng(38.215855, -85.761999);
        marker = new MarkerOptions();
        marker.position(latLng);
        marker.title("University of Louisville");
        mMap.addMarker(marker);
        builder.include(marker.getPosition());

        //drop another marker
        latLng =  new LatLng(38.211647, -85.762743);
        marker = new MarkerOptions();
        marker.position(latLng);
        marker.title("University of Louisville");
        mMap.addMarker(marker);
        builder.include(marker.getPosition());

        //drop another marker
        latLng =  new LatLng(38.204094, -85.800197);
        marker = new MarkerOptions();
        marker.position(latLng);
        marker.title("Dixie Hwy");
        mMap.addMarker(marker);
        builder.include(marker.getPosition());

        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {

            @Override
            public void onCameraChange(CameraPosition arg0) {
                // Move camera.
                int padding = 100; // offset from edges of the map in pixels
                LatLngBounds bounds = builder.build();
                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                mMap.animateCamera(cu);

                // Remove listener to prevent position reset on camera move.
                mMap.setOnCameraChangeListener(null);
            }
        });

        //see more examples here: https://github.com/wesreisz/NotMyMusic/blob/master/mobile/src/main/java/com/wesleyreisz/notmymusic/fragment/EventsFragment.java

    }
}
