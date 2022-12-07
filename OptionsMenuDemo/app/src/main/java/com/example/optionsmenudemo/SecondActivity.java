package com.example.optionsmenudemo;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    ListView foodItemsListView;
    Resources resources;
    String [] foodItems;
    int [] numbers;
    ArrayAdapter<String> stringArrayAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initViews();
        initResources();

        stringArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                foodItems
                );
        foodItemsListView.setAdapter(stringArrayAdapter);
        registerForContextMenu(foodItemsListView);
    }

    private void initViews(){
        foodItemsListView = findViewById(R.id.foodItemsListView);
    }

    private void initResources(){
        resources = getResources();
        foodItems = resources.getStringArray(R.array.foodItems);
        //numbers = resources.getIntArray(R.array.numbers);
        //resources.getInteger(R.integer.Ten);
        //resources.getString(R.string.app_name);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("Context Menu");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.save:
            makeToast("Save");
            break;
            case R.id.saveAs:
                makeToast("Save As");
                break;
            case R.id.copy:
                makeToast("Copy");
                break;
            case R.id.copyImageLink:
                makeToast("Copy Image Link");
                break;
            case R.id.download:
                makeToast("Download");
                break;
        }

        return super.onContextItemSelected(item);

    }

    private void makeToast(String text){
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }
}
