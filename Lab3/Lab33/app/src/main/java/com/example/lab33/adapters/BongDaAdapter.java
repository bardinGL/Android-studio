package com.example.lab33.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab33.R;
import com.example.lab33.models.bongda;

import java.util.List;

public class BongDaAdapter extends BaseAdapter {
    private Context context;
    private List<bongda> items;

    public BongDaAdapter(Context context, List<bongda> bongdas) {
        this.context = context;
        this.items = bongdas;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.bongda, parent, false);
        }

        bongda currentBongDa = (bongda) getItem(position);

        ImageView imageView = convertView.findViewById(R.id.ava);
        TextView nameTextView = convertView.findViewById(R.id.name);
        TextView descriptionTextView = convertView.findViewById(R.id.info);
        ImageView imageView2 = convertView.findViewById(R.id.flag);

        imageView.setImageResource(currentBongDa.getAva());
        nameTextView.setText(currentBongDa.getName());
        descriptionTextView.setText(currentBongDa.getInfo());
        imageView2.setImageResource(currentBongDa.getFlag());

        return convertView;
    }
}
