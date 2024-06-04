package com.example.tugas4labpm.view.fragment.add;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.tugas4labpm.R;
import com.example.tugas4labpm.model.DataSourceUser;
import com.example.tugas4labpm.model.User;
import com.example.tugas4labpm.view.MainActivity;
import com.example.tugas4labpm.view.ViewPagerAdapter;
import com.example.tugas4labpm.view.fragment.home.HomeAdapter;
import com.example.tugas4labpm.view.fragment.home.HomeFragment;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class AddFragment extends Fragment {
//    private HomeAdapter homeAdapter;
    private Button btnPost;
    private TextInputEditText etKonten;
    private ImageView postImage;
    private String konten;
    private Uri imageUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnPost = view.findViewById(R.id.btnPost);
        etKonten = view.findViewById(R.id.etKonten);
        postImage = view.findViewById(R.id.post_image);

        postImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buka = new Intent(Intent.ACTION_PICK);
                buka.setType("image/*");
                openGallery.launch(buka);
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                konten = etKonten.getText().toString();

                if (konten.isEmpty()) {
                    Toast.makeText(getContext(), "Konten Masih Kosong", Toast.LENGTH_SHORT).show();
                } else if (imageUri == null) {
                    Toast.makeText(getContext(), "Pilih Gambar Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                } else {
                    User newUser = new User("A. Afif Alhaq", "AeZaKmii", konten, R.drawable.img_2097, imageUri);

                    DataSourceUser.getInstance().addUser(newUser);
                    HomeFragment.homeAdapter.notifyDataSetChanged();

                    etKonten.setText("");
                    postImage.setImageResource(0);


                    if (getActivity() != null && getActivity() instanceof MainActivity) {
                        MainActivity mainActivity = (MainActivity) getActivity();
                        ViewPager viewPager = mainActivity.findViewById(R.id.viewPager);

                        int homeFragmentIndex = mainActivity.getPagerAdapter().getFragmentIndex(HomeFragment.class);
                        if (viewPager != null) {
                            viewPager.setCurrentItem(homeFragmentIndex);
                            Toast.makeText(getContext(), "Post Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

    ActivityResultLauncher<Intent> openGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            imageUri = data.getData();
                            postImage.setImageURI(imageUri);
                        }
                    }
                }
            }
    );
}
