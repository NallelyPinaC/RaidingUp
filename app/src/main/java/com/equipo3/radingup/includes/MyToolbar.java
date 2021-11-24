package com.equipo3.radingup.includes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.equipo3.radingup.R;

public class MyToolbar {

    public static void show(AppCompatActivity activity, String title, boolean upButton){
        Toolbar Toolbar = activity.findViewById(R.id.toolbar);
        activity.setSupportActionBar(Toolbar);
        activity.getSupportActionBar().setTitle(title);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
