package org.zgc.aac.app;

import android.app.Application;
import android.content.Context;

import org.zgc.aac.util.LogUtil;
import org.zgc.aac.util.ScreenAdapter;

/**
 * Author:Nick
 * Time2018/7/2 12:15
 * Description
 */
public class APP extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        setContext(this.getApplicationContext());

        ScreenAdapter.setup(this);
        ScreenAdapter.register(this, 360, ScreenAdapter.MATCH_UNIT_DP, ScreenAdapter.MATCH_BASE_WIDTH);

        LogUtil.init();
    }

    public static void setContext(Context context) {
        APP.context = context;
    }

    public static Context getContext() {
        return context;
    }
}
