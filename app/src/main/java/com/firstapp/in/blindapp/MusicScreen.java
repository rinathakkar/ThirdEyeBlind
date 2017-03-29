package com.firstapp.in.blindapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MusicScreen extends AppCompatActivity {

    public Integer[] miimage = {R.drawable.play,R.drawable.volume,R.drawable.artist,R.drawable.backicon};
    public String[] minames = {"Play","Volume","Artists","Go to back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_grid_main);

        ArrayList<GridModel> arrayList = new ArrayList<>();
        for (int i = 0; i <minames.length ; i++) {
            GridModel gg =new GridModel();
            gg.setName(minames[i]);
            gg.setPath(miimage[i]);
            arrayList.add(gg);
        }

        GridView gridview3 = (GridView) findViewById(R.id.main_call);
        gridview3.setAdapter(new CustomAdapter(this,arrayList));

        gridview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
    }
}
