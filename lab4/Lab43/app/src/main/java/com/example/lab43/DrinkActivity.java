package com.example.lab43;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab43.adapters.DoAnAdapter;
import com.example.lab43.models.Item;

import java.util.ArrayList;
import java.util.List;

public class DrinkActivity extends AppCompatActivity {

    private ListView drinkListView;
    private Button btnOrderDrink;
    private String chosenDrink = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        drinkListView = findViewById(R.id.drinkListView);
        btnOrderDrink = findViewById(R.id.btnOrderDrink);

        List<Item> drinkList = new ArrayList<>();
        drinkList.add(new Item(1, "Pepsi", "Description", R.drawable.pepsi));
        drinkList.add(new Item(2, "Heineken", "Description", R.drawable.heineken));
        drinkList.add(new Item(3, "Tiger", "Description", R.drawable.tiger));
        drinkList.add(new Item(4, "Sài Gòn Đỏ", "Description", R.drawable.saigondo));

        DoAnAdapter adapter = new DoAnAdapter(this, drinkList);
        drinkListView.setAdapter(adapter);

        drinkListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chosenDrink = drinkList.get(position).getName();
            }
        });

        btnOrderDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                if(chosenDrink == null || chosenDrink.isEmpty()){
                    chosenDrink = "Chưa chọn thức ăn";
                }
                resultIntent.putExtra("chosenItem", chosenDrink);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
