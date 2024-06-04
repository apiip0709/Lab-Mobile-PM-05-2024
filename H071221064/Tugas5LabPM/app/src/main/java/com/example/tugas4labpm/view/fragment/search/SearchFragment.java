package com.example.tugas4labpm.view.fragment.search;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas4labpm.R;
import com.example.tugas4labpm.model.DataSourceUser;
import com.example.tugas4labpm.model.User;
import com.example.tugas4labpm.view.ProfileActivity;
import com.example.tugas4labpm.view.fragment.search.SearchAdapter;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    public static SearchAdapter searchAdapter;
    private ArrayList<User> userArrayList;
    private RecyclerView rvListUser;
    private EditText searchBar;
    private TextView tvNama, tvUsername;
    private ImageView ivProfile;
    private CardView cardAkun;
    private ArrayList<User> filteredList;
    private ProgressBar progressBar;
    private Handler handler = new Handler(Looper.getMainLooper());
    private static final long SEARCH_DELAY = 200;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvListUser = view.findViewById(R.id.rvListUser);
        tvNama = view.findViewById(R.id.tvName);
        tvUsername = view.findViewById(R.id.tvUsername);
        ivProfile = view.findViewById(R.id.ivProfile);
        cardAkun = view.findViewById(R.id.cardAkun);
        searchBar = view.findViewById(R.id.searchBar_et);
        progressBar = view.findViewById(R.id.progressBar);

        filteredList = new ArrayList<>();

        searchAdapter = new SearchAdapter(requireContext(), filteredList);
        rvListUser.setAdapter(searchAdapter);
        rvListUser.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvListUser.setItemAnimator(new DefaultItemAnimator());

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                getUserData();
                progressBar.setVisibility(View.VISIBLE);
                rvListUser.setVisibility(View.GONE);
                handler.removeCallbacksAndMessages(null);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        performSearch(charSequence.toString());
                    }
                }, SEARCH_DELAY);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

        });

        searchAdapter.setOnItemClickListener(new SearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                User clickedUser = filteredList.get(position);
                Intent intent = new Intent(requireContext(), ProfileActivity.class);
                intent.putExtra("user", clickedUser);
                startActivity(intent);
            }
        });
    }

    private void getUserData() {
        userArrayList = new ArrayList<>();
        userArrayList.addAll(DataSourceUser.getInstance().getUsers());
    }

    private void performSearch(final String query) {
        filteredList.clear();
        if (!query.isEmpty()) {
            String lowerCaseQuery = query.toLowerCase();
            for (User user : userArrayList) {
                boolean isUserExist = false;
                for (User filteredUser : filteredList) {
                    if (filteredUser.getUsername() == user.getUsername()) {
                        isUserExist = true;
                        break;
                    }
                }

                if (!isUserExist && (user.getNama().toLowerCase().contains(lowerCaseQuery) ||
                        user.getUsername().toLowerCase().contains(lowerCaseQuery))) {
                    filteredList.add(user);
                }
            }
        }

        searchAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
        rvListUser.setVisibility(View.VISIBLE);
    }
}

