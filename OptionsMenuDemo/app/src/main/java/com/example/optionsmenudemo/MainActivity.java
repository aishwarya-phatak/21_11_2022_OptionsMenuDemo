package com.example.optionsmenudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int MENU_SETTINGS = 101, MENU_BLUETOOTH_SETTINGS = 2, MENU_PHONE_SETTINGS = 3,MENU_SIMCARD_SETTINGS = 4,MENU_HISTORY = 5, MENU_SEARCH = 6, MENU_ABOUT_PHONE = 7;
    int grpId;
    boolean hasMenuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toast.makeText(this, "OnCreateOptionsMenu", Toast.LENGTH_SHORT).show();
        SubMenu subMenu = menu.addSubMenu(1,101,1,"Settings");
                            subMenu.add(1,2,2,"Bluetooth Settings");
                            subMenu.add(1,3,3,"Phone Settings");
                            subMenu.add(1,4,4,"SimCard Settings");

        MenuItem menuItemHistory = menu.add(2,5,5,"History");
        MenuItem menuItemSearch = menu.add(3,6,6,"Search");
        MenuItem menuItemAboutPhone = menu.add(4,7,7,"About Phone");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        makeToast("onPrepareOptionsMenu");
        menu.findItem(6).setVisible(false);
        MenuItem menuItemWithIndex3 = menu.getItem(3);
        grpId = menuItemWithIndex3.getGroupId();
        Log.e("grpId","group Id --" + grpId);
        menu.setGroupEnabled(1,false);
        menu.setGroupEnabled(2,false);
        hasMenuItem = menu.findItem(101).hasSubMenu();
        Log.e("tag","hasMenuItem -- " + hasMenuItem);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        makeToast("onOptionsItemSelected");
        switch(item.getItemId()){
            case 7:
                makeToast("AboutPhone");
                break;
            case MENU_HISTORY:
                makeToast("History");
                break;
            case MENU_SEARCH:
                //Intent intent = new Intent(MainActivity.this,DashboardActivity.class);

                makeToast("Search");
                break;
            case MENU_SETTINGS:
                makeToast("Settings");
                break;
            case MENU_BLUETOOTH_SETTINGS:
                makeToast("Bluetooth Settings");
                break;
            case MENU_PHONE_SETTINGS:
                makeToast("Phone Settings");
                break;
            case MENU_SIMCARD_SETTINGS:
                makeToast("Simcard Settings");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void makeToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}