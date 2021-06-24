package com.dynamicdevz.phonebusiness.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dynamicdevz.phonebusiness.R;
import com.dynamicdevz.phonebusiness.databinding.ActivityAddBinding;
import com.dynamicdevz.phonebusiness.model.data.Phone;
import com.dynamicdevz.phonebusiness.model.db.PhoneDBHelper;
import com.dynamicdevz.phonebusiness.view.adapter.PhoneAdapter;

public class AddActivity extends AppCompatActivity {
    private ActivityAddBinding binding;
    private PhoneDBHelper phoneDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        phoneDBHelper = new PhoneDBHelper(this);

        binding.addScreenBtn.setOnClickListener(view -> {
            String manufacturer = binding.manufacturerET.getText().toString().trim();
            String model = binding.modelET.getText().toString().trim();
            double price = Double.parseDouble(binding.priceET.getText().toString().trim());

            Phone newPhone = new Phone(manufacturer, model, price);
            phoneDBHelper.insertPhone(newPhone);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}
