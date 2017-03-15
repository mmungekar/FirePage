package com.example.billxiong24.firepageandroid;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ritler on 3/14/17.
 */

public class RAListAdapter extends BaseAdapter {
    private Context context;
    public HashMap<String, Integer> ColorMap;
    public ArrayList<String> RAs = new ArrayList<>();
    private TextView previousRA;

    public RAListAdapter(Context context, HashMap<String, Integer> RAColors){
        this.context = context;
        ColorMap = RAColors;
        RAs.addAll(RAColors.keySet());


    }
    @Override
    public int getCount() {
        return ColorMap.keySet().size();
    }

    @Override
    public Object getItem(int position) {
        return RAs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextView nameView;
        if (convertView == null) { // if it's not recycled, initialize some
            // attributes
            LayoutInflater vi = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.ra_item, null);

        }
        nameView = (TextView) v.findViewById(R.id.name);
        nameView.setText(RAs.get(position));
        //nameView.setClickable(true);
        //nameView.setFocusable(true);
        v.setBackgroundColor(ColorMap.get(RAs.get(position)));

        return v;
    }
    public View setSelected(View view,int pos) {
        if (previousRA != null) {
            // previousRA = (TextView) view.findViewById(R.id.name);
            previousRA.setTextColor(Color.WHITE);
        }
        TextView currentRA = (TextView) view.findViewById(R.id.name);

        currentRA.setTextColor(Color.BLACK);

        previousRA = currentRA;


        return view;
    }
}
