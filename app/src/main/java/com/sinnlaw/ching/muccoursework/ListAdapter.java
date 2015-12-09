package com.sinnlaw.ching.muccoursework;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by ching on 2015/12/01.
 */

public class ListAdapter extends ArrayAdapter{

    List list = new ArrayList();

    public ListAdapter(Context context, int resource)
    {
        super(context, resource);
    }

    static class DataHandler
    {
        ImageView image;
        TextView title;
        TextView price;
    }

    public void add(Object object)
    {
        super.add(object);
        list.add(object);
    }

    public int getCount()
    {
        return this.list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row=convertView;
        DataHandler handler;
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.listview_layout,parent,false);
            handler=new DataHandler();
            handler.image=(ImageView)row.findViewById(R.id.food_img);
            handler.title=(TextView)row.findViewById(R.id.rest_name);
            handler.price=(TextView)row.findViewById(R.id.rest_price);
            row.setTag(handler);
        }
        else {

            handler=(DataHandler)row.getTag();
        }

        ListData dataProvider;

        dataProvider=(ListData)this.getItem(position);
        handler.image.setImageResource(dataProvider.getRest_img_data());
        handler.title.setText(dataProvider.getRest_title_data());
        handler.price.setText(dataProvider.getRest_price_data());

        return row;
    }
}
