package org.zgc.aac.util;

import android.widget.Toast;

import org.zgc.aac.app.APP;


/**
 * Toast Util
 * Created by FHW
 * on 2017/11/04
 */
public class ToastUtil {
    private ToastUtil() {
    }

    public static void showShort( CharSequence message) {
        Toast.makeText(APP.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showShort( int message) {
        Toast.makeText(APP.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showLong( CharSequence message) {
        Toast.makeText(APP.getContext(), message, Toast.LENGTH_LONG).show();
    }

    public static void showLong( int message) {
        Toast.makeText(APP.getContext(), message, Toast.LENGTH_LONG).show();
    }

    public static void show( CharSequence message, int duration) {
        Toast.makeText(APP.getContext(), message, duration).show();
    }

    public static void show( int message, int duration) {
        Toast.makeText(APP.getContext(), message, duration).show();
    }


}
