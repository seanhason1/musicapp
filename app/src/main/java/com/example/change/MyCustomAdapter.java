package com.example.change;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCustomAdapter extends BaseAdapter {

    private String[] items;// items names
    private int[] imageResIds; // Array of image resource IDs
    private Context context;

    public MyCustomAdapter(Context context , String[] items, int[] imageResIds){
        this.context = context;
        this.items = items;
        this.imageResIds = imageResIds;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.textView3); // Ensure this ID matches your TextView in list_item.xml
            holder.imageView = convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Set the text for the TextView in the ViewHolder
        holder.textView.setText(items[position]);
        holder.imageView.setImageResource(imageResIds[position]); // Set image resourc
        return convertView;
    }
    static class ViewHolder{

        TextView textView;
        ImageView imageView;
    }
}
