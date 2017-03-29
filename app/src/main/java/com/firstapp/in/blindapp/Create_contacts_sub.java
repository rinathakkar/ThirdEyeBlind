package com.firstapp.in.blindapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Create_contacts_sub extends AppCompatActivity {

    public Integer[] ccsimage = {R.drawable.searchcontacts, R.drawable.call,R.drawable.createco, R.drawable.backicon};
    public String[] ccsnames = {"input name", "input number","Create contact","Go to back"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_grid_main);

        ArrayList<GridModel> arrayList = new ArrayList<>();
        for (int i = 0; i <ccsnames.length ; i++) {
            GridModel gg =new GridModel();
            gg.setName(ccsnames[i]);
            gg.setPath(ccsimage[i]);
            arrayList.add(gg);
        }

        GridView gridview2 = (GridView) findViewById(R.id.main_call);
        gridview2.setAdapter(new CustomAdapter(this,arrayList));

        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
