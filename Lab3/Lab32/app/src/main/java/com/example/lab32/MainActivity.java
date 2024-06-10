package com.example.lab32;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab32.adapters.TraiCayAdapter;
import com.example.lab32.models.traicay;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TraiCayAdapter traiCayAdapter;
    private List<traicay> traicays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();
    }

    private void anhxa() {
        listView = findViewById(R.id.listView);

        traicays = new ArrayList<>();
        traicays.add(new traicay("Apple", "apple...some description goes here", R.drawable.apple));
        traicays.add(new traicay("Banana", "banana...some description goes here", R.drawable.banana));
        traicays.add(new traicay("Blueberry", "blueberry...some description goes here", R.drawable.blueberry));
        traicays.add(new traicay("Corn", "corn...some description goes here", R.drawable.corn));
        traicays.add(new traicay("Grapes", "grapes...some description goes here", R.drawable.grapes));

        traiCayAdapter = new TraiCayAdapter(this, traicays);
        listView.setAdapter(traiCayAdapter);
    }
}