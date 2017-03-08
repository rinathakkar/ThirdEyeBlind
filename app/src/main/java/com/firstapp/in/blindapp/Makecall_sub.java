package com.firstapp.in.blindapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Makecall_sub extends AppCompatActivity {

    public Integer[] calledimage = {R.drawable.calling, R.drawable.call,R.drawable.backicon};
    public String[] callednames = {"input phone number","call","Go to back"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        GridView gridviewcalling = (GridView) findViewById(R.id.main_call);
        gridviewcalling.setAdapter(new CustomAdapter(this, calledimage, callednames));
        gridviewcalling.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 2) {
                    Intent intent = new Intent(Makecall_sub.this, callScreen.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }

            }
        });


    }
}
