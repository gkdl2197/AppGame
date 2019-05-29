package edu.android.appgame;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Double latitude;
    private Double longitude;
    private List<String> lon = new ArrayList<>();
    private List<String> lat = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        latitude = 37.4995367;
        longitude = 127.0293196;

        lon.add("37.4010515");
        lon.add("37.8757747");
        lon.add("37.3152792");
        lon.add("35.1769037");
        lon.add("35.858426");
        lon.add("35.1390306");
        lon.add("35.9566936");
        lon.add("36.31695");
        lon.add("35.1199772");
        lon.add("37.5753937");
        lon.add("36.6072128");
        lon.add("35.553459");
        lon.add("37.4510442");
        lon.add("34.9647111");
        lon.add("35.8458973");
        lon.add("33.4672038");
        lon.add("36.8405945");
        lon.add("36.6254650");

        lat.add("127.1069018");
        lat.add("127.7434086");
        lat.add("126.9872424");
        lat.add("128.096124");
        lat.add("129.1926408");
        lat.add("126.925715");
        lat.add("128.5621854");
        lat.add("127.4135268");
        lat.add("129.0153713");
        lat.add("126.9996372");
        lat.add("127.297771");
        lat.add("129.2998882");
        lat.add("126.7071661");
        lat.add("127.543154");
        lat.add("127.152679");
        lat.add("126.545580");
        lat.add("127.174167");
        lat.add("127.463801");

        StrictMode.enableDefaults();

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
        LatLng myLocation = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(myLocation).title("내 위치")).showInfoWindow();

        for (int i = 0; i < lat.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(lat.get(i)), Double.parseDouble(lon.get(i)))));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 16));

    }
}