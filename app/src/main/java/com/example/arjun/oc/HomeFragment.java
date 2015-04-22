package com.example.arjun.oc;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.arjun.oc.adapter.RecyclerViewCardAdapter;
import com.example.arjun.oc.model.BrandCardData;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener {

    private static final String TAG = "HomeFragment";
    public List<BrandCardData> brandCardDatas = new ArrayList<BrandCardData>();
    Menu menu;
    MenuItem menuDoneItem;
    private SliderLayout mDemoSlider;
    private RecyclerView mRecyclerView, mRecyclerView1;
    private RecyclerView.Adapter mAdapter, mAdapter1;
    private RecyclerView.LayoutManager mLayoutManager, mLayoutManager1;
    private TextView mHotMore, mBigDiscMore, mDealMore, mNearMore, mRecentMore;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.v(TAG, "Home fragment");

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_first);
        mRecyclerView1 = (RecyclerView) rootView.findViewById(R.id.recycler_view_second);

        mDemoSlider = (SliderLayout) rootView.findViewById(R.id.slider);

        mHotMore = (TextView) rootView.findViewById(R.id.hot_more);
        mBigDiscMore = (TextView) rootView.findViewById(R.id.big_disc_more);
        mDealMore = (TextView) rootView.findViewById(R.id.deals_more);
        mNearMore = (TextView) rootView.findViewById(R.id.near_more);
        mRecentMore = (TextView) rootView.findViewById(R.id.recent_more);

        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mLayoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView1.setLayoutManager(mLayoutManager1);

        new AsyncParseTask().execute();

        HashMap<String, String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal", R.drawable.hannibal);
        file_maps.put("Big Bang Theory", R.drawable.bigbang);
        file_maps.put("House of Cards", R.drawable.house);
        file_maps.put("Game of Thrones", R.drawable.game_of_thrones);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);

        mHotMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TabActivity.class);
                startActivity(intent);
            }
        });

        mBigDiscMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TabActivity.class);
                startActivity(intent);
            }
        });

        mDealMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TabActivity.class);
                startActivity(intent);
            }
        });

        mNearMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TabActivity.class);
                startActivity(intent);
            }
        });

        mRecentMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TabActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onSliderClick(BaseSliderView baseSliderView) {

    }

    public class AsyncParseTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            getActivity().setProgressBarIndeterminateVisibility(true);
        }

        @Override
        protected Integer doInBackground(String... params) {

            Integer result = 0;
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Advertisement");
            List<ParseObject> list = null;
            try {
                list = query.find();
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            for (ParseObject score : list) {
                // This does not require a network access.
                ParseFile p = (ParseFile) score.get("Brand_image");
                if (p != null) {
                    BrandCardData b = new BrandCardData(score.getString("Brand"), score.getInt("Discount_percent"), p.getUrl());
                    brandCardDatas.add(b);
                    result = 1;
                    Log.d("viral", "retrieved a row " + score.get("Shop_name"));
                }
            }
            return result; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(Integer result) {
            getActivity().setProgressBarIndeterminateVisibility(false);
            /* Download complete. Lets update UI */
            if (result == 1) {
                mAdapter = new RecyclerViewCardAdapter(getActivity(), brandCardDatas);
                mAdapter1 = new RecyclerViewCardAdapter(getActivity(), brandCardDatas);
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView1.setAdapter(mAdapter1);
            } else {
                Log.e(TAG, "Failed to fetch data!");
            }
        }
    }
}
