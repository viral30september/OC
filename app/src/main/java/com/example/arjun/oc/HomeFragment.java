package com.example.arjun.oc;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardViewNative;

public class HomeFragment extends Fragment implements View.OnClickListener{

    Intent intent = null;
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Enable Local Datastore.
/*        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "G2hRq7lVUKPXtQqOTotEjcMrKkNCdZhfMddGNcLC", "l3SDkDNVMN75S7b9Ou4GDYbiv8kckUbS2RW0lh6O");
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground(); */
        Log.v("Viral", "Viral in home fragment");

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Advertisement");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
        ParseObject testObject = new ParseObject("AbcObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
        //Create a Card
        Card card = new Card(getActivity(), R.layout.carddemo_example_inner_content);

        //Set the card inner text
        card.setTitle("Title");

        //Create a CardHeader
        CardHeader header = new CardHeader(getActivity());

        //Add Header to card
        card.addCardHeader(header);

        //Set card in the cardView
        CardViewNative cardView0 = (CardViewNative) rootView.findViewById(R.id.carddemo0);
        cardView0.setCard(card);

        CardViewNative cardView1 = (CardViewNative) rootView.findViewById(R.id.carddemo1);
        cardView1.setCard(card);

        CardViewNative cardView2 = (CardViewNative) rootView.findViewById(R.id.carddemo2);
        cardView2.setCard(card);

        CardViewNative cardView3 = (CardViewNative) rootView.findViewById(R.id.carddemo3);
        cardView3.setCard(card);

        CardViewNative cardView4 = (CardViewNative) rootView.findViewById(R.id.carddemo4);
        cardView4.setCard(card);

        CardViewNative cardView5 = (CardViewNative) rootView.findViewById(R.id.carddemo5);
        cardView5.setCard(card);

        CardViewNative cardView6 = (CardViewNative) rootView.findViewById(R.id.carddemo6);
        cardView6.setCard(card);

        CardViewNative cardView7 = (CardViewNative) rootView.findViewById(R.id.carddemo7);
        cardView7.setCard(card);

        CardViewNative cardView01 = (CardViewNative) rootView.findViewById(R.id.carddemo01);
        cardView01.setCard(card);

        CardViewNative cardView11 = (CardViewNative) rootView.findViewById(R.id.carddemo11);
        cardView11.setCard(card);

        CardViewNative cardView21 = (CardViewNative) rootView.findViewById(R.id.carddemo21);
        cardView21.setCard(card);

        CardViewNative cardView31 = (CardViewNative) rootView.findViewById(R.id.carddemo31);
        cardView31.setCard(card);

        CardViewNative cardView41 = (CardViewNative) rootView.findViewById(R.id.carddemo41);
        cardView41.setCard(card);

        CardViewNative cardView51 = (CardViewNative) rootView.findViewById(R.id.carddemo51);
        cardView51.setCard(card);

        CardViewNative cardView61 = (CardViewNative) rootView.findViewById(R.id.carddemo61);
        cardView61.setCard(card);

        CardViewNative cardView71 = (CardViewNative) rootView.findViewById(R.id.carddemo71);
        cardView71.setCard(card);

        CardViewNative cardView02 = (CardViewNative) rootView.findViewById(R.id.carddemo02);
        cardView02.setCard(card);

        CardViewNative cardView12 = (CardViewNative) rootView.findViewById(R.id.carddemo12);
        cardView12.setCard(card);

        CardViewNative cardView22 = (CardViewNative) rootView.findViewById(R.id.carddemo22);
        cardView22.setCard(card);

        CardViewNative cardView32 = (CardViewNative) rootView.findViewById(R.id.carddemo32);
        cardView32.setCard(card);

        CardViewNative cardView42 = (CardViewNative) rootView.findViewById(R.id.carddemo42);
        cardView42.setCard(card);

        CardViewNative cardView52 = (CardViewNative) rootView.findViewById(R.id.carddemo52);
        cardView52.setCard(card);

        CardViewNative cardView62 = (CardViewNative) rootView.findViewById(R.id.carddemo62);
        cardView62.setCard(card);

        CardViewNative cardView72 = (CardViewNative) rootView.findViewById(R.id.carddemo72);
        cardView72.setCard(card);

        CardViewNative cardView03 = (CardViewNative) rootView.findViewById(R.id.carddemo03);
        cardView03.setCard(card);

        CardViewNative cardView13 = (CardViewNative) rootView.findViewById(R.id.carddemo13);
        cardView13.setCard(card);

        CardViewNative cardView23 = (CardViewNative) rootView.findViewById(R.id.carddemo23);
        cardView23.setCard(card);

        CardViewNative cardView33 = (CardViewNative) rootView.findViewById(R.id.carddemo33);
        cardView33.setCard(card);

        CardViewNative cardView43 = (CardViewNative) rootView.findViewById(R.id.carddemo43);
        cardView43.setCard(card);

        CardViewNative cardView53 = (CardViewNative) rootView.findViewById(R.id.carddemo53);
        cardView53.setCard(card);

        CardViewNative cardView63 = (CardViewNative) rootView.findViewById(R.id.carddemo63);
        cardView63.setCard(card);

        CardViewNative cardView73 = (CardViewNative) rootView.findViewById(R.id.carddemo73);
        cardView73.setCard(card);

        CardViewNative cardView04 = (CardViewNative) rootView.findViewById(R.id.carddemo04);
        cardView04.setCard(card);

        CardViewNative cardView14 = (CardViewNative) rootView.findViewById(R.id.carddemo14);
        cardView14.setCard(card);

        CardViewNative cardView24 = (CardViewNative) rootView.findViewById(R.id.carddemo24);
        cardView24.setCard(card);

        CardViewNative cardView34 = (CardViewNative) rootView.findViewById(R.id.carddemo34);
        cardView34.setCard(card);

        CardViewNative cardView44 = (CardViewNative) rootView.findViewById(R.id.carddemo44);
        cardView44.setCard(card);

        CardViewNative cardView54 = (CardViewNative) rootView.findViewById(R.id.carddemo54);
        cardView54.setCard(card);

        CardViewNative cardView64 = (CardViewNative) rootView.findViewById(R.id.carddemo64);
        cardView64.setCard(card);

        CardViewNative cardView74 = (CardViewNative) rootView.findViewById(R.id.carddemo74);
        cardView74.setCard(card);

        TextView tv0 = (TextView) cardView0.findViewById(R.id.textView);
        tv0.setText("Nike");
        ImageView iv0 = (ImageView) cardView0.findViewById(R.id.imageView);
        iv0.setImageResource(R.drawable.nike);

        TextView tv1 = (TextView) cardView1.findViewById(R.id.textView);
        tv1.setText("Reebok");
        ImageView iv1 = (ImageView) cardView1.findViewById(R.id.imageView);
        iv1.setImageResource(R.drawable.reebok);

        cardView0.setOnClickListener(this);
        cardView1.setOnClickListener(this);
         
        return rootView;
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.carddemo0: /** Start a new Activity MyCards.java */
                intent = new Intent(getActivity(), StarInfo.class);
                intent.putExtra("name", "Nike");
                this.startActivity(intent);
                break;

            case R.id.carddemo1: /** Start a new Activity MyCards.java */
                intent = new Intent(getActivity(), StarInfo.class);
                intent.putExtra("name", "Reebok");
                this.startActivity(intent);
                break;
        }
    }
}
