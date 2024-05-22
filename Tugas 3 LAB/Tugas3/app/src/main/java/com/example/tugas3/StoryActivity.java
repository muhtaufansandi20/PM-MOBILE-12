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

public class StoryActivity extends AppCompatActivity {

    private ImageView iv_story,profil_story;
    private TextView tv_story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_story);

        iv_story = findViewById(R.id.iv_story);
        profil_story = findViewById(R.id.profil_story);
        tv_story = findViewById(R.id.tv_story);

        Integer profil = getIntent().getIntExtra("kirim_profile",0);
        Integer story = getIntent().getIntExtra("kirim_story",0);
        String username = getIntent().getStringExtra("kirim_username");
        int post = getIntent().getIntExtra("kirim_post",0);
        int followers = getIntent().getIntExtra("kirim_followers",0);
        Integer following = getIntent().getIntExtra("kirim_following",0);
        String caption = getIntent().getStringExtra("kirim_caption");



        iv_story.setImageResource(story);
        profil_story.setImageResource(profil);
        tv_story.setText(username);

        tv_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStory = new Intent(StoryActivity.this, DetailProfil.class);
                toStory.putExtra("kirim_story",story );
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