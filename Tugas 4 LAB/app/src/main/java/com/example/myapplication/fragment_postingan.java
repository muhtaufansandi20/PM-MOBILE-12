package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;

import static com.example.myapplication.DataSource.akunts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;



public class fragment_postingan extends Fragment {

    EditText fpost_text;
    ImageButton fpost_ib;
    Button fpost_button;
    TextView fprofile_tv_name;
    TextView fprofile_tv_username;
    Boolean cekGambar = false;

    Uri uriGambar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_postingan, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fpost_text = view.findViewById(R.id.fpost_text);
        fpost_ib = view.findViewById(R.id.fpost_ib);
        fpost_button = view.findViewById(R.id.fpost_button);
        fprofile_tv_username = view.findViewById(R.id.fprofile_tv_username);
        fprofile_tv_name = view.findViewById(R.id.fprofile_tv_name);



        ActivityResultLauncher<Intent> intentLaunch = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        uriGambar = result.getData().getData();
                        fpost_ib.setImageURI(uriGambar);
                        cekGambar = true;

                    }
                }
        );

        fpost_ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toGallery = new Intent(Intent.ACTION_PICK);
                toGallery.setType("image/*");
                intentLaunch.launch(toGallery);
            }
        });

        fpost_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = fpost_text.getText().toString().trim();
                if (content.isEmpty()) {
                    Toast.makeText(getActivity(), "Silahkan isi content", Toast.LENGTH_SHORT).show();
                } else if (cekGambar == false) {
                    Toast.makeText(getActivity(), "Silahkan pilih gambar", Toast.LENGTH_SHORT).show();
                } else {
                    ArrayList<Akun> akunts = new ArrayList<>();
                    akunts.add(new Akun("SuporterGaruda",
                            "garuda",
                            fpost_text.getText().toString(),
                            0,
                            R.drawable.garuda2,
                            uriGambar));
                    fragment_home homeFragment = new fragment_home();
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("Akunts", akunts);
                    homeFragment.setArguments(bundle);

                    FragmentManager fragmentManager = getParentFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, homeFragment, fragment_home.class.getSimpleName())
                            .addToBackStack(null)
                            .commit();

                }


            }
        });

    }
}






