package com.xutaotao.leancloud;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;

public class MyLeanCloudApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AVUser.registerSubclass(User.class);
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this, "XiRYkaJFp9pgMhfLMgbfU19e-gzGzoHsz", "iiJLb3PfADEOGOs8j10nEfpY");
        // 放在 SDK 初始化语句 AVOSCloud.initialize() 后面，只需要调用一次即可
        AVOSCloud.setDebugLogEnabled(true);

    }
}
 