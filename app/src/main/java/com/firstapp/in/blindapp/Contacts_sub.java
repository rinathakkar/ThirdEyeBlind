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

public class Contacts_sub extends AppCompatActivity implements GestureDetector.OnGestureListener,TextToSpeech.OnInitListener{
    private static final int SWAIPE_MIN_DISTANCE = 150;
    private static final int SWAIPE_MAX_OFF_PATH = 300;
    private static final int SWIPE_THRESHOLD_VELOCITY = 250;
    private TextToSpeech ttsobjcontacts_sub;
    boolean speakeEnable = false;
    GestureDetectorCompat detectorCompatco;
    int selectedPosition;
    ArrayList<GridModel> arrayListco_sub;

    public Integer[] csimage = {R.drawable.searchcontacts,R.drawable.call,R.drawable.message,R.drawable.deletecontcats,R.drawable.backicon};
    public String[] csnames = {"Contacts","Call","Send a message","Delete Contacts","Go to back"};
    GridView gridviewco_sub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_grid_main);
        // to speake
        ttsobjcontacts_sub = new TextToSpeech(this,this);
//         to detect gesture
        detectorCompatco = new GestureDetectorCompat(this,this);

        arrayListco_sub = new ArrayList<>();
        for (int i = 0; i <csnames.length ; i++) {
            GridModel gg =new GridModel();
            gg.setName(csnames[i]);
            gg.setPath(csimage[i]);
            arrayListco_sub.add(gg);
        }

        gridviewco_sub = (GridView) findViewById(R.id.main_call);
        gridviewco_sub.setAdapter(new CustomAdapter(this, arrayListco_sub));
        gridviewco_sub.setOnTouchListener(new AdapterView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detectorCompatco.onTouchEvent(event);
            }
        });
        selectedPosition = -1;
        Log.d("myapp","init counter");
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){
            int result = ttsobjcontacts_sub.setLanguage(Locale.US);
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
        if(selectedPosition < arrayListco_sub.size()-1){
//            catGrid.getChildAt(selectedPosition).setBackgroundColor(Color.WHITE);
            selectedPosition = selectedPosition + 1;
            gridviewco_sub.getChildAt(selectedPosition).setBackgroundColor(Color.GRAY);
            switch (selectedPosition) {
                case 0:
                    if (speakeEnable) {
                        speakOut("Contacts");
                    }
                    break;
                case 1:
                    if (speakeEnable) {
                        speakOut("Call");
                    }
                    break;
                case 2:
                    if (speakeEnable){
                        speakOut("Send a message");
                    }
                case 3:
                    if (speakeEnable){
                        speakOut("Delete contacts");
                    }
                case 4:
                    if (speakeEnable) {
                        speakOut("Go to back");
                    }
                    break;
            }
            // if selected postion is greateer than 0 then use white color
            if(selectedPosition > 0){
                gridviewco_sub.getChildAt(selectedPosition-1).setBackgroundColor(Color.WHITE);
            }
            Log.d("myapp","selected position:"+selectedPosition);
            View selectedChildView = gridviewco_sub.getSelectedView();
            selectedChildView.setBackgroundColor(Color.GRAY);
        }else{
            Log.d("myapp","increment complete");
        }

    }

    private void speakOut(String contacts_sub) {
        int result = ttsobjcontacts_sub.setLanguage(Locale.US);
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
            Log.d("myapp","This Language is not supported");
        }else{
            ttsobjcontacts_sub.speak(contacts_sub,TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    private void onTopSwipe() {
        //         increase counter till array list size
        Log.d("myapp","org pos:"+selectedPosition);
        if(selectedPosition > -1){
            gridviewco_sub.getChildAt(selectedPosition).setBackgroundColor(Color.WHITE);
            selectedPosition--;
            switch (selectedPosition) {
                case 0:
                    if (speakeEnable) {
                        speakOut("Contacts");
                    }
                    break;
                case 1:
                    if (speakeEnable) {
                        speakOut("Call");
                    }
                    break;
                case 2:
                    if (speakeEnable){
                        speakOut("Send a message");
                    }
                case 3:
                    if (speakeEnable){
                        speakOut("Delete contacts");
                    }
                case 4:
                    if (speakeEnable) {
                        speakOut("Go to back");
                    }
                    break;
            }
//            catGrid.setItemChecked(selectedPosition,true);
            gridviewco_sub.getChildAt(selectedPosition).setBackgroundColor(Color.GRAY);
            Log.d("myapp","selected position:"+selectedPosition);
            View selectedChildView = gridviewco_sub.getSelectedView();
            selectedChildView.setBackgroundColor(Color.GRAY);
        }else{
            Log.d("myapp","decreament complete");
        }

    }

    private void onRightSwipe() {
        switch (selectedPosition) {
            case 4:
                if (speakeEnable) {
                    speakOut("Go to back");
                }
                Intent intent4 = new Intent(Contacts_sub.this,ContactsScreen.class);
                intent4.putExtra("selectedPosition", selectedPosition);
                startActivity(intent4);
//                Toast.makeText(this, "Alarm", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void onLeftSwipe() {

    }
}
