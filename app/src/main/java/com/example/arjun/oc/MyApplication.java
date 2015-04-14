package com.example.arjun.oc;

/**
 * Created by Arjun on 4/14/2015.
 */
import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParsePush;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        Parse.enableLocalDatastore(this);
        Log.v("Viral", "Viral in application");
        Parse.initialize(this, "G2hRq7lVUKPXtQqOTotEjcMrKkNCdZhfMddGNcLC", "l3SDkDNVMN75S7b9Ou4GDYbiv8kckUbS2RW0lh6O");        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        ParseACL.setDefaultACL(defaultACL, true);
        ParsePush.subscribeInBackground("", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                } else {
                    Log.e("com.parse.push", "failed to subscribe for push", e);
                }
            }
        });
    }
}