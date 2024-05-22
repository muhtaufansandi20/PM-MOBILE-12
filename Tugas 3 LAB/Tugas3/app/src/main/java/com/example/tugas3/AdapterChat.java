package com.example.tugas3;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterChat extends RecyclerView.Adapter<AdapterChat.ViewHolder> {

    private ArrayList<Akun> akunts;
    private Context context;
    public AdapterChat(ArrayList<Akun> akunts, Context context){
        this.akunts = akunts;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterChat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterChat.ViewHolder holder, int position) {
        Akun akun = akunts.get(position);
        holder.setData(akun);

        holder.profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Intent toStory = new Intent(context, StoryActivity.class);
                    toStory.putExtra("kirim_story", akunts.get(position).getStory());
                    toStory.putExtra("kirim_profile", akunts.get(position).getProfil());
                    toStory.putExtra("kirim_username", akunts.get(position).getUsername());
                    toStory.putExtra("kirim_followers", akunts.get(position).getFollowers());
                    toStory.putExtra("kirim_following", akunts.get(position).getFollowing());
                    toStory.putExtra("kirim_caption", akunts.get(position).getCaption());
                    toStory.putExtra("kirim_post", akunts.get(position).getPost());
                    context.startActivity(toStory);
                }
            }
        });

        holder.tv_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Intent toStory = new Intent(context, DetailProfil.class);
                    toStory.putExtra("kirim_story", akunts.get(position).getStory());
                    toStory.putExtra("kirim_profile", akunts.get(position).getProfil());
                    toStory.putExtra("kirim_username", akunts.get(position).getUsername());
                    toStory.putExtra("kirim_followers", akunts.get(position).getFollowers());
                    toStory.putExtra("kirim_following", akunts.get(position).getFollowing());
                    toStory.putExtra("kirim_caption", akunts.get(position).getCaption());
                    toStory.putExtra("kirim_post", akunts.get(position).getPost());
                    context.startActivity(toStory);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return akunts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView profil;
        private TextView tv_username, story;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profil = itemView.findViewById(R.id.profil);
            tv_username = itemView.findViewById(R.id.tv_username);


        }

        public void setData(Akun akun) {
            profil.setImageResource(akun.getProfil());
            tv_username.setText(akun.getUsername());
        }
    }
}