package com.example.jetbrainskotlincommits.viewmodel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetbrainskotlincommits.R;

public class CustomViewHolder extends RecyclerView.ViewHolder{

    ImageView ivAuthorImage;
    TextView tvAuthorName, tvCommitTitle, tvCommitTimeDate;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        ivAuthorImage = itemView.findViewById(R.id.iv_author_image);
        tvAuthorName = itemView.findViewById(R.id.tv_author_name);
        tvCommitTitle = itemView.findViewById(R.id.tv_commit_title);
        tvCommitTimeDate = itemView.findViewById(R.id.tv_commit_timedate);
    }
}
