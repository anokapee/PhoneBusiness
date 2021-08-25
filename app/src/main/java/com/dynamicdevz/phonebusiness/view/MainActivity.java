package com.dynamicdevz.phonebusiness.view;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.dynamicdevz.phonebusiness.databinding.ActivityMainBinding;
import com.dynamicdevz.phonebusiness.model.db.PhoneDBHelper;
import com.dynamicdevz.phonebusiness.view.adapter.PhoneAdapter;

/*
* Create an application for a local business manager
* who sells phones. The application helps the manager
* keep track of store inventory( Phones(Manufacturer, Model, Price) ).
* Application should allow the manager to add and delete phones(when sold)
* from the inventory (SQLite Databse) as well as view them in ListView.
* */


//Test Comment

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PhoneDBHelper phoneDBHelper;
    private PhoneAdapter phoneAdapter = new PhoneAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.phonesLV.setAdapter(phoneAdapter);
        phoneDBHelper = new PhoneDBHelper(this);
        readAllPhones();

        binding.addBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddActivity.class);
            startActivity(intent);
        });

        binding.deleteBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, DeleteActivity.class);
            startActivity(intent);
        });
    }
    private void readAllPhones() {
        phoneAdapter.setPhoneList(phoneDBHelper.getAllPhones());
    }
}