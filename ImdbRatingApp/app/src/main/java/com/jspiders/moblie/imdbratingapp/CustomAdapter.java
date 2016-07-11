package com.jspiders.moblie.imdbratingapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 11/07/2016.
 */
public class CustomAdapter extends RecyclerView.Adapter {

    Context ctx;
    CustomAdapter(Context ctx)
    {
        this.ctx = ctx;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(ctx).inflate(R.layout.row,null);

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class MyViewHolder extends  RecyclerView.ViewHolder
{
    TextView tvTitle;
    TextView tvExtra;
    ImageView ivPoster;

    public MyViewHolder(View itemView)
    {
        super(itemView);
    }
}
