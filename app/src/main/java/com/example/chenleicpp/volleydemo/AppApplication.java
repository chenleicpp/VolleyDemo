package com.example.chenleicpp.volleydemo;

import android.app.Application;

import com.example.chenleicpp.volleydemo.bean.LoginUser;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by chenleicpp on 1/27/16.
 */
public class AppApplication extends Application {
    private static AppApplication mInstance;

    private LoginUser mUser;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Logger.init("chenlei").logLevel(LogLevel.FULL).hideThreadInfo();
    }

    public static AppApplication getContext(){
        return mInstance;
    }

    public LoginUser getUser() {
        return mUser;
    }

    public void setUser(LoginUser mUser) {
        this.mUser = mUser;
    }
}
