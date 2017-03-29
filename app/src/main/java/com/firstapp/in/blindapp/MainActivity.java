package com.firstapp.in.blindapp;

import android.content.Intent;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,TextToSpeech.OnInitListener{
    private static final int SWAIPE_MIN_DISTANCE = 150;
    private static final int SWAIPE_MAX_OFF_PATH = 300;
    private static final int SWIPE_THRESHOLD_VELOCITY = 250;
    private TextToSpeech ttsobj;
    boolean speakeEnable = false;
    GestureDetectorCompat detectorCompat;
    int selectedPosition;
    ArrayList<GridModel> arrayList;


    public String[] pnames = {"Call", "Message", "Contacts", "Music", "Alarm", "Setting", "Readstatus"};
    public Integer[] pimage = {R.drawable.call, R.drawable.message, R.drawable.contacts, R.drawable.music, R.drawable.alarm, R.drawable.setting, R.drawable.readstatus};
    GridView gridview;

       //int selection = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_main);
        // to speake
       ttsobj = new TextToSpeech(this,this);
//        // to detect gesture
       detectorCompat = new GestureDetectorCompat(this,this);


        //edit
         arrayList = new ArrayList<>();
        for (int i = 0; i <pnames.length; i++) {
            GridModel gg =new GridModel();
            gg.setName(pnames[i]);
            gg.setPath(pimage[i]);
            arrayList.add(gg);
        }
        gridview = (GridView) findViewById(R.id.main_gridview);
        gridview.setAdapter(new CustomAdapter(this, arrayList));

//        gridview.setSelection(selection);
        gridview.setOnTouchListener(new AdapterView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detectorCompat.onTouchEvent(event);
            }
        });
        selectedPosition = -1;
        Log.d("myapp","init counter");
}

    /***
     * overrided methods for touch events and speech events
     */

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.detectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
            //
//            if (Math.abs(e1.getY() - e2.getY()) > SWAIPE_MAX_OFF_PATH){
//                return false;
//            }
//            else if (Math.abs(e1.getX() - e2.getX()) > SWAIPE_MAX_OFF_PATH){
//                return false;
//            }
            // right to left swipe
             if (e1.getX() - e2.getX()>SWAIPE_MIN_DISTANCE && Math.abs(velocityX)>SWIPE_THRESHOLD_VELOCITY){
                onLeftSwipe();
                return true;
            }
            // left to right swipe
            else if(e2.getX() - e1.getX()>SWAIPE_MIN_DISTANCE && Math.abs(velocityX)>SWIPE_THRESHOLD_VELOCITY){
                onRightSwipe();
                return true;

            }
            // up swipe
            else if(e1.getY() - e2.getY()>SWAIPE_MIN_DISTANCE && Math.abs(velocityY)>SWIPE_THRESHOLD_VELOCITY) {
                onTopSwipe();
                return true;
            }
            // down swipe
            else if(e2.getY() - e1.getY()>SWAIPE_MIN_DISTANCE && Math.abs(velocityY)>SWIPE_THRESHOLD_VELOCITY) {
                onDownSwipe();
                return true;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    private void onDownSwipe(){
//        Toast.makeText(this,"bottom swipe",Toast.LENGTH_SHORT).show();
        // check for current grid view selected position
//        int position = catGrid.getSelectedItemPosition();
        // increase counter till array list size
        Log.d("myapp","org pos:"+selectedPosition);
        if(selectedPosition < arrayList.size()-1) {
//            catGrid.getChildAt(selectedPosition).setBackgroundColor(Color.WHITE);
            selectedPosition = selectedPosition + 1;
            gridview.getChildAt(selectedPosition).setBackgroundColor(Color.GRAY);
            switch (selectedPosition) {
                case 0:
                    if (speakeEnable) {
                        speakOut("Call");
                    }
                    break;
                case 1:
                    if (speakeEnable) {
                        speakOut("Message");
                    }
                    break;
                case 2:
                    if (speakeEnable) {
                        speakOut("Contacts");
                    }
                    break;
                case 3:
                    if (speakeEnable) {
                        speakOut("Music");
                    }
                    break;
                case 4:
                    if (speakeEnable) {
                        speakOut("Alarm");
                    }
                    break;
                case 5:
                    if (speakeEnable) {
                        speakOut("Setting");
                    }
                    break;
                case 6:
                    if (speakeEnable) {
                        speakOut("Read Status");
                    }
                    break;
            }
            // if selected postion is greateer than 0 then use white color
            if (selectedPosition > 0) {
                gridview.getChildAt(selectedPosition - 1).setBackgroundColor(Color.WHITE);
            }
            Log.d("myapp", "selected position:" + selectedPosition);
            View selectedChildView = gridview.getSelectedView();
            selectedChildView.setBackgroundColor(Color.GRAY);
        }
            else{
            Log.d("myapp","increment complete");
        }
    }

    private void onTopSwipe() {
        // increase counter till array list size
        Log.d("myapp","org pos:"+selectedPosition);
        if(selectedPosition > -1){
            gridview.getChildAt(selectedPosition).setBackgroundColor(Color.WHITE);
            selectedPosition--;
            switch (selectedPosition) {
                case 0:
                    if (speakeEnable) {
                        speakOut("Call");
                    }
                    break;
                case 1:
                    if (speakeEnable) {
                        speakOut("Message");
                    }
                    break;
                case 2:
                    if (speakeEnable) {
                        speakOut("Contacts");
                    }
                    break;
                case 3:
                    if (speakeEnable) {
                        speakOut("Music");
                    }
                    break;
                case 4:
                    if (speakeEnable) {
                        speakOut("Alarm");
                    }
                    break;
                case 5:
                    if (speakeEnable) {
                        speakOut("Setting");
                    }
                    break;
                case 6:
                    if (speakeEnable) {
                        speakOut("Read Status");
                    }
                    break;
            }
//            catGrid.setItemChecked(selectedPosition,true);
            gridview.getChildAt(selectedPosition).setBackgroundColor(Color.GRAY);
            Log.d("myapp","selected position:"+selectedPosition);
            View selectedChildView = gridview.getSelectedView();
            selectedChildView.setBackgroundColor(Color.GRAY);
        }else{
            Log.d("myapp","decreament complete");
        }
    }


    private void onRightSwipe() {
        switch (selectedPosition) {
            case 0:
                if (speakeEnable) {
                    speakOut("Open call");
                }
                Intent intent = new Intent(MainActivity.this, callScreen.class);
                intent.putExtra("selectedPosition", selectedPosition);
                startActivity(intent);
//                Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                if (speakeEnable) {
                    speakOut("Open Message");
                }
                Intent intent1 = new Intent(MainActivity.this,MessageScreen.class);
                intent1.putExtra("selectedPosition", selectedPosition);
                startActivity(intent1);
//                Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                if (speakeEnable) {
                    speakOut("Open Contacts");
                }
                Intent intent2 = new Intent(MainActivity.this,ContactsScreen.class);
                intent2.putExtra("selectedPosition", selectedPosition);
                startActivity(intent2);
//                Toast.makeText(this, "Contacts", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                if (speakeEnable) {
                    speakOut("Open Music");
                }
                Intent intent3 = new Intent(MainActivity.this,MusicScreen.class);
                intent3.putExtra("selectedPosition", selectedPosition);
                startActivity(intent3);
//                Toast.makeText(this, "Music", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                if (speakeEnable) {
                    speakOut("Open Alarm");
                }
                Intent intent4 = new Intent(MainActivity.this,AlarmScreen.class);
                intent4.putExtra("selectedPosition", selectedPosition);
                startActivity(intent4);
//                Toast.makeText(this, "Alarm", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void onLeftSwipe() {
    }

    private void speakOut(String message) {
        int result = ttsobj.setLanguage(Locale.US);
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
            Log.d("myapp","This Language is not supported");
        }else{
            ttsobj.speak(message,TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){
            int result = ttsobj.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS", "This Language is not supported");
            }else{
                speakeEnable = true;
            }
        }else {
            Log.e("TTS","Initilization Failed");
        }
    }
}









