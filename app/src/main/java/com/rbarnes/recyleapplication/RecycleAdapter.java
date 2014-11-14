package com.rbarnes.recyleapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ronaldo on 11/13/2014.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleViewHolder>{

    private List<RecycleViewData> recycleViewList;
    private Context mContext;

    public RecycleAdapter(Context context, List<RecycleViewData> recycleViewList) {
        this.recycleViewList = recycleViewList;
        this.mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View recycleView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_row, null);

        // create ViewHolder

        RecycleViewHolder recycleViewHolder = new RecycleViewHolder(recycleView);
        return recycleViewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecycleViewHolder recycleViewHolder, int position) {

        RecycleViewData rvd = recycleViewList.get(position);
        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        recycleViewHolder.title.setText(rvd.getTitle());



    }




    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return (null != recycleViewList ? recycleViewList.size() : 0);
    }





}
