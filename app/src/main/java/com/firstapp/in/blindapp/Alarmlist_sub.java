package com.firstapp.in.blindapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Alarmlist_sub extends AppCompatActivity {

    public Integer[] ALimage = {R.drawable.alarms,R.drawable.deletealarm,R.drawable.deleteall,R.drawable.backicon};
    public String[] ALnames = {"Alarms","Delete alarm","Delete all alarms ","Go to back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_grid_main);

        ArrayList<GridModel> arrayList = new ArrayList<>();
        for (int i = 0; i <ALnames.length ; i++) {
            GridModel gg =new GridModel();
            gg.setName(ALnames[i]);
            gg.setPath(ALimage[i]);
            arrayList.add(gg);
        }


        GridView gridview4 = (GridView) findViewById(R.id.main_call);
        gridview4.setAdapter(new CustomAdapter(this, arrayList));

        gridview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
