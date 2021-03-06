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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;


/**
 * Created by Rina on 02-02-2017.
 */

public class CustomAdapter extends BaseAdapter {
    ArrayList<GridModel> arrayList;
   // Integer[] image;
    //String[] names;
    Context gContext;

    private static LayoutInflater inflater ;

    public CustomAdapter(Context gContext, ArrayList<GridModel> arrayList) {
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
            convertView = inflater.inflate(R.layout.activity_app_main,parent,false);
            holder.tv = (TextView) convertView.findViewById(R.id.text);
            holder.img = (ImageView) convertView.findViewById(R.id.image);
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
