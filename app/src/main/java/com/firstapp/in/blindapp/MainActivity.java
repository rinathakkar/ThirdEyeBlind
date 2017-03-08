package com.firstapp.in.blindapp;

import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
//    private static final int SWAIPE_MIN_DISTANCE = 150;
//    private static final int SWAIPE_MAX_OFF_PATH = 300;
//    private static final int SWIPE_THRESHOLD_VELOCITY = 250;
//    private TextToSpeech ttsobj;
//    boolean speakeEnable = false;
//    GestureDetectorCompat detectorCompat;

    public String[] pnames = {"Call", "Message", "Contacts", "Music", "Alarm", "Setting", "Readstatus"};
    public Integer[] pimage = {R.drawable.call, R.drawable.message, R.drawable.contacts, R.drawable.music, R.drawable.alarm, R.drawable.setting, R.drawable.readstatus};
    GridView gridview;

    //    int selection = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // to speake
//        ttsobj = new TextToSpeech(this,this);
//        // to detect gesture
//        detectorCompat = new GestureDetectorCompat(this,this);


        gridview = (GridView) findViewById(R.id.main_gridview);
        gridview.setAdapter(new CustomAdapter(this, pimage, pnames));

//        gridview.setSelection(selection);
//        gridview.setOnTouchListener(this);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, callScreen.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(MainActivity.this, MessageScreen.class);
                    intent.putExtra("position", position);
                    startActivity(intent);

                } else if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, ContactsScreen.class);
                    intent.putExtra("position", position);
                    startActivity(intent);

                } else if (position == 3) {
                    Intent intent = new Intent(MainActivity.this, MusicScreen.class);
                    intent.putExtra("position", position);
                    startActivity(intent);

                } else if (position == 4) {
                    Intent intent = new Intent(MainActivity.this, AlarmScreen.class);
                    intent.putExtra("position", position);
                    startActivity(intent);

                }
            }
        });

    }
}

    /***
     * overrided methods for touch events and speech events
     */

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        this.detectorCompat.onTouchEvent(event);
//        return super.onTouchEvent(event);
//    }
//
//    @Override
//    public boolean onDown(MotionEvent e) {
//        return false;
//    }
//
//    @Override
//    public void onShowPress(MotionEvent e) {
//
//    }
//
//    @Override
//    public boolean onSingleTapUp(MotionEvent e) {
//        return false;
//    }
//
//    @Override
//    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        return false;
//    }
//
//    @Override
//    public void onLongPress(MotionEvent e) {
//
//    }
//
//    @Override
//    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        try {
//            //
//            if (Math.abs(e1.getY() - e2.getY()) > SWAIPE_MAX_OFF_PATH){
//                return false;
//            }
//            else if (Math.abs(e1.getX() - e2.getX()) > SWAIPE_MAX_OFF_PATH){
//                return false;
//            }
//            // right to left swipe
//            else if (e1.getX() - e2.getX()>SWAIPE_MIN_DISTANCE && Math.abs(velocityX)>SWIPE_THRESHOLD_VELOCITY){
//                onLeftSwipe();
//                return true;
//            }
//            // left to right swipe
//            else if(e2.getX() - e1.getX()>SWAIPE_MIN_DISTANCE && Math.abs(velocityX)>SWIPE_THRESHOLD_VELOCITY){
//                onRightSwipe();
//                return true;
//
//            }
//            // up swipe
//            else if(e1.getY() - e2.getY()>SWAIPE_MIN_DISTANCE && Math.abs(velocityY)>SWIPE_THRESHOLD_VELOCITY) {
//                onTopSwipe();
//                return true;
//            }
//            // down swipe
//            else if(e2.getY() - e1.getY()>SWAIPE_MIN_DISTANCE && Math.abs(velocityY)>SWIPE_THRESHOLD_VELOCITY) {
//                onBottomSwipe();
//                return true;
//            }
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    private void onBottomSwipe() {
//        selection = selection + 1;
//        gridview.setSelection(selection);
//        Log.d("myapp","selected view"+gridview.getSelectedItemPosition());
//        Toast.makeText(this, "dowm swipe ", Toast.LENGTH_SHORT).show();
//        if (speakeEnable){
//            speakOut("down swipe");
//        }
//    }
//
//    private void onTopSwipe() {
//        Toast.makeText(this, "up swipe ", Toast.LENGTH_SHORT).show();
//        if (speakeEnable){
//            speakOut("up swipe");
//        }
//    }
//
//
//    private void onRightSwipe() {
//        Toast.makeText(this, "Left swipe ", Toast.LENGTH_SHORT).show();
//        if (speakeEnable){
//            speakOut("Left swipe");
//        }
//    }
//    private void onLeftSwipe() {
//        int position = gridview.getSelectedItemPosition();
//
//        if (position == 0) {
//            Intent intent = new Intent(MainActivity.this, callScreen.class);
//            intent.putExtra("position", position);
//            startActivity(intent);
//        }
//        else if(position==1){
//            Intent intent = new Intent(MainActivity.this,MessageScreen .class);
//            intent.putExtra("position", position);
//            startActivity(intent);
//
//        }
//        else if(position==2){
//            Intent intent = new Intent(MainActivity.this,ContactsScreen.class);
//            intent.putExtra("position", position);
//            startActivity(intent);
//
//        }
//        else if(position==3){
//            Intent intent = new Intent(MainActivity.this,MusicScreen.class);
//            intent.putExtra("position", position);
//            startActivity(intent);
//
//        }
//        else if(position==4){
//            Intent intent = new Intent(MainActivity.this,AlarmScreen.class);
//            intent.putExtra("position", position);
//            startActivity(intent);
//
//        }
//        Toast.makeText(this, "Right swipe ", Toast.LENGTH_SHORT).show();
//        if (speakeEnable){
//            speakOut("Right swipe");
//        }
//    }
//
//    private void speakOut(String message) {
//        int result = ttsobj.setLanguage(Locale.US);
//        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
//            Log.d("myapp","This Language is not supported");
//        }else{
//            ttsobj.speak(message,TextToSpeech.QUEUE_FLUSH,null);
//        }
//    }
//
//
//    @Override
//    public void onInit(int status) {
//        if (status == TextToSpeech.SUCCESS){
//            int result = ttsobj.setLanguage(Locale.US);
//            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
//                Log.e("TTS", "This Language is not supported");
//            }else{
//                speakeEnable = true;
//            }
//        }else {
//            Log.e("TTS","Initilization Failed");
//        }
//
//    }
//
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        return false;
//    }
//}









