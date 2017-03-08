package com.firstapp.in.blindapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MessageScreen extends AppCompatActivity {

    public Integer[] mimage = {R.drawable.message,R.drawable.sentmsg,R.drawable.comsg,R.drawable.backicon};
    public String[] mnames = {"Inbox","Sent","Compose","Go to back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        GridView gridviewcall = (GridView) findViewById(R.id.main_call);
        gridviewcall.setAdapter(new CustomAdapter(this, mimage, mnames));
        gridviewcall.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent intent = new Intent(MessageScreen.this, inbox_sub.class);
                    intent.putExtra("position",position);
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent = new Intent(MessageScreen.this, Sent_sub.class);
                    intent.putExtra("position",position);
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent = new Intent(MessageScreen.this, Compose_sub.class);
                    intent.putExtra("position",position);
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent = new Intent(MessageScreen.this, MainActivity.class);
                    intent.putExtra("position",position);
                    startActivity(intent);
                }
            }
        });
    }
}
