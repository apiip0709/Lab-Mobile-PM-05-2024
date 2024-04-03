package com.example.tugas3labpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileView extends AppCompatActivity {
    ImageView profile_image;
    ImageView post_image;
    TextView tv_username;
    TextView tv_followers;
    TextView tv_following;
    public static final String PARCEL_STD = "Extra_Story";
    public static final String PARCEL_POST = "Extra_Post";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        profile_image = findViewById(R.id.profile_image);
        post_image = findViewById(R.id.post_images);
        tv_username = findViewById(R.id.tv_username);
        tv_followers = findViewById(R.id.followers);
        tv_following = findViewById(R.id.following);

        PostAdapter postAdapter = new PostAdapter(DataSourcePost.posts);
        Post post = getIntent().getParcelableExtra(PARCEL_POST);

        if (post != null) {
            tv_username.setText(post.getUsername());
            post_image.setImageResource(post.getImagePost());
            profile_image.setImageResource(post.getImageProfile());
            tv_followers.setText(post.getFollowers());
            tv_following.setText(post.getFollowing());
        }

        post_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPost = new Intent(ProfileView.this, PostView.class);
                toPost.putExtra(StoryView.PARCEL_POST, post);
                startActivity(toPost);
            }
        });
    }
}