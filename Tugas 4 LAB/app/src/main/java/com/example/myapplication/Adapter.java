package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final ArrayList<Akun> akunts;

    private final fragment_home context;

    public Adapter(ArrayList<Akun> akunts, fragment_home context) {
        this.akunts = akunts;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Akun akun = akunts.get(position);
        holder.setData(akun);
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    fragment_profile profile = new fragment_profile();
                    Bundle bundle = new Bundle();
                    bundle.putString(profile.EXTRA_NAME, akunts.get(position).getName());
                    bundle.putString(profile.EXTRA_USERNAME, akunts.get(position).getUsername());
                    bundle.putInt(profile.EXTRA_PROFILE, akunts.get(position).getFotoprofil());
                    profile.setArguments(bundle);
                    FragmentManager fragmentManager = context.getParentFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frame_container, profile,fragment_profile.class.getSimpleName()).addToBackStack(null).commit();


                }
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionDialogFrame dialogFrame = new optionDialogFrame();
                FragmentManager fragmentManager = context.getChildFragmentManager();

                dialogFrame.show(fragmentManager,optionDialogFrame.class.getSimpleName());
                dialogFrame.setOnDialogOptionSelectedListener(new optionDialogFrame.OnDialogOptionSelectedListener() {
                    @Override
                    public void onOptionSelected(boolean isDeleteSelected) {
                        if (isDeleteSelected){
                            int position = holder.getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION){
                                akunts.remove(position);
                                notifyItemRemoved(position);
                            }
                        }
                    }
                });
            }
        });
//
    }

    @Override
    public int getItemCount() {
        return akunts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView profil, post;
        private TextView user,user2,caption;
        private ImageButton delete;
        private LinearLayout name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profil =itemView.findViewById(R.id.profil);
            this.user = itemView.findViewById(R.id.user);
            this.user2 = itemView.findViewById(R.id.user2);
            this.delete = itemView.findViewById(R.id.delete);
            this.caption = itemView.findViewById(R.id.caption);
            this.post = itemView.findViewById(R.id.post);
            this.name = itemView.findViewById(R.id.name);
        }

        public void setData(Akun akun) {
            profil.setImageResource(akun.getFotoprofil());
            user.setText(akun.getName());
            user2.setText(akun.getUsername());
            caption.setText(akun.getCaption());
            if (akun.getUrigambar()!= null){
                post.setImageURI(akun.getUrigambar());

            }else {
                post.setImageResource(akun.getPost());

            }


        }
    }
}
