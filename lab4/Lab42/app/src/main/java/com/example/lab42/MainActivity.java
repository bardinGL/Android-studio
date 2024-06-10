package com.example.lab42;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.lab42.Data.MyDog;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btnInt, btnString, btnArray, btnObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInt = findViewById(R.id.buttonInt);
        btnString = findViewById(R.id.buttonString);
        btnArray = findViewById(R.id.buttonArray);
        btnObject = findViewById(R.id.buttonObject);
        MyDog shiba = new MyDog();
        shiba.setName("Baobao");
        shiba.setAge(21);

        btnInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("dataType", "int");
                intent.putExtra("data", 42);
                startActivity(intent);
            }
        });

        btnString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("dataType", "string");
                intent.putExtra("data", "Hello, World!");
                startActivity(intent);
            }
        });

        btnArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("dataType", "array");
                intent.putExtra("data", new int[]{1, 2, 3, 4, 5});
                startActivity(intent);
            }
        });

        btnObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("dataType", "object");
                intent.putExtra("data", (Serializable) shiba);
                startActivity(intent);
            }
        });
    }
}
