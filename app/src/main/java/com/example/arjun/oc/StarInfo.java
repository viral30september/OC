package com.example.arjun.oc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kushal on 29-03-2015.
 */
public class StarInfo extends Activity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starinfo);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textInfo = (TextView) findViewById(R.id.textInfo);
        textView.setText(name);

        switch (name){
            case "Nike":
                imageView.setImageResource(R.drawable.nike);
                textInfo.setText("Welcome to Nike. We have upto 50% discount on all products.");
                break;
            case "Reebok":
                imageView.setImageResource(R.drawable.reebok);
                textInfo.setText("Welcome to Reebok. We have upto 40% discount on all products.");
                break;
        }
    }
}
