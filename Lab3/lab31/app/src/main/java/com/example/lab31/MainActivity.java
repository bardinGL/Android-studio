package com.example.lab31;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnAdd, btnUpdate;
    private EditText editTextUpdate;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> items;
    private int selectedItemIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        editTextUpdate = findViewById(R.id.editTextUpdate);

        items = new ArrayList<>();
        items.add("Android");
        items.add("PHP");
        items.add("iOS");
        items.add("Unity");
        items.add("ASP.Net");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, items);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItemIndex = position;
                editTextUpdate.setText(items.get(position));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add("New Item");
                adapter.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItemIndex != -1) {
                    String updatedItem = editTextUpdate.getText().toString();
                    if (!updatedItem.isEmpty()) {
                        items.set(selectedItemIndex, updatedItem);
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(MainActivity.this, "Item name cannot be empty", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please select an item to update", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
