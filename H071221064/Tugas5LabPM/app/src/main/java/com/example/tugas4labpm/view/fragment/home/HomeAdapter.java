package com.example.tugas4labpm.view.fragment.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas4labpm.R;
import com.example.tugas4labpm.model.User;
import com.example.tugas4labpm.view.fragment.search.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<User> list;
    private HomeAdapterCallback homeAdapterCallback;

    public HomeAdapter(Context context, ArrayList<User> list, HomeAdapterCallback homeAdapterCallback) {
        this.context = context;
        this.list = list;
        this.homeAdapterCallback = homeAdapterCallback;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        User user = list.get(position);
        holder.bindData(user);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(User user) {
        list.add(user);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNama, tvUsername, tvKonten;
        public ImageView ivProfile, ivPost, ivDelete;
        public LinearLayout toProfile;

        ViewHolder(View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvName);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvKonten = itemView.findViewById(R.id.tvKonten);
            ivProfile = itemView.findViewById(R.id.ivProfile);
            ivPost = itemView.findViewById(R.id.ivImagePost);
            ivDelete = itemView.findViewById(R.id.ivDelete);
            toProfile = itemView.findViewById(R.id.toProfile);

            toProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User item = list.get(getAdapterPosition());
                    homeAdapterCallback.onItemClick(item);
                }
            });

            ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User item = list.get(getAdapterPosition());
                    homeAdapterCallback.onDelete(item);
                }
            });
        }

        public void bindData(User data) {
            tvNama.setText(data.getNama());
            tvUsername.setText(data.getUsername());
            tvKonten.setText(data.getKonten());
            ivProfile.setImageResource(data.getProfileImage());
            if (data.getPostImage() != null) {
                ivPost.setImageResource(data.getPostImage());
            }
            if (data.getUriPost() != null) {
                ivPost.setImageURI(data.getUriPost());
            }
        }
    }

    public interface HomeAdapterCallback {
        void onDelete(User user);

        void onItemClick(User user);
    }
}
