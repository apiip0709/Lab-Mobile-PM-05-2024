package com.example.tugas3labpm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvStory = findViewById(R.id.rv_story);
        rvStory.setHasFixedSize(true);
        rvStory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        StoryAdapter storyAdapter = new StoryAdapter(DataSourceStory.storys, DataSourcePost.posts);

        RecyclerView rvPost = findViewById(R.id.rv_post);
        rvPost.setHasFixedSize(true);
        rvPost.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        PostAdapter postAdapter = new PostAdapter(DataSourcePost.posts);
        storyAdapter.setClickListener(new StoryAdapter.ClickListener() {
            @Override
            public void onItemClicked(Story story, Post post) {
                Intent toStory = new Intent(MainActivity.this, StoryView.class);
                toStory.putExtra(StoryView.PARCEL_STD, story);
                toStory.putExtra(StoryView.PARCEL_POST, post);
                startActivity(toStory);
            }
        });
        rvStory.setAdapter(storyAdapter);

        postAdapter.setClickListener(new PostAdapter.ClickListener() {
            @Override
            public void onItemClicked(Post post) {
                Intent toStory = new Intent(MainActivity.this, StoryView.class);
                toStory.putExtra(StoryView.PARCEL_POST, post);
                startActivity(toStory);
            }
        });

        postAdapter.setProfileClickListener(new PostAdapter.ProfileClickListener() {
            @Override
            public void onItemClicked(Post post) {
                Intent toProfile = new Intent(MainActivity.this, ProfileView.class);
                toProfile.putExtra(ProfileView.PARCEL_POST, post);
                startActivity(toProfile);
            }
        });
        rvPost.setAdapter(postAdapter);
    }
}