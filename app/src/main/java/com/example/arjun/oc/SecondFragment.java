package com.example.arjun.oc;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arjun.oc.adapter.LinearRecyclerViewCardAdapter;
import com.example.arjun.oc.model.BrandCardData;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kushal on 21-04-2015.
 */
public class SecondFragment extends Fragment {

    private static final String TAG = "SecondFragment";
    public List<BrandCardData> brandCardDatas = new ArrayList<BrandCardData>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.v(TAG, "Second fragment");

        View rootView = inflater.inflate(R.layout.fragment_second, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_first);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        new AsyncParseTask().execute();

        return rootView;
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
                mAdapter = new LinearRecyclerViewCardAdapter(getActivity(), brandCardDatas);
                mRecyclerView.setAdapter(mAdapter);
            } else {
                Log.e(TAG, "Failed to fetch data!");
            }
        }
    }
}
