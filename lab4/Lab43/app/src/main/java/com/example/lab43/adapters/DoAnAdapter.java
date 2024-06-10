package com.example.lab43.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.lab43.R;
import com.example.lab43.models.Item;

import java.util.List;

public class DoAnAdapter extends BaseAdapter {

    private Context context;
    private List<Item> itemList;
    private LayoutInflater inflater;

    public DoAnAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itemList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.itemName = convertView.findViewById(R.id.itemName);
            holder.itemDescription = convertView.findViewById(R.id.itemDescription);
            holder.itemImage = convertView.findViewById(R.id.itemImage);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Item item = (Item) getItem(position);
        holder.itemName.setText(item.getName());
        holder.itemDescription.setText(item.getDescription());
        holder.itemImage.setImageDrawable(ContextCompat.getDrawable(context, item.getImageResId()));

        return convertView;
    }

    private static class ViewHolder {
        TextView itemName;
        TextView itemDescription;
        ImageView itemImage;
    }
}
