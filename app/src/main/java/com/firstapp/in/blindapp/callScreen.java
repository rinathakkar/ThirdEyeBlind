
package com.firstapp.in.blindapp;

import android.content.Intent;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class callScreen extends AppCompatActivity implements GestureDetector.OnGestureListener,TextToSpeech.OnInitListener {
    private static final int SWAIPE_MIN_DISTANCE = 150;
    private static final int SWAIPE_MAX_OFF_PATH = 300;
    private static final int SWIPE_THRESHOLD_VELOCITY = 250;
    private TextToSpeech ttsobjcall;
    boolean speakeEnable = false;
    GestureDetectorCompat detectorCompatcall;
    int selectedPosition;
    ArrayList<GridModel> arrayListcall;

      public Integer[] callimage = {R.drawable.calllogs, R.drawable.deletelogs, R.drawable.call,R.drawable.backicon};
      public String[] callnames = {"Call logs", "Delete logs", " Make a call","Go to back"};
      GridView gridviewcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_grid_main);
        // to speake
        ttsobjcall = new TextToSpeech(this,this);
//        // to detect gesture
        detectorCompatcall = new GestureDetectorCompat(this,this);

        arrayListcall = new ArrayList<>();
        for (int i = 0; i < callnames.length ; i++) {
            GridModel gg = new GridModel();
            gg.setName(callnames[i]);
            gg.setPath(callimage[i]);
            arrayListcall.add(gg);
        }

        gridviewcall= (GridView) findViewById(R.id.main_call);
         gridviewcall.setAdapter(new CustomAdapter(this, arrayListcall));
        gridviewcall.setOnTouchListener(new AdapterView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detectorCompatcall.onTouchEvent(event);
            }
        });
        selectedPosition = -1;
        Log.d("myapp","init counter");
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){
            int result = ttsobjcall.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS", "This Language is not supported");
            }else{
                speakeEnable = true;
            }
        }else {
            Log.e("TTS","Initilization Failed");
        }
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

    private void onDownSwipe() {
       // Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        Log.d("myapp","org pos:"+selectedPosition);
        if(selectedPosition < arrayListcall.size()-1){
//            catGrid.getChildAt(selectedPosition).setBackgroundColor(Color.WHITE);
            selectedPosition = selectedPosition + 1;
            gridviewcall.getChildAt(selectedPosition).setBackgroundColor(Color.GRAY);
            switch (selectedPosition) {
                case 0:
                    if (speakeEnable) {
                        speakOut("Call logs");
                    }
                    break;
                case 1:
                    if (speakeEnable) {
                        speakOut("Delete logs");
                    }
                    break;
                case 2:
                    if (speakeEnable) {
                        speakOut("make a call");
                    }
                    break;
                case 3:
                    if (speakeEnable) {
                        speakOut("Go to Back");
                    }
                    break;
            }
            // if selected postion is greateer than 0 then use white color
            if(selectedPosition > 0){
                gridviewcall.getChildAt(selectedPosition-1).setBackgroundColor(Color.WHITE);
            }
            Log.d("myapp","selected position:"+selectedPosition);
            View selectedChildView = gridviewcall.getSelectedView();
            selectedChildView.setBackgroundColor(Color.GRAY);
        }else{
            Log.d("myapp","increment complete");
        }

    }

    private void speakOut(String message1) {
        int result = ttsobjcall.setLanguage(Locale.US);
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
            Log.d("myapp","This Language is not supported");
        }else{
            ttsobjcall.speak(message1,TextToSpeech.QUEUE_FLUSH,null);
        }
    }


    private void onTopSwipe() {
//         increase counter till array list size
        Log.d("myapp","org pos:"+selectedPosition);
        if(selectedPosition > -1){
            gridviewcall.getChildAt(selectedPosition).setBackgroundColor(Color.WHITE);
            selectedPosition--;
            switch (selectedPosition) {
                case 0:
                    if (speakeEnable) {
                        speakOut("Call logs");
                    }
                    break;
                case 1:
                    if (speakeEnable) {
                        speakOut("Delete logs");
                    }
                    break;
                case 2:
                    if (speakeEnable) {
                        speakOut("Make a call");
                    }
                    break;
                case 3:
                    if (speakeEnable) {
                        speakOut("Go to back");
                    }
                    break;
            }
//            catGrid.setItemChecked(selectedPosition,true);
            gridviewcall.getChildAt(selectedPosition).setBackgroundColor(Color.GRAY);
            Log.d("myapp","selected position:"+selectedPosition);
            View selectedChildView = gridviewcall.getSelectedView();
            selectedChildView.setBackgroundColor(Color.GRAY);
        }else{
            Log.d("myapp","decreament complete");
        }
    }


    private void onRightSwipe() {
        switch (selectedPosition) {
            case 0:
                Toast.makeText(this, "call logs", Toast.LENGTH_SHORT).show();
                if (speakeEnable) {
                    speakOut("Open call logs");
                }
                Intent intent = new Intent(callScreen.this,Call_logs.class);
                intent.putExtra("selectedPosition", selectedPosition);
                startActivity(intent);
               // Toast.makeText(this, "call logs ", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                if (speakeEnable) {
                    speakOut("Open Delete logs");
                }
                Intent intent1 = new Intent(callScreen.this,Delete_log_sub.class);
                intent1.putExtra("selectedPosition", selectedPosition);
                startActivity(intent1);
               // Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                if (speakeEnable) {
                    speakOut("Open Make a call");
                }
                Intent intent2 = new Intent(callScreen.this,Makecall_sub.class);
                intent2.putExtra("selectedPosition", selectedPosition);
                startActivity(intent2);
               // Toast.makeText(this, "Contacts", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                if (speakeEnable) {
                    speakOut("Open Go to back");
                }
                Intent intent3 = new Intent(callScreen.this,MainActivity.class);
                intent3.putExtra("selectedPosition", selectedPosition);
                startActivity(intent3);
               // Toast.makeText(this, "Music", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void onLeftSwipe() {
    }

}
