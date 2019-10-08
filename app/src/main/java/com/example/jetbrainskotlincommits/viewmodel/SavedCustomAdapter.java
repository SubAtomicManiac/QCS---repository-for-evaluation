package com.example.jetbrainskotlincommits.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jetbrainskotlincommits.Database.CommitType;
import com.example.jetbrainskotlincommits.R;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SavedCustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    CommitType profileType;
    private List<CommitType> dataSet;
    Context context;

    public SavedCustomAdapter(Context context, List<CommitType> dataSet, CommitType profileType ) {
        this.context = context;
        this.dataSet = dataSet;
        this.profileType = profileType;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tvAuthorName.setText(dataSet.get(position).name);
        holder.tvCommitTitle.setText(dataSet.get(position).message);
        Glide.with(context).load(dataSet.get(position).photo).into(holder.ivAuthorImage);
        holder.tvCommitTimeDate.setText(dataSet.get(position).date);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
}