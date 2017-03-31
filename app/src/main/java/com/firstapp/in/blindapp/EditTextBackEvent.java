package com.firstapp.in.blindapp;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

/**
 * Created by Rina on 31-03-2017.
 */
public class EditTextBackEvent extends EditText{

    public EditTextBackEvent(Context context) {
        super(context);
    }
    public EditTextBackEvent(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public EditTextBackEvent(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override public boolean onKeyPreIme(int keyCode, KeyEvent event)
    {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP)
        {
            try
            {
                GlobalVars.inputModeKeyboardTalkbackActivity.finish();
            }
            catch(NullPointerException e)
            {
            }
            catch(Exception e)
            {
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
