package com.firstapp.in.blindapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Call_sub extends AppCompatActivity {

    public Integer[] callingimage = {R.drawable.calling, R.drawable.call,R.drawable.sendmessage,R.drawable.addtocontact,R.drawable.backicon};
    public String[] callingnames = {"Call logs", "Call", "Send a message","Add to contacts","Go to back"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        GridView gridviewcalling = (GridView) findViewById(R.id.main_call);
        gridviewcalling.setAdapter(new CustomAdapter(this, callingimage, callingnames));
        gridviewcalling.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 4) {
                    Intent intent = new Intent(Call_sub.this, callScreen.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            }
        });
    }
}
