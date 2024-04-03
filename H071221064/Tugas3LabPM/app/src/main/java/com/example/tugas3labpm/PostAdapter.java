package com.example.tugas3labpm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private final ArrayList<Post> posts;
    private ClickListener clickListener;
    private ProfileClickListener profileClickListener;

    public PostAdapter(ArrayList<Post> posts) { this.posts = posts; }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setProfileClickListener(ProfileClickListener profileClickListener) {
        this.profileClickListener = profileClickListener;
    }
    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itempost, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.setData(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvCapt;
        private final ImageView ivPost;
        private final TextView tvUsername;
        private final ImageView ivProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCapt = itemView.findViewById(R.id.tv_capt);
            ivPost = itemView.findViewById(R.id.iv_post);
            tvUsername = itemView.findViewById(R.id.tv_username);
            ivProfile = itemView.findViewById(R.id.iv_profile);
        }

        public void setData(Post post) {
            tvCapt.setText(post.getCapt());
            ivPost.setImageResource(post.getImagePost());
            tvUsername.setText(post.getUsername());
            ivProfile.setImageResource(post.getImageProfile());
            ivProfile.setOnClickListener(view -> {
                clickListener.onItemClicked(post);
            });
            tvUsername.setOnClickListener(view -> {
                profileClickListener.onItemClicked(post);
            });
        }
    }
    interface ClickListener {
        void onItemClicked(Post post);
    }

    interface ProfileClickListener {
        void onItemClicked(Post post);
    }
}
