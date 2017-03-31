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

public class Create_contacts_sub extends AppCompatActivity implements GestureDetector.OnGestureListener,TextToSpeech.OnInitListener{
    private static final int SWAIPE_MIN_DISTANCE = 150;
    private static final int SWAIPE_MAX_OFF_PATH = 300;
    private static final int SWIPE_THRESHOLD_VELOCITY = 250;
    private TextToSpeech ttsobjccs;
    boolean speakeEnable = false;
    GestureDetectorCompat detectorCompatccs;
    int selectedPosition;
    ArrayList<GridModel> arrayListccs;

    public Integer[] ccsimage = {R.drawable.searchcontacts, R.drawable.call,R.drawable.createco, R.drawable.backicon};
    public String[] ccsnames = {"input name", "input number","Create contact","Go to back"};
    GridView gridviewccs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_grid_main);
        // to speake
        ttsobjccs = new TextToSpeech(this,this);
//         to detect gesture
        detectorCompatccs = new GestureDetectorCompat(this,this);

        arrayListccs = new ArrayList<>();
        for (int i = 0; i <ccsnames.length ; i++) {
            GridModel gg =new GridModel();
            gg.setName(ccsnames[i]);
            gg.setPath(ccsimage[i]);
            arrayListccs.add(gg);
        }

        gridviewccs = (GridView) findViewById(R.id.main_call);
        gridviewccs.setAdapter(new CustomAdapter(this,arrayListccs));
        gridviewccs.setOnTouchListener(new AdapterView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detectorCompatccs.onTouchEvent(event);
            }
        });
        selectedPosition = -1;
        Log.d("myapp","init counter");
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){
            int result = ttsobjccs.setLanguage(Locale.US);
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
        if(selectedPosition < arrayListccs.size()-1){
//            catGrid.getChildAt(selectedPosition).setBackgroundColor(Color.WHITE);
            selectedPosition = selectedPosition + 1;
            gridviewccs.getChildAt(selectedPosition).setBackgroundColor(Color.GRAY);
            switch (selectedPosition) {
                case 0:
                    if (speakeEnable) {
                        speakOut("input name");
                    }
                    break;
                case 1:
                    if (speakeEnable) {
                        speakOut("input number");
                    }
                    break;
                case 2:
                    if (speakeEnable){
                        speakOut("Create contacts");
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
                gridviewccs.getChildAt(selectedPosition-1).setBackgroundColor(Color.WHITE);
            }
            Log.d("myapp","selected position:"+selectedPosition);
            View selectedChildView = gridviewccs.getSelectedView();
            selectedChildView.setBackgroundColor(Color.GRAY);
        }else{
            Log.d("myapp","increment complete");
        }
    }

    private void speakOut(String create) {
        int result = ttsobjccs.setLanguage(Locale.US);
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
            Log.d("myapp","This Language is not supported");
        }else{
            ttsobjccs.speak(create,TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    private void onTopSwipe() {
        //         increase counter till array list size
        Log.d("myapp","org pos:"+selectedPosition);
        if(selectedPosition > -1){
            gridviewccs.getChildAt(selectedPosition).setBackgroundColor(Color.WHITE);
            selectedPosition--;
            switch (selectedPosition) {
                case 0:
                    if (speakeEnable) {
                        speakOut("input name");
                    }
                    break;
                case 1:
                    if (speakeEnable) {
                        speakOut("input number");
                    }
                    break;
                case 2:
                    if (speakeEnable){
                        speakOut("Create contacts");
                    }
                    break;
                case 3:
                    if (speakeEnable) {
                        speakOut("Go to back");
                    }
                    break;
            }
//            catGrid.setItemChecked(selectedPosition,true);
            gridviewccs.getChildAt(selectedPosition).setBackgroundColor(Color.GRAY);
            Log.d("myapp","selected position:"+selectedPosition);
            View selectedChildView = gridviewccs.getSelectedView();
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
                Intent intent4 = new Intent(Create_contacts_sub.this,ContactsScreen.class);
                intent4.putExtra("selectedPosition", selectedPosition);
                startActivity(intent4);
//                Toast.makeText(this, "Alarm", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void onLeftSwipe() {

    }
}
