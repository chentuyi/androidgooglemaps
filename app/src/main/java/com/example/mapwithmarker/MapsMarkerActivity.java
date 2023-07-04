// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.example.mapwithmarker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.zip.Inflater;

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
// [START maps_marker_on_map_ready]
public class MapsMarkerActivity extends AppCompatActivity
        implements OnMapReadyCallback, View.OnClickListener{
    private Button button1, button2, button3;
    // [START_EXCLUDE]
    // [START maps_marker_get_map_async]
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);


        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        // Get the SupportMapFragment and request notification when the map is ready to be used.


//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
    }
    // [END maps_marker_get_map_async]
    // [END_EXCLUDE]

    // [START_EXCLUDE silent]
    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user receives a prompt to install
     * Play services inside the SupportMapFragment. The API invokes this method after the user has
     * installed Google Play services and returned to the app.
     */
    // [END_EXCLUDE]
    // [START maps_marker_on_map_ready_add_marker]
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // [START_EXCLUDE silent]
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        // [END_EXCLUDE]
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions()
            .position(sydney)
            .title("Marker in Sydney"));
        // [START_EXCLUDE silent]
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        // [END_EXCLUDE]
    }
    // [END maps_marker_on_map_ready_add_marker]

    @Override
    public void onClick(View v) {
        Fragment fragment;

        switch (v.getId()) {
            case R.id.button1:
                fragment = new Fragment1();
                loadFragment(fragment);
                break;
//            case R.id.button2:
//                fragment = new Fragment2();
//                loadFragment(fragment);
//                break;
//            case R.id.button3:
//                fragment = new Fragment3();
//                loadFragment(fragment);
//                break;
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
// [END maps_marker_on_map_ready]
