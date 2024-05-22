package com.example.boskhaekal;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity3 extends AppCompatActivity  {
    ImageView gambar1;
    TextView text1,text2,text3,text4;

    Uri urigambar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        gambar1 = findViewById(R.id.gambar1);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);

        String gambar = getIntent().getStringExtra("kirimgambar");
        if (gambar!= null){
            urigambar = Uri.parse(gambar);
            InputStream inputstream = null;
            try {
                inputstream = getContentResolver().openInputStream(urigambar);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Bitmap bitmap = BitmapFactory.decodeStream(inputstream);
            gambar1.setImageBitmap(bitmap);;
        }

        String nama = getIntent().getStringExtra("kirimnama");
        String username = getIntent().getStringExtra("kirimusername");
        String title = getIntent().getStringExtra("kirimtitle");
        String content = getIntent().getStringExtra("kirimcontent");

        text1.setText(nama);
        text2.setText(username);
        text3.setText(title);
        text4.setText(content);
    }
}