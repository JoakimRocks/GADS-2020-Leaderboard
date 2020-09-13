package com.example.gads2020leaderboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads2020leaderboard.Adapter.SkillIqLeadersAdapter;
import com.example.gads2020leaderboard.Common.Common;
import com.example.gads2020leaderboard.Interface.RetrofitService;
import com.example.gads2020leaderboard.Model.SkillIqLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIqLeadersFragment extends Fragment {
    View v;

    RecyclerView recyclerSkillIqLeadersList;
    RetrofitService mService;
    RecyclerView.LayoutManager layoutManager;

    SkillIqLeadersAdapter skillAdapter;


    public static SkillIqLeadersFragment getInstance(){
        SkillIqLeadersFragment skillIqLeadersFragment = new SkillIqLeadersFragment();
        return skillIqLeadersFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    private void getSkillIqLeadersList() {
        mService.getSkillIqLeaders().enqueue(new Callback<List<SkillIqLeaders>>() {
            @Override
            public void onResponse(Call<List<SkillIqLeaders>> call, Response<List<SkillIqLeaders>> response) {
                skillAdapter = new SkillIqLeadersAdapter(getActivity().getBaseContext(), response.body());
                skillAdapter.notifyDataSetChanged();
                recyclerSkillIqLeadersList.setAdapter(skillAdapter);
            }

            @Override
            public void onFailure(Call<List<SkillIqLeaders>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        mService = Common.getSkillIqLeaders();
        getSkillIqLeadersList();

        View view =  inflater.inflate(R.layout.skill_iq_leaders, container, false);
        recyclerSkillIqLeadersList = view.findViewById(R.id.skill_recyclerView);
        recyclerSkillIqLeadersList.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerSkillIqLeadersList.setLayoutManager(layoutManager);
        recyclerSkillIqLeadersList.setLayoutManager(layoutManager);
        return view;
    }
}
