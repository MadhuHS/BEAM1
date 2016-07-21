package com.jspiders.moblie.studentinfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.RealmResults;

/**
 * Created by user on 16/07/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter {

    Context ctx;
    RealmResults<Student> results;

    RecyclerAdapter(Context ctx, RealmResults<Student> results)
    {
        this.ctx = ctx;
        this.results = results;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View rowview = LayoutInflater.from(ctx).inflate(R.layout.row,null);
        return new StudentViewHolder(rowview) ;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        StudentViewHolder studentViewHolder = (StudentViewHolder) holder;
        studentViewHolder.tvname.setText(results.get(position).getName());
        studentViewHolder.tvemail.setText(results.get(position).getEmail());
        studentViewHolder.tvphone.setText(""+results.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}

class StudentViewHolder extends RecyclerView.ViewHolder
{
    TextView tvname,tvemail,tvphone;

    StudentViewHolder(View rowview)
    {
        super(rowview);

        tvname =(TextView) rowview.findViewById(R.id.tvname);
        tvemail =(TextView) rowview.findViewById(R.id.tvemail);
        tvphone =(TextView) rowview.findViewById(R.id.tvphone);




    }
}
