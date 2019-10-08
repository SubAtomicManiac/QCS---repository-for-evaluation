package com.example.jetbrainskotlincommits.viewmodel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jetbrainskotlincommits.Database.CommitType;
import com.example.jetbrainskotlincommits.R;
import com.example.jetbrainskotlincommits.model.ResultsPojo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    ArrayList<ResultsPojo> dataSet;
    Context context;

    public CustomAdapter(Context context, ArrayList<ResultsPojo> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tvAuthorName.setText(dataSet.get(position).commit.author.name);
        holder.tvCommitTitle.setText(dataSet.get(position).commit.message);
        String dateYear = dataSet.get(position).commit.author.date.split("-")[0];
        String dateMonth = dataSet.get(position).commit.author.date.split("-")[1];
        String dateDay = dataSet.get(position).commit.author.date.split("-")[2];
        dateDay = dateDay.split("T")[0];
        String dateTime = dataSet.get(position).commit.author.date.split("T")[1];
        dateTime = dateTime.split("Z")[0];
        holder.tvCommitTimeDate.setText(dateMonth + "-" + dateDay + "-" + dateYear + " " + dateTime);
        if (dataSet.get(position).author != null){
            Glide.with(context).load(dataSet.get(position).author.avatarUrl).into(holder.ivAuthorImage);
            Log.d(TAG, "onBindViewHolder: " + dataSet.get(position).author.avatarUrl);
        } else {
            holder.ivAuthorImage.setImageResource(R.drawable.questionmark);
        }

    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
}
