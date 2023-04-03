package com.example.td_android;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView pseudoView,scoreView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        pseudoView = itemView.findViewById(R.id.textview_pseudo);
        scoreView = itemView.findViewById(R.id.textview_score);
    }
}
