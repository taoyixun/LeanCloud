package com.taoyixun.leancloud;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;

public class MyLeanCloudApp extends Application {

    /**
     * 1714091258@qq.com
     * steam
     */
    private static String[] app1 = new String[]{
            "XiRYkaJFp9pgMhfLMgbfU19e-gzGzoHsz",
            "iiJLb3PfADEOGOs8j10nEfpY"
    };

    /**
     * 1714091258@qq.com
     * test2
     */
    private static String[] app2 = new String[]{
            "BQt0wqNOPzJGkGD8ldivnS29-gzGzoHsz",
            "pRoz22bl9S2V9TIt1hnKIJOU"
    };

    /**
     * 294523018@qq.com
     */
    private static String[] app3 = new String[]{
            "6UYzPpJWMR6LnJYfjsjBXur9-gzGzoHsz",
            "H7UEH6QW8LuA4bG30W19PgM4"
    };

    @Override
    public void onCreate() {
        super.onCreate();

        AVUser.registerSubclass(User.class);
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this, app1[0], app1[1]);
        // 放在 SDK 初始化语句 AVOSCloud.initialize() 后面，只需要调用一次即可
        AVOSCloud.setDebugLogEnabled(true);
    }
}
 