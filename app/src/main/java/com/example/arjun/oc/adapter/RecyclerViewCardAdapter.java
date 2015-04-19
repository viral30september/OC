package com.example.arjun.oc.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arjun.oc.R;
import com.example.arjun.oc.model.BrandCardData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by SONY on 18-04-2015.
 */
public class RecyclerViewCardAdapter extends RecyclerView.Adapter<RecyclerViewCardAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewCardAdapter";
    private Context mContext;
    private List<BrandCardData> brandCardDatas;

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerViewCardAdapter(Context context, List<BrandCardData> brandCardDatas) {
        this.brandCardDatas = brandCardDatas;
        this.mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_detail, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Log.v(TAG, brandCardDatas.get(position).getBrandName() + brandCardDatas.get(position).getBrandDiscount());
        holder.mBrandName.setText(brandCardDatas.get(position).getBrandName());

        holder.mBrandDiscount.setText("" + brandCardDatas.get(position).getBrandDiscount() + "% discount");
        Picasso.with(mContext)
                .load(brandCardDatas.get(position).getBrandImageUrl())
                .placeholder(R.drawable.bird) // optional
                .error(R.drawable.bird)         // optional
                .into(holder.mBrandImage);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return brandCardDatas.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public CardView mCardView;
        public TextView mBrandName, mBrandDiscount;
        public ImageView mBrandImage;

        public ViewHolder(View v) {
            super(v);
            mCardView = (CardView) v.findViewById(R.id.card_view);
            mBrandName = (TextView) mCardView.findViewById(R.id.brandName);
            mBrandDiscount = (TextView) mCardView.findViewById(R.id.brandDiscount);
            mBrandImage = (ImageView) mCardView.findViewById(R.id.brandImage);

        }
    }
}