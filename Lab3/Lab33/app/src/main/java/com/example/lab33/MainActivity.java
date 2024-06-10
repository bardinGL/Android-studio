package com.example.lab33;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab33.adapters.BongDaAdapter;
import com.example.lab33.models.bongda;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private BongDaAdapter bongDaAdapter;
    private List<bongda> bongdas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        anhxa();
    }

    private void anhxa() {
        listView = findViewById(R.id.Listview);

        bongdas = new ArrayList<>();
        bongdas.add(new bongda(R.drawable.avapele, "Pele", "October 23, 1940 (age 72)", R.drawable.flagpele));
        bongdas.add(new bongda(R.drawable.avadiegomaradona, "Diego Maradona", "October 30, 1960 (age 52)", R.drawable.flagmaradona));
        bongdas.add(new bongda(R.drawable.avajohancruyff, "Johan Cruyff", "April 25, 1947 (age 65)", R.drawable.flagcruyff));
        bongdas.add(new bongda(R.drawable.avafranzbeckenbauer, "Franz Beckenbauer", "September 11, 1945 (age 67)", R.drawable.flagbeckenbauer));
        bongdas.add(new bongda(R.drawable.avamichelplatini, "Michel Platini", "June 21, 1955 (age 57)", R.drawable.flagplatini));
        bongdas.add(new bongda(R.drawable.avaronaldo, "Ronaldo De Lima", "September 22, 1976 (age 36)", R.drawable.flagronaldo));

        bongDaAdapter = new BongDaAdapter(this, bongdas);
        listView.setAdapter(bongDaAdapter);
    }
}
