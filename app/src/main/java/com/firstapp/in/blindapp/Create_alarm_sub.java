package com.firstapp.in.blindapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Create_alarm_sub extends AppCompatActivity {

    public Integer[] Acimage = {R.drawable.calender,R.drawable.createalarm,R.drawable.createalarm,R.drawable.createalarm,R.drawable.backicon};
    public String[] Acnames = {"Day alarm:Friday","Alarm hours:00","Alarm minutes:00","Create alarm","Go to back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_grid_main);
        ArrayList<GridModel> arrayList = new ArrayList<>();
        for (int i = 0; i <Acnames.length ; i++) {
            GridModel gg =new GridModel();
            gg.setName(Acnames[i]);
            gg.setPath(Acimage[i]);
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
