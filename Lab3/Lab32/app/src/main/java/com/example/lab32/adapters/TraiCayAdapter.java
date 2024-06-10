package com.example.lab32.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab32.R;
import com.example.lab32.models.traicay;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {

    private Context context;
    private List<traicay> items;

    public TraiCayAdapter(Context context, List<traicay> traicays) {
        this.context = context;
        this.items = traicays;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.traicay, parent, false);
        }

        traicay currentTraicay = (traicay) getItem(position);

        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView nameTextView = convertView.findViewById(R.id.item_name);
        TextView descriptionTextView = convertView.findViewById(R.id.item_description);

        imageView.setImageResource(currentTraicay.getImageResource());
        nameTextView.setText(currentTraicay.getName());
        descriptionTextView.setText(currentTraicay.getDescription());

        return convertView;
    }
}
