package com.example.edward.bibleeducation.service;



import android.util.Log;

public class LogUtil {
    private static boolean LogSwitch = false;

    private static boolean isLogSwitch() {
        return LogSwitch;
    }

    public static void setLogSwitch(boolean logSwitch) {
        LogSwitch = logSwitch;
    }

    public static void LogD(String tag, String msg) {
        if (isLogSwitch()) {
            Log.d(tag, msg);
        }

    }


    public static void LogI(String tag, String msg) {
        if (isLogSwitch()) {
            Log.i(tag, msg);
        }

    }


    public static void LogE(String tag, String msg) {
        if (isLogSwitch()) {
            Log.e(tag, msg);
        }
    }


}

