package com.example.tugas4labpm.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.tugas4labpm.R;
import com.example.tugas4labpm.model.User;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvUsername;
    private ImageView ivProfile;
    private ProgressBar progressBar;
    private LinearLayout llProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.nama);
        tvUsername = findViewById(R.id.username);
        ivProfile = findViewById(R.id.profile_image);
        progressBar = findViewById(R.id.progressBar);
        llProfile = findViewById(R.id.llProfile);

        User user = getIntent().getParcelableExtra("user");

        if (user != null) {
            progressBar.setVisibility(View.VISIBLE);
            llProfile.setVisibility(View.GONE);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvName.setText(user.getNama());
                            tvUsername.setText(user.getUsername());
                            ivProfile.setImageResource(user.getProfileImage());

                            progressBar.setVisibility(View.GONE);
                            llProfile.setVisibility(View.VISIBLE);
                        }
                    });
                }
            }).start();
        }
    }
}
