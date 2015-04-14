package com.example.arjun.oc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by Kushal on 13-04-2015.
 */
public class CustomCard extends Card {

    protected ImageView mImageView;
    protected TextView mTitle;
    protected TextView mSecondaryTitle;

    /**
     * Constructor with a custom inner layout
     * @param context
     */
    public CustomCard(Context context) {
        this(context, R.layout.carddemo_example_inner_content);
    }

    /**
     *
     * @param context
     * @param innerLayout
     */
    public CustomCard(Context context, int innerLayout) {
        super(context, innerLayout);
        init();
    }

    /**
     * Init
     */
    private void init(){

        //No Header

        //Set a OnClickListener listener
        setOnClickListener(new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getContext(), "Click Listener card=", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        //Retrieve elements
        mImageView = (ImageView) parent.findViewById(R.id.imageView);
        mTitle = (TextView) parent.findViewById(R.id.textView);
        mSecondaryTitle = (TextView) parent.findViewById(R.id.textView1);


        if (mTitle!=null)
            mTitle.setText("Company");

        if (mSecondaryTitle!=null)
            mSecondaryTitle.setText("Discount");

    }
}
