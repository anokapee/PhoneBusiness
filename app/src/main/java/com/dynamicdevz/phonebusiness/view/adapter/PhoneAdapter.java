package com.dynamicdevz.phonebusiness.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dynamicdevz.phonebusiness.R;
import com.dynamicdevz.phonebusiness.databinding.PhoneItemLayoutBinding;
import com.dynamicdevz.phonebusiness.model.data.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneAdapter extends BaseAdapter {
    private List<Phone> phoneList = new ArrayList<>();

    public PhoneAdapter(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public PhoneAdapter() { }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return phoneList.size();
    }

    @Override
    public Phone getItem(int i) {
        return phoneList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return (long)i;
    }

    private PhoneItemLayoutBinding binding;

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        binding = PhoneItemLayoutBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);

        Phone phone = phoneList.get(i);
        binding.idTV.setText("ID: "+phone.getPhoneID());
        binding.manufacturerTV.setText(phone.getManufacturer());
        binding.modelTV.setText(phone.getModel());
        binding.priceTV.setText("$"+ (int)phone.getPrice());

        return binding.getRoot();
    }
}
