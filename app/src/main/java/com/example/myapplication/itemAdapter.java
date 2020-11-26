package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class itemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] items;
    String[] sizes;
    String[] descriptions;

    public itemAdapter(Context c, String[] i, String[] p, String[] d){
        items = i;
        sizes = p;
        descriptions = d;
        mInflater =(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
        View v = mInflater.inflate(R.layout.mylistlayout, null);
        TextView textView2 = (TextView) v.findViewById(R.id.textView2);
        TextView textView3 = (TextView) v.findViewById(R.id.textView3);
        TextView size_textView4 = (TextView) v.findViewById(R.id.size_textView4);

        String name = items[position];
        String opis = descriptions[position];
        String big = sizes[position];

        textView2.setText(name);
        textView3.setText(opis);
        size_textView4.setText(big);
        return null;
    }
}
