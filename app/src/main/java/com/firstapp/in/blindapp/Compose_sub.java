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

import java.util.ArrayList;
import java.util.Locale;

public class Compose_sub extends AppCompatActivity implements GestureDetector.OnGestureListener,TextToSpeech.OnInitListener {
    private static final int SWAIPE_MIN_DISTANCE = 150;
    private static final int SWAIPE_MAX_OFF_PATH = 300;
    private static final int SWIPE_THRESHOLD_VELOCITY = 250;
    private TextToSpeech ttsobjcompose_sub;
    boolean speakeEnable = false;
    GestureDetectorCompat detectorCompatcompose;
    int selectedPosition;
    ArrayList<GridModel> arrayListcompose;

    public Integer[] Cimage = {R.drawable.address,R.drawable.comsg,R.drawable.sentmsg,R.drawable.backicon};
    public String[] Cnames = {"Address","Message","Send message","Go to back"};
    GridView gridviewcompose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_grid_main);
        // to speake
        ttsobjcompose_sub = new TextToSpeech(this,this);
//        // to detect gesture
        detectorCompatcompose = new GestureDetectorCompat(this,this);

        arrayListcompose = new ArrayList<>();
        for (int i = 0; i <Cnames.length ; i++) {
            GridModel gg =new GridModel();
            gg.setName(Cnames[i]);
            gg.setPath(Cimage[i]);
            arrayListcompose.add(gg);
        }
        gridviewcompose = (GridView) findViewById(R.id.main_call);
        gridviewcompose.setAdapter(new CustomAdapter(this,arrayListcompose));
        gridviewcompose.setOnTouchListener(new AdapterView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detectorCompatcompose.onTouchEvent(event);
            }
        });
        selectedPosition = -1;
        Log.d("myapp","init counter");
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){
            int result = ttsobjcompose_sub.setLanguage(Locale.US);
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
        Log.d("myapp","org pos:"+selectedPosition);
        if(selectedPosition < arrayListcompose.size()-1){
//            catGrid.getChildAt(selectedPosition).setBackgroundColor(Color.WHITE);
            selectedPosition = selectedPosition + 1;
            gridviewcompose.getChildAt(selectedPosition).setBackgroundColor(Color.GRAY);
            switch (selectedPosition) {
                case 0:
                    if (speakeEnable) {
                        speakOut("Address");
                    }
                    break;
                case 1:
                    if (speakeEnable) {
                        speakOut("message");
                    }
                    break;
                case 2:
                    if (speakeEnable) {
                        speakOut("send message");
                    }
                    break;
                case 3:
                    if (speakeEnable) {
                        speakOut("Go to back");
                    }
                    break;
            }
            // if selected postion is greateer than 0 then use white color
            if(selectedPosition > 0){
                gridviewcompose.getChildAt(selectedPosition-1).setBackgroundColor(Color.WHITE);
            }
            Log.d("myapp","selected position:"+selectedPosition);
            View selectedChildView = gridviewcompose.getSelectedView();
            selectedChildView.setBackgroundColor(Color.GRAY);
        }else{
            Log.d("myapp","increment complete");
        }
    }

    private void speakOut(String compose) {
        int result = ttsobjcompose_sub.setLanguage(Locale.US);
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
            Log.d("myapp","This Language is not supported");
        }else{
            ttsobjcompose_sub.speak(compose,TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    private void onTopSwipe() {
        //         increase counter till array list size
        Log.d("myapp","org pos:"+selectedPosition);
        if(selectedPosition > -1){
            gridviewcompose.getChildAt(selectedPosition).setBackgroundColor(Color.WHITE);
            selectedPosition--;
            switch (selectedPosition) {
                case 0:
                    if (speakeEnable) {
                        speakOut("Address");
                    }
                    break;
                case 1:
                    if (speakeEnable) {
                        speakOut("message");
                    }
                    break;
                case 2:
                    if (speakeEnable) {
                        speakOut("send message");
                    }
                    break;
                case 3:
                    if (speakeEnable) {
                        speakOut("Go to back");
                    }
                    break;
            }
//            catGrid.setItemChecked(selectedPosition,true);
            gridviewcompose.getChildAt(selectedPosition).setBackgroundColor(Color.GRAY);
            Log.d("myapp","selected position:"+selectedPosition);
            View selectedChildView = gridviewcompose.getSelectedView();
            selectedChildView.setBackgroundColor(Color.GRAY);
        }else{
            Log.d("myapp","decreament complete");
        }
    }

    private void onRightSwipe() {
        switch (selectedPosition) {
            case 3:
                if (speakeEnable) {
                    speakOut("Go to back");
                }
                Intent intent4 = new Intent(Compose_sub.this,MessageScreen.class);
                intent4.putExtra("selectedPosition", selectedPosition);
                startActivity(intent4);
                break;
        }
    }

    private void onLeftSwipe() {

    }
}
