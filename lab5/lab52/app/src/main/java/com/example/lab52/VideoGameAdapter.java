package com.example.lab52;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class VideoGameAdapter extends RecyclerView.Adapter<VideoGameAdapter.ViewHolder> {
    private ArrayList<VideoGame> videoGameList;
    private OnItemClickListener listener;

    public VideoGameAdapter(ArrayList<VideoGame> videoGameList, OnItemClickListener listener) {
        this.videoGameList = videoGameList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_game, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoGame videoGame = videoGameList.get(position);
        holder.tvName.setText(videoGame.getName());
        holder.tvDescription.setText(videoGame.getDescription());
        holder.tvDeveloper.setText(videoGame.getDeveloper());

        if (videoGame.getImage() != 0) {
            holder.ivImage.setImageResource(videoGame.getImage());
        } else {
            Glide.with(holder.ivImage.getContext())
                    .load(videoGame.getImageURL())
                    .placeholder(R.drawable.game5) // Placeholder image
                    .error(R.drawable.game5) // Error image
                    .into(holder.ivImage);
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    listener.onItemLongClick(currentPosition);
                }
                return true;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    listener.onItemClick(currentPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoGameList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDescription;
        TextView tvDeveloper;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvDeveloper = itemView.findViewById(R.id.tv_developer);
            ivImage = itemView.findViewById(R.id.iv_image);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onItemLongClick(int position);
    }
}
