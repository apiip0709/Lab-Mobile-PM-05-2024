package com.example.tugas3labpm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    private final ArrayList<Story> storys;
    private final ArrayList<Post> posts;

    private ClickListener clickListener;

    public StoryAdapter(ArrayList<Story> storys, ArrayList<Post> posts) {
        this.storys = storys;
        this.posts = posts;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemstory, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        Story story = storys.get(position);
        Post post = posts.get(position);
        holder.setData(story, post);
    }

    @Override
    public int getItemCount() {
        return storys.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvUsername;
        private final ImageView ivImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tv_username);
            ivImage = itemView.findViewById(R.id.iv_profile);
        }

        public void setData(Story story, Post post) {
            tvUsername.setText(story.getUsername());
            ivImage.setImageResource(story.getImage());
            ivImage.setOnClickListener(view -> {
                clickListener.onItemClicked(story, post);
            });
        }
    }
    interface ClickListener {
        void onItemClicked(Story story, Post post);
    }
}
