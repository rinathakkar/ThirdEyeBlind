package com.firstapp.in.blindapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class inbox_sub extends AppCompatActivity {

    public Integer[] SAMimage = {R.drawable.message, R.drawable.comsg,R.drawable.deletemsg,R.drawable.call,
            R.drawable.createco,R.drawable.deletemsg,R.drawable.backicon};
    public String[] SAMnames = {"Inbox", "Call", "Compose message","Delete message","Call to contact","Add to new contact","Delete all received message","Go to back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        GridView gridviewSAM = (GridView) findViewById(R.id.main_call);
        gridviewSAM.setAdapter(new CustomAdapter(this, SAMimage, SAMnames));
        gridviewSAM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
    }
}
