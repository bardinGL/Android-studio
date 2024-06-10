package com.example.lab52;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoGameActivity extends AppCompatActivity implements VideoGameAdapter.OnItemClickListener {
    ArrayList<VideoGame> videoGameList;
    RecyclerView rvVideoGame;
    VideoGameAdapter adapter;
    int position = -1;

    Button btnAdd, btnUpdate;
    EditText etName, etDeveloper, etDescription, etURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_game);

        mapping();
        onCreateData();

        adapter = new VideoGameAdapter(videoGameList, this);

        rvVideoGame.setAdapter(adapter);
        rvVideoGame.setLayoutManager(new LinearLayoutManager(this));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValid()) {
                    videoGameList.add(new VideoGame(
                            etName.getText().toString(),
                            etDescription.getText().toString(),
                            etDeveloper.getText().toString(),
                            etURL.getText().toString()));
                    adapter.notifyItemInserted(videoGameList.size() - 1);
                    finished();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValid()) {
                    if (position == -1) {
                        Toast.makeText(VideoGameActivity.this, "PLEASE CHOOSE ITEM", Toast.LENGTH_SHORT).show();
                    } else {
                        VideoGame videoGame = videoGameList.get(position);
                        videoGame.setName(etName.getText().toString());
                        videoGame.setDescription(etDescription.getText().toString());
                        videoGame.setDeveloper(etDeveloper.getText().toString());
                        videoGame.setImageURL(etURL.getText().toString());
                        adapter.notifyItemChanged(position);
                        finished();
                    }
                }
            }
        });
    }

    private void finished() {
        position = -1;
        etName.setText("");
        etDeveloper.setText("");
        etDescription.setText("");
        etURL.setText("");
    }

    private boolean checkValid() {
        if (etName.getText().toString().isEmpty() || etDeveloper.getText().toString().isEmpty() || etDescription.getText().toString().isEmpty() || etURL.getText().toString().isEmpty()) {
            Toast.makeText(VideoGameActivity.this, "FIELD REQUIRED", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onItemClick(int position) {
        etName.setText(videoGameList.get(position).getName());
        etDescription.setText(videoGameList.get(position).getDescription());
        etDeveloper.setText(videoGameList.get(position).getDeveloper());
        etURL.setText(videoGameList.get(position).getImageURL());
        this.position = position;
        Toast.makeText(this, "Item: " + videoGameList.get(position).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(int position) {
        videoGameList.remove(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position, videoGameList.size());
    }

    private void mapping() {
        rvVideoGame = findViewById(R.id.rvVideoGame);
        etName = findViewById(R.id.et_name);
        etDeveloper = findViewById(R.id.et_developer);
        etDescription = findViewById(R.id.et_description);
        etURL = findViewById(R.id.et_url);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
    }

    private void onCreateData() {
        videoGameList = new ArrayList<>();
        videoGameList.add(new VideoGame("Game 1", "Description 1", "Developer 1", R.drawable.game1));
        videoGameList.add(new VideoGame("Game 2", "Description 2", "Developer 2", R.drawable.game2));
        videoGameList.add(new VideoGame("Game 3", "Description 3", "Developer 3", R.drawable.game3));
        videoGameList.add(new VideoGame("Game 4", "Description 4", "Developer 3", R.drawable.game1));
        videoGameList.add(new VideoGame("Game 5", "Description 5", "Developer 3", R.drawable.game2));
        videoGameList.add(new VideoGame("Game 6", "Description 6", "Developer 3", R.drawable.game3));
        videoGameList.add(new VideoGame("Game 7", "Description 7", "Developer 3", R.drawable.game1));
        videoGameList.add(new VideoGame("Game 8", "Description 8", "Developer 3", R.drawable.game2));
        videoGameList.add(new VideoGame("Game 9", "Description 9", "Developer 3", R.drawable.game3));
        videoGameList.add(new VideoGame("Game 10", "Description 10", "Developer 3", R.drawable.game1));
    }
}
