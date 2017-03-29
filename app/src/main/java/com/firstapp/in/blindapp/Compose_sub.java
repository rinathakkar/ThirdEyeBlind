package com.firstapp.in.blindapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Compose_sub extends AppCompatActivity {

    public Integer[] Cimage = {R.drawable.address,R.drawable.comsg,R.drawable.sentmsg,R.drawable.backicon};
    public String[] Cnames = {"Address","Message","Send message","Go to back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_grid_main);

        ArrayList<GridModel> arrayList = new ArrayList<>();
        for (int i = 0; i <Cnames.length ; i++) {
            GridModel gg =new GridModel();
            gg.setName(Cnames[i]);
            gg.setPath(Cimage[i]);
            arrayList.add(gg);
        }
        GridView gridviewC = (GridView) findViewById(R.id.main_call);
        gridviewC.setAdapter(new CustomAdapter(this,arrayList));
        gridviewC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 3) {
                    Intent intent = new Intent(Compose_sub.this,MessageScreen.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }

            }
        });
    }
}
