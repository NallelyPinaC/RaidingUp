package com.equipo3.radingup.providers;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GeofireProvider {
    private DatabaseReference mDatabase;
    private GeoFire mGeofire;

    public GeofireProvider (){
        mDatabase = FirebaseDatabase.getInstance().getReference().child("active_drivers");
        mGeofire = new GeoFire(mDatabase);
    }
     public void saveLocation(String idDriver, LatLng latlnd){
        mGeofire.setLocation(idDriver, new GeoLocation(latlnd.latitude, latlnd.longitude));
     }

     public void removeLocation(String idDriver){
        mGeofire.removeLocation(idDriver);
     }

     public GeoQuery getActiveDrivers(LatLng latLng){
        GeoQuery geoQuery = mGeofire.queryAtLocation(new GeoLocation(latLng.latitude, latLng.longitude), 5);
        geoQuery.removeAllListeners();
        return geoQuery;
    }

}
