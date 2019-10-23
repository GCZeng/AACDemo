package org.zgc.aac.util;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * 日志工具类
 * Created by Nick on 2017/1/10
 */
public class LogUtil {
    private static final String TAG = "zgclog";//日志TAG
    private static boolean isDebug = true;

    public static void init(boolean isDebug) {
        LogUtil.isDebug = isDebug;
        init();
    }

    public static void init() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(0)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag(TAG)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return isDebug;
            }
        });
    }

    public static void d(String msg) {
        Logger.d(msg);
    }

    public static void d(String tag, String msg) {
        Logger.t(tag).d(msg);
    }

    public static void e(String msg) {
        Logger.e(msg);
    }

    public static void e(String tag, String msg) {
        Logger.t(tag).e(msg);
    }

    public static void w(String msg) {
        Logger.w(msg);
    }

    public static void w(String tag, String msg) {
        Logger.t(tag).w(msg);
    }

    public static void v(String msg) {
        Logger.v(msg);
    }

    public static void v(String tag, String msg) {
        Logger.t(tag).v(msg);
    }

    public static void wtf(String msg) {
        Logger.wtf(msg);
    }

    public static void wtf(String tag, String msg) {
        Logger.t(tag).wtf(msg);
    }

    public static void json(String json) {
        Logger.json(json);
    }

//    public static void json(Object object) {
//        String json;
//        try {
//            json = JsonUtil.toJson(object);
//        } catch (Exception e) {
//            json = object.toString();
//            e.printStackTrace();
//        }
//        Logger.json(json);
//    }

    public static void json(String tag, String msg) {
        Logger.t(tag).json(msg);
    }

    public static void xml(String xml) {
        Logger.xml(xml);
    }

    public static void xml(String tag, String msg) {
        Logger.t(tag).xml(msg);
    }

    public static void log(int priority, String tag, String msg, Throwable throwable) {
        Logger.log(priority, tag, msg, throwable);
    }


}
