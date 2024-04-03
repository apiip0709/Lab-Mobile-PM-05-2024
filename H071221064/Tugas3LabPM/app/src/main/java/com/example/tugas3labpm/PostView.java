package com.example.tugas3labpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PostView extends AppCompatActivity {
    ImageView iv_profile;
    ImageView iv_post;
    TextView username;
    TextView capt;
    public static final String PARCEL_STD = "Extra_Story";
    public static final String PARCEL_POST = "Extra_Post";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_view);

        iv_profile = findViewById(R.id.profile);
        iv_post = findViewById(R.id.post);
        username = findViewById(R.id.tv_username);
        capt = findViewById(R.id.capt);

        Post post = getIntent().getParcelableExtra(PARCEL_POST);

        if (post != null) {
            username.setText(post.getUsername());
            iv_post.setImageResource(post.getImagePost());
            iv_profile.setImageResource(post.getImageProfile());
            capt.setText(post.getCapt());
        }

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStory = new Intent(PostView.this, StoryView.class);
                toStory.putExtra(StoryView.PARCEL_POST, post);
                startActivity(toStory);
            }
        });

        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}