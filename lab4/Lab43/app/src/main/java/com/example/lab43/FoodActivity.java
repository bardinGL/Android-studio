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

public class FoodActivity extends AppCompatActivity {

    private ListView foodListView;
    private Button btnOrderFood;
    private String chosenFood = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        foodListView = findViewById(R.id.foodListView);
        btnOrderFood = findViewById(R.id.btnOrderFood);

        List<Item> foodList = new ArrayList<>();
        foodList.add(new Item(1, "Phở Hà Nội", "Description", R.drawable.pho));
        foodList.add(new Item(2, "Bún Bò Huế", "Description", R.drawable.bunbohue));
        foodList.add(new Item(3, "Mì Quảng", "Description", R.drawable.miquang));
        foodList.add(new Item(4, "Hủ Tíu Sài Gòn", "Description", R.drawable.hutiu));

        DoAnAdapter adapter = new DoAnAdapter(this, foodList);
        foodListView.setAdapter(adapter);

        foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chosenFood = foodList.get(position).getName();
            }
        });

        btnOrderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                if(chosenFood == null || chosenFood.isEmpty()){
                    chosenFood = "Chưa chọn thức ăn";
                }
                resultIntent.putExtra("chosenItem", chosenFood);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
