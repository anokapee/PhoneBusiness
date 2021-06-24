package com.dynamicdevz.phonebusiness.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dynamicdevz.phonebusiness.R;
import com.dynamicdevz.phonebusiness.databinding.ActivityDeleteBinding;
import com.dynamicdevz.phonebusiness.model.db.PhoneDBHelper;
import com.dynamicdevz.phonebusiness.view.adapter.PhoneAdapter;

public class DeleteActivity extends AppCompatActivity {
    private ActivityDeleteBinding binding;
    private PhoneDBHelper phoneDBHelper;
    private PhoneAdapter phoneAdapter = new PhoneAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.phonesDeleteLV.setAdapter(phoneAdapter);
        phoneDBHelper = new PhoneDBHelper(this);
        readAllPhones();

        binding.deleteScreenBtn.setOnClickListener(v -> {
            int phoneID = Integer.parseInt(binding.idET.getText().toString().trim());
            phoneDBHelper.deletePhone(phoneID);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
    private void readAllPhones() {
        phoneAdapter.setPhoneList(phoneDBHelper.getAllPhones());
    }
}