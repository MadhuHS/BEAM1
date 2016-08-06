package com.jspiders.moblie.hospitallocator;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=12.9716,77.5946&radius=50000&type=restaurant&name=cruise&key=AIzaSyBD4Zet-h7nziG38zToYlEpJCg8vwsWSX4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        AsyncHttpClient client= new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String jsonresponse = new String(responseBody);
                Gson gson = new Gson();

                Response response = gson.fromJson(jsonresponse,Response.class);

                for (int i = 0 ; i<response.getResults().size();i++)
                {
                    double lat = response.getResults().get(i).getGeometry().getLocation().getLat();
                    double lng = response.getResults().get(i).getGeometry().getLocation().getLng();
                    String name = response.getResults().get(i).getName();

                    LatLng latLng = new LatLng(lat, lng);
                    mMap.addMarker(new MarkerOptions().position(latLng).title(name));
                    //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
