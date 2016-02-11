package com.example.chenleicpp.volleydemo.net;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.chenleicpp.volleydemo.AppApplication;
import com.example.chenleicpp.volleydemo.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * Created by chenleicpp on 1/27/16.
 */
public class RequestManager {

    public static final int OUT_TIME = 10000;
    public static final int TIMES_OF_RETRY = 1;

    public RequestManager(){}

    private static RequestQueue mRequestQueue = Volley.newRequestQueue(AppApplication.getContext());

    public static void addRequest(Request<?> request, Object tag){
        if (tag != null){
            request.setTag(tag);
        }
        request.setRetryPolicy(new DefaultRetryPolicy(OUT_TIME,
                TIMES_OF_RETRY,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mRequestQueue.add(request);
        if (BuildConfig.DEBUG){
            Logger.d(request.getUrl());
        }
    }

    public static void cancelAll(Object tag){
        mRequestQueue.cancelAll(tag);
    }
}
