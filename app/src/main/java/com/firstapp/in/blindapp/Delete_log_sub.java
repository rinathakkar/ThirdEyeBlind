package com.firstapp.in.blindapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Delete_log_sub extends AppCompatActivity {

    public Integer[] deleteimage = {R.drawable.deletelogs,R.drawable.backicon};
    public String[] deletenames = {"Delete logs","Go to Back"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        GridView gridviewdelete = (GridView) findViewById(R.id.main_call);
        gridviewdelete.setAdapter(new CustomAdapter(this, deleteimage, deletenames));
        gridviewdelete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    Intent intent = new Intent(Delete_log_sub.this, callScreen.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }

            }
        });
    }
}
