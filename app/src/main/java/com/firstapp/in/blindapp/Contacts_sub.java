package com.firstapp.in.blindapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Contacts_sub extends AppCompatActivity {

    public Integer[] coimage = {R.drawable.searchcontacts,R.drawable.call,R.drawable.message,R.drawable.deletecontcats,R.drawable.backicon};
    public String[] conames = {"Contacts","Call","Send a message","Delete Contacts","Go to back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        GridView gridview2 = (GridView) findViewById(R.id.main_call);
        gridview2.setAdapter(new CustomAdapter(this, coimage, conames));

        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}
