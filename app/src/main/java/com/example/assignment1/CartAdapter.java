package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends BaseAdapter {
    private final Context context;
    private final List<Item> items;

    public CartAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() { return items.size(); }

    @Override
    public Object getItem(int position) { return items.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        if (convertView == null) {
            row = LayoutInflater.from(context).inflate(R.layout.activity_cart, parent, false);
        } else {
            row = convertView;
        }

        TextView txtName = row.findViewById(R.id.txtActivity4ItemName);
        TextView txtQty = row.findViewById(R.id.txtActivity4ItemTotalqunt);
        ImageView img = row.findViewById(R.id.imgItemLogod);

        Item item = items.get(position);
        txtName.setText(item.getName());
        txtQty.setText("Qty: " + item.getQuantity());
        img.setImageResource(item.getImageResId());

        return row;
    }
}
