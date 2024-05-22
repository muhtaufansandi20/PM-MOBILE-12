package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class fragment_home extends Fragment {
    public static final String EXTRA_CONTENT = "extra_content";
    public static final String EXTRA_POST = "extra_post";

    RecyclerView home;

    private ArrayList<Akun> akunts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        home = view.findViewById(R.id.home);
        home.setHasFixedSize(true);
        home.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        Adapter adapter = new Adapter(DataSource.akunts,this);
        home.setAdapter(adapter);

        if (getArguments() != null) {
            ArrayList<Akun> receivedAkun = getArguments().getParcelableArrayList("Akunts");
            if (receivedAkun != null){
                DataSource.akunts.addAll(0,receivedAkun);
                adapter.notifyDataSetChanged();
            }

   }




    }
}