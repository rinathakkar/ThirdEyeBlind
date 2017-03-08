
package com.firstapp.in.blindapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class callScreen extends AppCompatActivity {

      public Integer[] callimage = {R.drawable.calllogs, R.drawable.deletelogs, R.drawable.call,R.drawable.backicon};
      public String[] callnames = {"Call logs", "Delete logs", " Make a call","Go to back"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

         GridView gridviewcall = (GridView) findViewById(R.id.main_call);
         gridviewcall.setAdapter(new CustomAdapter(this, callimage, callnames));
         gridviewcall.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent intent = new Intent(callScreen.this,Call_sub.class);
                    intent.putExtra("position",position);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(callScreen.this,Delete_log_sub.class);
                    intent.putExtra("position",position);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent(callScreen.this,Makecall_sub.class);
                    intent.putExtra("position",position);
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent = new Intent(callScreen.this,MainActivity.class);
                    intent.putExtra("position",position);
                    startActivity(intent);
                }
            }
        });
    }
}
