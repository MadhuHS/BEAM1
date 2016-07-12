package com.jspiders.moblie.imdbratingapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by user on 11/07/2016.
 */
public class CustomAdapter extends RecyclerView.Adapter {

    Context ctx;
    ArrayList<Response.Search> list;

    CustomAdapter(Context ctx, ArrayList<Response.Search> list)
    {
        this.ctx = ctx;
        this.list = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(ctx).inflate(R.layout.row,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.tvTitle.setText(list.get(position).getTitle());
        myViewHolder.tvExtra.setText(list.get(position).getType());
        Picasso.with(ctx).load(list.get(position).getPoster()).into(myViewHolder.ivPoster);

    }

    @Override
    public int getItemCount() {
        return list.size();
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
        tvTitle = (TextView) itemView.findViewById(R.id.tvmuvTitle);
        tvExtra = (TextView) itemView.findViewById(R.id.tvextra);
        ivPoster = (ImageView) itemView.findViewById(R.id.ivposter);

    }


}
