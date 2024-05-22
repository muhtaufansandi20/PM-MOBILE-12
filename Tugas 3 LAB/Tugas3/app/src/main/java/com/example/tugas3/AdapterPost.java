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

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.ViewHolder> {

    private ArrayList<Akun> akunts;
    private Context context;
    public AdapterPost(ArrayList<Akun> akunts, Context context){
        this.akunts = akunts;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterPost.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPost.ViewHolder holder, int position) {
        Akun akun = akunts.get(position);
        holder.setData(akun);

        holder.user.setOnClickListener(new View.OnClickListener() {
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

        holder.profil2.setOnClickListener(new View.OnClickListener() {
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

    }

    @Override
    public int getItemCount() {
        return akunts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView profil2, post;
        private TextView user,caption;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profil2 = itemView.findViewById(R.id.profil2);
            post = itemView.findViewById(R.id.post);
            user = itemView.findViewById(R.id.user);
            caption = itemView.findViewById(R.id.caption);
            }

        public void setData(Akun akun) {
            profil2.setImageResource(akun.getProfil());
            user.setText(akun.getUsername());
            post.setImageResource(akun.getPost());
            caption.setText(akun.getCaption());
        }
    }
}