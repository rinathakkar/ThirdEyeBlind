package com.firstapp.in.blindapp;

import java.nio.channels.spi.AbstractSelectionKey;

/**
 * Created by Rina on 31-03-2017.
 */
public class GlobalVars {
    public static InputKeyboardTalkback inputModeKeyboardTalkbackActivity;
    public static Thread tts;
    public static AbstractSelectionKey alarmVibrator;
    public static Object inputModeResult;
    public static boolean inputModeKeyboardOnlyNumbers;
    public static Class<InputKeyboardTalkback> lastActivity;


    public static void talk(String string) {
    }
}
