package com.taoyixun.leancloud;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by XuTaoTao on 2018/9/14.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this, "6UYzPpJWMR6LnJYfjsjBXur9-gzGzoHsz", "H7UEH6QW8LuA4bG30W19PgM4");
        // 放在 SDK 初始化语句 AVOSCloud.initialize() 后面，只需要调用一次即可
        AVOSCloud.setDebugLogEnabled(true);
    }
}
