package com.example.tugas3labpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryView extends AppCompatActivity {
    TextView usernameTextView;
    ImageView profileImageView;
    ImageView storyImageView;
    public static final String PARCEL_STD = "Extra_Story";
    public static final String PARCEL_POST = "Extra_Post";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_view);

        usernameTextView = findViewById(R.id.tv_username);
        profileImageView = findViewById(R.id.profile_image);
        storyImageView = findViewById(R.id.story_image);

        Story story = getIntent().getParcelableExtra(PARCEL_STD);
        Post post = getIntent().getParcelableExtra(PARCEL_POST);

        if (story != null) {
            usernameTextView.setText(story.getUsername());
            if (story.getImage() != null) {
                profileImageView.setImageResource(story.getImage());
            }
        }
        if (post != null) {
            usernameTextView.setText(post.getUsername());
            if (post.getImagePost() != null) {
                storyImageView.setImageResource(post.getImagePost());
            }
            if (post.getImageProfile() != null) {
                profileImageView.setImageResource(post.getImageProfile());
            }
        }

        usernameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toProfile = new Intent(StoryView.this, ProfileView.class);
                toProfile.putExtra(StoryView.PARCEL_POST, post);
                startActivity(toProfile);
            }
        });
    }
}