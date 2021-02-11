package edu.temple.adapterviews;

import android.content.Context;
import android.graphics.Color;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DesertAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    ArrayList<String> location;

    public DesertAdapter (Context context, ArrayList items, ArrayList location) {
        this.context = context;
        this.items = items;
        this.location = location;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        Pair<String, String> desert = new Pair(items.get(position), location.get(position));
        return desert;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout linearLayout;


        TextView desertTextView, locationTextView;

        if (convertView == null) {
            linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            desertTextView = new TextView(context);
            desertTextView.setTextSize(28);
            locationTextView = new TextView(context);
            linearLayout.addView(desertTextView);
            linearLayout.addView(locationTextView);
        } else {
            linearLayout = (LinearLayout) convertView;
            desertTextView = (TextView) linearLayout.getChildAt(0);
            locationTextView = (TextView) linearLayout.getChildAt(1);
        }


        desertTextView.setText(items.get(position));
        locationTextView.setText(location.get(position));

        return linearLayout;
    }

}
