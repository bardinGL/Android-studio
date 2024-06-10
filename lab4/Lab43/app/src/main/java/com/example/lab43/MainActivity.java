package com.example.lab43;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtChosenFood, txtChosenDrink;
    private Button btnChooseFood, btnChooseDrink, btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtChosenFood = findViewById(R.id.txtChosenFood);
        txtChosenDrink = findViewById(R.id.txtChosenDrink);
        btnChooseFood = findViewById(R.id.btnChooseFood);
        btnChooseDrink = findViewById(R.id.btnChooseDrink);
        btnRefresh = findViewById(R.id.btnRefresh);

        btnChooseFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        btnChooseDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrinkActivity.class);
                startActivityForResult(intent, 2);
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtChosenFood == null){
                    txtChosenFood.setText("Chưa chọn thức ăn");
                }
                if(txtChosenDrink == null){
                    txtChosenDrink.setText("Chưa chọn đồ uống");
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            String chosenItem = data.getStringExtra("chosenItem");
            if (requestCode == 1) {
                txtChosenFood.setText(chosenItem);
            } else if (requestCode == 2) {
                txtChosenDrink.setText(chosenItem);
            }
        }
    }
}
