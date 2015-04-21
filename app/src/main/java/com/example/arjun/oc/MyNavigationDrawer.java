package com.example.arjun.oc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;

/**
 * Created by Kushal on 20-04-2015.
 */
public class MyNavigationDrawer extends MaterialNavigationDrawer {
    @Override
    public void init(Bundle savedInstanceState) {

        // create and set the header
        View view = LayoutInflater.from(this).inflate(R.layout.custom_drawer, null);
        setDrawerHeaderCustom(view);

        // create sections
        this.addSection(newSection("Home", R.drawable.ic_home, new HomeFragment()));
        this.addSection(newSection("Electronics", R.drawable.ic_communities, new ElecronicsFragment()).setSectionColor(Color.parseColor("#9c27b0")));
        this.addSection(newSection("Life Style", new LifeStyleFragment()));
        // create bottom section
        this.addBottomSection(newSection("Bottom Section", R.drawable.ic_settings_black_24dp, new Intent(this, Settings.class)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return super.onCreateOptionsMenu(menu);
    }
}