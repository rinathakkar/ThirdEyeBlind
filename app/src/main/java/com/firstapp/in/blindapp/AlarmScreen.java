package com.firstapp.in.blindapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class AlarmScreen extends AppCompatActivity {

    public Integer[] Aimage = {R.drawable.alarmlist,R.drawable.createalarm,R.drawable.backicon};
    public String[] Anames = {"Alarmlist","Create alarm","Go to back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_grid_main);

        ArrayList<GridModel> arrayList = new ArrayList<>();
        for (int i = 0; i <Anames.length ; i++) {
            GridModel gg =new GridModel();
            gg.setName(Anames[i]);
            gg.setPath(Aimage[i]);
            arrayList.add(gg);
        }

        GridView gridview4 = (GridView) findViewById(R.id.main_call);
        gridview4.setAdapter(new CustomAdapter(this, arrayList));

        gridview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(AlarmScreen.this, Alarmlist_sub.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(AlarmScreen.this, Create_alarm_sub.class);
                    intent.putExtra("position", position);
                    startActivity(intent);

                } else if (position == 2) {
                    Intent intent = new Intent(AlarmScreen.this, MainActivity.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            }
        });
    }
}
