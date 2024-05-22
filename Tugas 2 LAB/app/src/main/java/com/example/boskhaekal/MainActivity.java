package com.example.boskhaekal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText textnama,textusername;


    Button button1;
    ImageView gambar1;
    Uri gambar;

    Boolean cek = false;
    private ActivityResultLauncher<Intent> openGaleri = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null){
                    gambar = result.getData().getData();
                    InputStream inputstream = null;
                    try {
                        inputstream = getContentResolver().openInputStream(gambar);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    Bitmap bitmap = BitmapFactory.decodeStream(inputstream);
                    gambar1.setImageBitmap(bitmap);

                    cek = true;

                }

            }
    );
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        gambar1 = findViewById(R.id.gambar1);
        gambar1.setOnClickListener(this);

        textnama = findViewById(R.id.textnama);
        textusername = findViewById(R.id.textusername);




    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1 ){
            String ambilnama = textnama.getText().toString();
            String ambilusername = textusername.getText().toString();
            if (cek == false){
                Toast.makeText(MainActivity.this, " silahkan pilih gambar", Toast.LENGTH_SHORT).show();
            } if (ambilnama.length() == 0){
                textnama.setError("Isi nama");
            } if (ambilusername.length() == 0){
                textusername.setError("isi username");
            } else {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("kirimnama",ambilnama);
                intent.putExtra("kirimusername", ambilusername);
                intent.putExtra("kirimgambar",gambar.toString());
                startActivity(intent);
            }
        } else if (v.getId() == R.id.gambar1) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            openGaleri.launch(Intent.createChooser(intent, "Pilihgambar"));
        }
            

    }
}