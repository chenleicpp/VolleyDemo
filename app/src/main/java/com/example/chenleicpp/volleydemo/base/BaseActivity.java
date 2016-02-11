package com.example.chenleicpp.volleydemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.chenleicpp.volleydemo.net.RequestManager;

import butterknife.ButterKnife;

/**
 * Created by chenleicpp on 1/27/16.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0){
            setContentView(getLayoutId());
        }
        ButterKnife.bind(this);
    }

    protected int getLayoutId(){
        return 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RequestManager.cancelAll(this);
    }
}
