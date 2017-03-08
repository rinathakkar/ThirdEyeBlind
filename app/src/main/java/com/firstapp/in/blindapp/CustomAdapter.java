package com.firstapp.in.blindapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Rina on 02-02-2017.
 */

public class CustomAdapter extends BaseAdapter {
    Integer[] image;
    String[] names;
    Context gContext;

    private static LayoutInflater inflater ;

    public CustomAdapter(AppCompatActivity mainActivity, Integer[] pimage, String[] pnames) {
        names = pnames;
        image = pimage;
        gContext = mainActivity;
        inflater = (LayoutInflater) gContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class Holder{
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView == null){
            holder = new Holder();
            convertView = inflater.inflate(R.layout.activity_app_main,parent,false);
            holder.tv = (TextView) convertView.findViewById(R.id.text);
            holder.img = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        holder.tv.setText(names[position]);
        holder.img.setImageResource(image[position]);
        return convertView;
    }

}
