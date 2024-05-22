package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigation;

    fragment_home fragmentHome;
    fragment_postingan fragmentPostingan;
    fragment_profile fragmentProfile;

    TextView tv_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        tv_title = findViewById(R.id.tv_title);

        fragmentHome = new fragment_home();
        fragmentPostingan = new fragment_postingan();
        fragmentProfile = new fragment_profile();


        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentHome).commit();

        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.house) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentHome).commit();
                    tv_title.setText("Home");
                } else if (itemId == R.id.post) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentPostingan).commit();
                    tv_title.setText("Posting");
                } else if (itemId == R.id.profil) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentProfile).commit();
                    tv_title.setText("Profile");
                }
                return true;
            }
        });
        }
    }




