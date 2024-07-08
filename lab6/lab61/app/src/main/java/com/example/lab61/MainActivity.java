package com.example.lab61;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btnChonMau;
    ConstraintLayout manHinh;
    AppCompatButton btnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMenu = (AppCompatButton) findViewById(R.id.button);
        btnChonMau = (AppCompatButton) findViewById(R.id.button_chonmau);
        manHinh = (ConstraintLayout) findViewById(R.id.main);
        registerForContextMenu(btnChonMau);


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu();
            }
        });
    }

    private void ShowMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu); // Inflate the options menu
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.menu_context, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.mauvang:manHinh.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.maudo:manHinh.setBackgroundColor(Color.RED);
                break;
            case R.id.mauden:manHinh.setBackgroundColor(Color.BLACK);
                break;
        }
        return super.onContextItemSelected(menuItem);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemHehe:
                Toast.makeText(this, "Hehe selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemHihi:
                Toast.makeText(this, "Hihi selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemHuhu:
                Toast.makeText(this, "Huhu selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
