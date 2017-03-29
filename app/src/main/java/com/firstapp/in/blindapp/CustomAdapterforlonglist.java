package com.firstapp.in.blindapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rina on 29-03-2017.
 */
public class CustomAdapterforlonglist extends BaseAdapter {
    ArrayList<GridModel> arrayList;
    // Integer[] image;
    //String[] names;
    Context gContext;

    private static LayoutInflater inflater ;

    public CustomAdapterforlonglist(Context gContext, ArrayList<GridModel> arrayList) {
//        names = pnames;
//        image = pimage;
        //gContext =;
        this.gContext=gContext;
        // this.gContext=Mainactivity;
        this.arrayList=arrayList;
//        inflater = (LayoutInflater) gContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
//        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
//        return position;
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
            inflater = (LayoutInflater)gContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.long_list,parent,false);
            holder.tv = (TextView) convertView.findViewById(R.id.textlong);
            holder.img = (ImageView) convertView.findViewById(R.id.imagelong);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        // set name
        holder.tv.setText(arrayList.get(position).getName());
        // set image using picasso library
        Picasso.with(gContext).load(arrayList.get(position).getPath()).into(holder.img);
        //holder.imageTV.setImageResource(arrayList.get(position).getPath());
        return convertView;

//        GridModel gridModel = arrayList.get(position);
//        holder.tv.setText(gridModel.getName());
//        holder.img.setImageResource(gridModel.getPath());
//        return convertView;
    }

}

