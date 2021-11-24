package com.equipo3.radingup.providers;

import com.equipo3.radingup.models.Client;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ClientProvider {

    DatabaseReference mDatabase;

    public ClientProvider() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child("User").child("Clients");
    }

    public Task<Void> create(Client client){
        Map<String, Object> map = new HashMap<>();
        map.put( "name", client.getName());
        map.put( "email", client.getEmail());
        return mDatabase.child(client.getId()).setValue(map);
    }
}
