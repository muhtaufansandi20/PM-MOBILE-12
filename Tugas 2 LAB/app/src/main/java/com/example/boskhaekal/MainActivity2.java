package com.example.boskhaekal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    EditText texttitle,textcontent;
    Button button2;

    Uri gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);

        texttitle = findViewById(R.id.texttitle);
        textcontent = findViewById(R.id.textcontent);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button2 ) {
            String ambiltitle = texttitle.getText().toString();
            String ambilcontent = textcontent.getText().toString();
            String textnama = getIntent().getStringExtra("kirimnama");
            String textusername = getIntent().getStringExtra("kirimusername");
            if (getIntent().hasExtra("kirimgambar")){
                String kirimgambar = getIntent().getStringExtra("kirimgambar");
                gambar = Uri.parse(kirimgambar);
            }
            if (ambiltitle.isEmpty()){
                texttitle.setError("isi title");
            }if (ambilcontent.isEmpty()){
                textcontent.setError("isi content");
            }else {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("kirimnama", textnama);
                intent.putExtra("kirimusername", textusername);
                intent.putExtra("kirimgambar",gambar.toString());
                intent.putExtra("kirimtitle",ambiltitle);
                intent.putExtra("kirimcontent",ambilcontent);
                startActivity(intent);
            }

        }
    }
}