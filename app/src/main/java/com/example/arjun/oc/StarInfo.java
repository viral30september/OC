package com.example.arjun.oc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kushal on 29-03-2015.
 */
public class StarInfo extends Activity {

    String brandName;
    int position;

    ImageView imageView;
    TextView textView, textInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starinfo);

        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        textInfo = (TextView) findViewById(R.id.textInfo);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            brandName = extras.getString("brandName");
            position = extras.getInt("position");
        }
    }

}
