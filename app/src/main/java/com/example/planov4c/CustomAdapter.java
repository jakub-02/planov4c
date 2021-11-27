package com.example.planov4c;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList plan_id, plan_title, plan_priority, plan_time, plan_category;

    CustomAdapter(Activity activity, Context context, ArrayList plan_id, ArrayList plan_title, ArrayList plan_priority,
                  ArrayList plan_time, ArrayList plan_category){
        this.context = context;
        this.plan_id = plan_id;
        this.plan_title = plan_title;
        this.plan_priority = plan_priority;
        this.plan_time = plan_time;
        this.plan_category = plan_category;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.plan_title_txt.setText(String.valueOf(plan_title.get(position)));
    }

    @Override
    public int getItemCount() {
        return plan_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView plan_title_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            plan_title_txt = itemView.findViewById(R.id.plan_title_txt);
        }
    }
}
