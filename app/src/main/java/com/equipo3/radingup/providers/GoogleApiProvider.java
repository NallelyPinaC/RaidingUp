package com.equipo3.radingup.providers;

import android.content.Context;

import com.equipo3.radingup.R;
import com.google.android.gms.maps.model.LatLng;

import retrofit.IGoogleApi;
import retrofit.RetrofitClient;
import retrofit2.Call;

public class GoogleApiProvider {

    private Context context;

    public GoogleApiProvider(Context context){
        this.context = context;
    }
    public Call<String> getDirections(LatLng originLatLng, LatLng destinationLatLng){
        String baseurl= "https://maps.googleapis.com";
        String query = "/maps/api/directions/json?mode=driving&transit_routing_preferences=less_driving&"
                + "origin=" + originLatLng.latitude + "," + originLatLng.longitude + "&"
                + "destination=" + destinationLatLng.latitude + "," + destinationLatLng.longitude + "&"
                + "key=" + context.getResources().getString(R.string.google_maps_key);
        return RetrofitClient.getClient(baseurl).create(IGoogleApi.class).getDirections(baseurl + query);
    }
}
//https://maps.googleapis.com/maps/api/directions/json?mode=driving&transit_routing_preferences=less_driving&
