package com.firstapp.in.blindapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class ContactsScreen extends AppCompatActivity {

    public Integer[] coimage = {R.drawable.searchcontacts, R.drawable.createco, R.drawable.backicon};
    public String[] conames = {"Contacts", "Create Contacts", "Go to back"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        GridView gridview2 = (GridView) findViewById(R.id.main_call);
        gridview2.setAdapter(new CustomAdapter(this, coimage, conames));

        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(ContactsScreen.this, Contacts_sub.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(ContactsScreen.this,Create_contacts_sub.class);
                    intent.putExtra("position", position);
                    startActivity(intent);

                } else if (position == 2) {
                    Intent intent = new Intent(ContactsScreen.this, MainActivity.class);
                    intent.putExtra("position", position);
                    startActivity(intent);


                }
            }
        });
    }
}


