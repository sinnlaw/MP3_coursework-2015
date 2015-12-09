package com.sinnlaw.ching.muccoursework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.net.Inet4Address;

/**
 * Created by ching on 2015/11/24.
 */
public class mapScreen extends Activity implements View.OnClickListener{

    TextView mapScreenTitle;

    //creating map info
    GoogleMap theMap;
    LatLng latlngCentre = new LatLng(55.864237, -4.251806);
    String googleName;
    double Lat = 55.873580;
    double Lng = -4.282103;

    Button backButton;

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_screen);

        Intent iMainAct = getIntent();

        googleName = iMainAct.getStringExtra("mapScreenTitle");

        //setup textbox
        mapScreenTitle = (TextView) findViewById(R.id.choosenTitleBox);
        mapScreenTitle.setText(iMainAct.getStringExtra("mapScreenTitle"));

        //setup map
        SetUpMap();
        getLatLng();
        updateWaypoint();

        //setup button
        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(this);

    }

    public void SetUpMap()
    {
        theMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        if(theMap != null)
        {
            theMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlngCentre, 12));
            theMap.setMyLocationEnabled(true);
            theMap.getUiSettings().setCompassEnabled(true);
            theMap.getUiSettings().setMyLocationButtonEnabled(true);
            theMap.getUiSettings().setRotateGesturesEnabled(true);
        }
    }

    public void updateWaypoint()
    {
        String title = googleName;

        MarkerOptions maker = new MarkerOptions().title(title).position(new LatLng(Lat, Lng)).icon(BitmapDescriptorFactory.defaultMarker(210.f));
        theMap.addMarker(maker);
    }

    public void getLatLng()
    {
        switch (googleName)
        {
            case "Tiffneys Steakhouse":
                Lat = 55.873580;
                Lng = -4.282103;
                break;

            case "Gamba Seafood Restaurant":
                Lat =55.862663 ;
                Lng =-4.260965 ;
                break;

            case "Black Sheep Bistro":
                Lat = 55.872599;
                Lng = -4.268673;
                break;

            case "Sapori D'Italia":
                Lat = 55.826008;
                Lng = -4.257614;
                break;

            case  "111 by Nico":
                Lat = 55.888263;
                Lng = -4.306687;
                break;

            case  "Number 16":
                Lat = 55.870666;
                Lng = -4.298830;
                break;

            case "Cail Bruich":
                Lat = 55.877608;
                Lng = -4.289141;
                break;

            case "Riverhill Restaurant & Bar":
                Lat =55.860670;
                Lng = -4.255646;
                break;

            case "Bella Vita":
                Lat = 55.845879;
                Lng = -4.334377;
                break;

            case "Two Fat Ladies at the Buttery":
                Lat = 55.860847;
                Lng =-4.272053;
                break;

        }
    }

    @Override
    public void onClick(View view) {

        Intent restaurant_Screen = new Intent(getApplicationContext(), RestScreen.class);
        startActivity(restaurant_Screen);

    }

}
