package com.firstapp.in.blindapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Create_contacts_sub extends AppCompatActivity {

    public Integer[] coimage = {R.drawable.searchcontacts, R.drawable.call,R.drawable.createco, R.drawable.backicon};
    public String[] conames = {"input name", "input number","Create contact","Go to back"};

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
