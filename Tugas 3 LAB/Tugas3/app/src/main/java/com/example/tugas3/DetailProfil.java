package com.example.tugas3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailProfil extends AppCompatActivity {

    ImageView profil3, iv_detail;
    TextView tv_detail, tv_follower, tv_following;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_profil);

        profil3 = findViewById(R.id.profil3);
        iv_detail = findViewById(R.id.iv_detail);
        tv_detail = findViewById(R.id.tv_detail);
        tv_follower = findViewById(R.id.tv_follower);
        tv_following = findViewById(R.id.tv_following);

        int profil = getIntent().getIntExtra("kirim_profile",0);
        int post = getIntent().getIntExtra("kirim_post",0);
        String username = getIntent().getStringExtra("kirim_username");
        int followers = getIntent().getIntExtra("kirim_followers",0);
        Integer following = getIntent().getIntExtra("kirim_following",0);
        String caption = getIntent().getStringExtra("kirim_caption");
        int story = getIntent().getIntExtra("kirim_story",0);


        profil3.setImageResource(profil);
        iv_detail.setImageResource(post);
        tv_detail.setText(username);
        tv_follower.setText(String.valueOf(followers));
        tv_following.setText(String.valueOf(following));

        iv_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProfil.this, DetailPost.class);
                intent.putExtra("kirim_profile", profil);
                intent.putExtra("kirim_post",post );
                intent.putExtra("kirim_username",username);
                intent.putExtra("kirim_caption",caption);
                intent.putExtra("kirim_story",story);
                intent.putExtra("kirim_followers", followers);
                intent.putExtra("kirim_following", following);
                startActivity(intent);
            }
        });
        profil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProfil.this, StoryActivity.class);
                intent.putExtra("kirim_profile", profil);
                intent.putExtra("kirim_post",post );
                intent.putExtra("kirim_username",username);
                intent.putExtra("kirim_caption",caption);
                intent.putExtra("kirim_story",story);
                intent.putExtra("kirim_followers", followers);
                intent.putExtra("kirim_following", following);
                startActivity(intent);
            }
        });
    }
}