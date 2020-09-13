package com.example.gads2020leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.gads2020leaderboard.Adapter.LearningLeadersAdapter;
import com.example.gads2020leaderboard.Adapter.SkillIqLeadersAdapter;
import com.example.gads2020leaderboard.Common.Common;
import com.example.gads2020leaderboard.Interface.RetrofitService;
import com.example.gads2020leaderboard.Model.LearningLeaders;
import com.example.gads2020leaderboard.Model.SkillIqLeaders;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    RecyclerView.LayoutManager layoutManager;

    private TextView submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        getTabs();

        layoutManager = new LinearLayoutManager(this);

        submit = (TextView) findViewById(R.id.submit_btn);

        openSubmissionActivity();

    }

    private void openSubmissionActivity() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubmissionActivity.class);
                startActivity(intent);

            }
        });

    }

    public void getTabs(){
       final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        new Handler().post(new Runnable(){

            @Override
            public void run() {


        viewPagerAdapter.addFragment(new LearningLeadersFragment(), "Learning Leaders");
        viewPagerAdapter.addFragment(new SkillIqLeadersFragment(), "Skill IQ Leaders");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
            }
        });
    }

}
