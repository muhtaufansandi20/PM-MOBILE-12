package com.example.tugas3;

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

public class DetailPost extends AppCompatActivity {

    ImageView profil4, iv_adp;

    TextView adp_username , adp_caption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_post);

        profil4 = findViewById(R.id.profil4);
        iv_adp = findViewById(R.id.iv_adp);
        adp_username = findViewById(R.id.adp_username);
        adp_caption = findViewById(R.id.adp_caption);

        int profil = getIntent().getIntExtra("kirim_profile",0);
        int post = getIntent().getIntExtra("kirim_post",0);
        String username = getIntent().getStringExtra("kirim_username");
        String caption = getIntent().getStringExtra("kirim_caption");
        int followers = getIntent().getIntExtra("kirim_followers",0);
        Integer following = getIntent().getIntExtra("kirim_following",0);
        int story = getIntent().getIntExtra("kirim_story",0);


        profil4.setImageResource(profil);
        iv_adp.setImageResource(post);
        adp_username.setText(username);
        adp_caption.setText(caption);

        profil4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStory = new Intent(DetailPost.this, StoryActivity.class);
                toStory.putExtra("kirim_story", story);
                toStory.putExtra("kirim_profile", profil);
                toStory.putExtra("kirim_username", username);
                toStory.putExtra("kirim_followers", followers);
                toStory.putExtra("kirim_following", following);
                toStory.putExtra("kirim_caption", caption);
                toStory.putExtra("kirim_post", post);
                startActivity(toStory);
            }
        });
    }
}