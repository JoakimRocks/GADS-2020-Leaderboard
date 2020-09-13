package com.example.gads2020leaderboard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads2020leaderboard.Model.SkillIqLeaders;
import com.example.gads2020leaderboard.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SkillIqLeadersAdapter extends RecyclerView.Adapter<SkillIqLeadersAdapter.MyViewHolder> {

    Context context;
    List<SkillIqLeaders> skillIqLeadersList;

    public SkillIqLeadersAdapter(Context context, List<SkillIqLeaders> skillIqLeadersList) {
        this.context = context;
        this.skillIqLeadersList = skillIqLeadersList;
    }

    @NonNull
    @Override
    public SkillIqLeadersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.skill_iq_item, parent, false);
        return new SkillIqLeadersAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIqLeadersAdapter.MyViewHolder holder, int position) {
        Picasso.get().load(skillIqLeadersList.get(position).getBadgeUrl()).into(holder.skill_image);
        holder.txt_skill_name.setText(skillIqLeadersList.get(position).getName());
        holder.txt_score.setText(skillIqLeadersList.get(position).getScore());
        holder.txt_skill_country.setText(skillIqLeadersList.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return skillIqLeadersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView skill_image;
        TextView txt_skill_name, txt_score, txt_skill_country;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            skill_image = itemView.findViewById(R.id.skill_iq_image);
            txt_skill_name = itemView.findViewById(R.id.skill_iq_name);
            txt_score = itemView.findViewById(R.id.skill_iq_score);
            txt_skill_country = itemView.findViewById(R.id.skill_iq_country);
        }
    }
}
