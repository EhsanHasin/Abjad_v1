package com.tiyansoft.abjad.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tiyansoft.abjad.R;
import com.tiyansoft.abjad.database.Data;

import java.util.ArrayList;

/**
 * Created by Ehsan Hasin on 12/19/2017.
 */

public class MyAdapter extends BaseAdapter {

    private ArrayList<Data> list;
    private Context context;

    public MyAdapter(Context context, ArrayList<Data> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_view_for_favorite_layout,parent,false);

        TextView text = (TextView) convertView.findViewById(R.id.textView_text);
        text.setText(list.get(position).getText());

        TextView number = (TextView) convertView.findViewById(R.id.textView_number);
        number.setText(list.get(position).getNumber()+"");

        return convertView;
    }
}
