package com.firstapp.in.blindapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Sent_sub extends AppCompatActivity {

    public Integer[] SASimage = {R.drawable.sentmsg, R.drawable.deletemsg,R.drawable.deletemsg,R.drawable.backicon};
    public String[] SASnames = {"Sent","Delete message","Delete all sent message","Go to back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        GridView gridviewSAM = (GridView) findViewById(R.id.main_call);
        gridviewSAM.setAdapter(new CustomAdapter(this, SASimage, SASnames));
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
