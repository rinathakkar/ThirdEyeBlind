package com.firstapp.in.blindapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Sent_sub extends AppCompatActivity {

    public Integer[] SASimage = {R.drawable.sentmsg, R.drawable.deletemsg,R.drawable.deletemsg,R.drawable.backicon};
    public String[] SASnames = {"Sent","Delete message","Delete all sent message","Go to back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_grid_main);
        ArrayList<GridModel> arrayList = new ArrayList<>();
        for (int i = 0; i <SASnames.length ; i++) {
            GridModel gg =new GridModel();
            gg.setName(SASnames[i]);
            gg.setPath(SASimage[i]);
            arrayList.add(gg);
        }

        GridView gridviewSAM = (GridView) findViewById(R.id.main_call);
        gridviewSAM.setAdapter(new CustomAdapter(this, arrayList));
        gridviewSAM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 3) {
                    Intent intent = new Intent(Sent_sub.this,MessageScreen.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }

            }
        });
    }
}
