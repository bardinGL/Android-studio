package com.example.lab42;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.lab42.Data.MyDog;

public class MainActivity2 extends AppCompatActivity {

    AppCompatButton btnData1, btnData2, btnData3, btnData4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnData1 = findViewById(R.id.buttonData1);
        btnData2 = findViewById(R.id.buttonData2);
        btnData3 = findViewById(R.id.buttonData3);
        btnData4 = findViewById(R.id.buttonData4);

        Intent intent = getIntent();
        String dataType = intent.getStringExtra("dataType");

        if (dataType != null) {
            switch (dataType) {
                case "int":
                    int intValue = intent.getIntExtra("data", 0);
                    btnData1.setText("Integer: " + intValue);
                    break;
                case "string":
                    String stringValue = intent.getStringExtra("data");
                    btnData2.setText("String: " + stringValue);
                    break;
                case "array":
                    int[] intArray = intent.getIntArrayExtra("data");
                    StringBuilder arrayString = new StringBuilder("Array: ");
                    if (intArray != null) {
                        for (int value : intArray) {
                            arrayString.append(value).append(" ");
                        }
                    }
                    btnData3.setText(arrayString.toString());
                    break;
                case "object":
                    MyDog myDog = (MyDog) intent.getSerializableExtra("data");
                    if (myDog != null) {
                        btnData4.setText("Object: Name = " + myDog.getName() + ", Age = " + myDog.getAge());
                    }
                    break;
            }
        }

        View.OnClickListener redirectListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        };

        btnData1.setOnClickListener(redirectListener);
        btnData2.setOnClickListener(redirectListener);
        btnData3.setOnClickListener(redirectListener);
        btnData4.setOnClickListener(redirectListener);
    }
}
