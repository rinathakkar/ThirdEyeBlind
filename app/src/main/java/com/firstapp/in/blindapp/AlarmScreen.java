package com.firstapp.in.blindapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class AlarmScreen extends AppCompatActivity {

    public Integer[] Aimage = {R.drawable.alarmlist,R.drawable.createalarm,R.drawable.backicon};
    public String[] Anames = {"Alarmlist","Create alarm","Go to back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        GridView gridview4 = (GridView) findViewById(R.id.main_call);
        gridview4.setAdapter(new CustomAdapter(this, Aimage, Anames));

        gridview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
