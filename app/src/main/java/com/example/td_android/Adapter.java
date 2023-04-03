package com.example.td_android;
import com.example.td_android.DAO.CalculBaseHelper;
import com.example.td_android.DAO.CalculDao;
import com.example.td_android.entities.Score;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<Score> scores;

    public Adapter(Context context, List<Score> scores) {
        this.context = context;
        this.scores = scores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_score,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.pseudoView.setText(scores.get(position).getNom());
        holder.scoreView.setText(scores.get(position).getScore().toString());
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }
}
