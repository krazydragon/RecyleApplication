package com.rbarnes.recyleapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ronaldo on 11/13/2014.
 */
public class RecycleViewHolder extends RecyclerView.ViewHolder{

    protected ImageView thumbnail;
    protected TextView title;

    public RecycleViewHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        this.title = (TextView) view.findViewById(R.id.title);
    }
}
