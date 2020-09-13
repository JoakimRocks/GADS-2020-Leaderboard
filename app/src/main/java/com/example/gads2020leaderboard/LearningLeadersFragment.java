package com.example.gads2020leaderboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads2020leaderboard.Adapter.LearningLeadersAdapter;
import com.example.gads2020leaderboard.Common.Common;
import com.example.gads2020leaderboard.Interface.RetrofitService;
import com.example.gads2020leaderboard.Model.LearningLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeadersFragment extends Fragment {
    View v;

    RecyclerView recyclerLearningLeadersList;
    RetrofitService mService;
    LearningLeadersAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public static LearningLeadersFragment getInstance(){
        LearningLeadersFragment learningLeadersFragment = new LearningLeadersFragment();
        return learningLeadersFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        mService = Common.getLearningLeaders();
        getLearningLeadersList();

        View view =  inflater.inflate(R.layout.learning_learders, container, false);
        recyclerLearningLeadersList =(RecyclerView) view.findViewById(R.id.learning_recyclerView);
        recyclerLearningLeadersList.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerLearningLeadersList.setLayoutManager(layoutManager);
        recyclerLearningLeadersList.setLayoutManager(layoutManager);
        return view;
    }

    private void getLearningLeadersList() {
        mService.getLearningLeaders().enqueue(new Callback<List<LearningLeaders>>() {
            @Override
            public void onResponse(Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {
                adapter = new LearningLeadersAdapter(getActivity().getBaseContext(), response.body());
                adapter.notifyDataSetChanged();
                recyclerLearningLeadersList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<LearningLeaders>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }



}
