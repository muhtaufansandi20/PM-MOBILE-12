package com.example.tugas3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_chats;
    private RecyclerView rv_posts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        rv_chats = findViewById(R.id.rv_chats);
        AdapterChat adapterChat = new AdapterChat(DataSource.akunts, this);
        rv_chats.setAdapter(adapterChat);

        rv_posts = findViewById(R.id.rv_posts);
        AdapterPost adapterPost = new AdapterPost(DataSource.akunts,this);
        rv_posts.setAdapter(adapterPost);
    }
}














































