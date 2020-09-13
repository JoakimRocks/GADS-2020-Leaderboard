package com.example.gads2020leaderboard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads2020leaderboard.Model.LearningLeaders;
import com.example.gads2020leaderboard.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.MyViewHolder> {

    Context context;
    List<LearningLeaders> learningLeadersList;


    public LearningLeadersAdapter(Context context, List<LearningLeaders> learningLeadersList) {
        this.context = context;
        this.learningLeadersList = learningLeadersList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.learning_item, parent, false);
        return new LearningLeadersAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(learningLeadersList.get(position).getBadgeUrl()).into(holder.image);
        holder.txt_name.setText(learningLeadersList.get(position).getName());
        holder.txt_hours.setText(learningLeadersList.get(position).getHours());
        holder.txt_country.setText(learningLeadersList.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return learningLeadersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txt_name, txt_hours, txt_country;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.learning_image);
            txt_name = itemView.findViewById(R.id.learners_title);
            txt_hours = itemView.findViewById(R.id.learning_hours);
            txt_country = itemView.findViewById(R.id.learners_country);
        }
    }
}
