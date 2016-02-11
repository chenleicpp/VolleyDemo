package com.example.chenleicpp.volleydemo.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.chenleicpp.volleydemo.AppApplication;
import com.example.chenleicpp.volleydemo.R;
import com.example.chenleicpp.volleydemo.base.BaseActivity;
import com.example.chenleicpp.volleydemo.bean.LoginUser;
import com.example.chenleicpp.volleydemo.net.Request4Login;
import com.example.chenleicpp.volleydemo.net.RequestManager;
import com.example.chenleicpp.volleydemo.utils.MD5Utils;

import butterknife.Bind;

/**
 * Created by chenleicpp on 1/27/16.
 */
public class LoginActivity extends BaseActivity {

    @Bind(R.id.et_name)
    EditText mEtName;
    @Bind(R.id.et_password)
    EditText mEtPwd;
    @Bind(R.id.btn_login)
    Button mBtnLogin;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

    }

    private void initView(){
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("VolleyDemo");
        final String user_name = mEtName.getText().toString();
        final String user_pwd = MD5Utils.MD5Encode(mEtPwd.getText().toString(), "UTF-8");
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin(user_name,user_pwd);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void doLogin(String user_name,String user_pwd){

        RequestManager.addRequest(new Request4Login(LoginUser.URL, user_name,user_pwd,new Response.Listener<LoginUser>() {
            @Override
            public void onResponse(LoginUser response) {
                AppApplication.getContext().setUser(response);
                jumpToMain();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }),this);
    }

    private void jumpToMain(){
        Intent intent = new Intent();
        intent.setClass(this,MainActivity.class);
        startActivity(intent);
    }
}
