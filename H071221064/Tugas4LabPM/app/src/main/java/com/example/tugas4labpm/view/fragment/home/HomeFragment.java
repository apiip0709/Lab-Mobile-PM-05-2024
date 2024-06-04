package com.example.tugas4labpm.view.fragment.home;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugas4labpm.R;
import com.example.tugas4labpm.model.DataSourceUser;
import com.example.tugas4labpm.model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements HomeAdapter.HomeAdapterCallback {
    public static HomeAdapter homeAdapter;
    private ArrayList<User> userArrayList;
    RecyclerView rvListData;
    public TextView tvNama, tvUsername, tvKonten;
    public ImageView ivProfile, ivPost;
    public Button btnHapus;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvListData = view.findViewById(R.id.rvListData);
        tvNama = view.findViewById(R.id.tvName);
        tvUsername = view.findViewById(R.id.tvUsername);
        tvKonten = view.findViewById(R.id.tvKonten);
        ivProfile = view.findViewById(R.id.ivProfile);
        ivPost = view.findViewById(R.id.ivImagePost);
        btnHapus = view.findViewById(R.id.ivDelete);

        userArrayList = new ArrayList<>();
        homeAdapter = new HomeAdapter(requireContext(), DataSourceUser.getInstance().getUsers(), this);

        rvListData.setAdapter(homeAdapter);
        rvListData.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvListData.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onDelete(User user) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());

        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_delete, null);
        alertDialogBuilder.setView(dialogView);

        Button btnBatal = dialogView.findViewById(R.id.btnBatal);
        Button btnYa = dialogView.findViewById(R.id.btnYa);

        alertDialogBuilder.setCancelable(false);
        AlertDialog alertDialog = alertDialogBuilder.create();

        btnBatal.setOnClickListener(v -> alertDialog.dismiss());

        btnYa.setOnClickListener(v -> {
            DataSourceUser dataSourceUser = DataSourceUser.getInstance(); // Dapatkan instansi DataSourceUser
            int position = dataSourceUser.getUsers().indexOf(user); // Akses users melalui instansi DataSourceUser
            if (position != -1) {
                dataSourceUser.getUsers().remove(position); // Hapus data pengguna dari users
                homeAdapter.notifyItemRemoved(position);
                Toast.makeText(requireContext(), "Data yang dipilih sudah dihapus",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Data tidak ditemukan",
                        Toast.LENGTH_SHORT).show();
            }
            alertDialog.dismiss();
        });
        alertDialog.show();
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        System.out.println("Output =================");
//    }

//    public void adapterNotifyDataSetChange() { homeAdapter.notifyDataSetChanged(); }
}
