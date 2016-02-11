package com.example.chenleicpp.volleydemo.net;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.example.chenleicpp.volleydemo.bean.LoginUser;
import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by chenleicpp on 1/28/16.
 */
public class Request4Login extends Request<LoginUser>{

    private Response.Listener<LoginUser> mListener;
    private String mUserName,mUserPwd;

    public Request4Login(String url, String name,String pwd,Response.Listener<LoginUser> listener,
                         Response.ErrorListener errorListener){
        super(Method.POST,url,errorListener);
        mListener = listener;
        mUserName = name;
        mUserPwd = pwd;
    }

    @Override
    protected Response<LoginUser> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonStr = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            Logger.json(jsonStr);
            boolean success = new JSONObject(jsonStr).getBoolean("success");
            if (success){
                jsonStr = new JSONObject(jsonStr).optJSONObject("data").toString();

                return Response.success(LoginUser.parseData(jsonStr),
                        HttpHeaderParser.parseCacheHeaders(response));
            }else {
                return Response.error(new VolleyError(new JSONObject(jsonStr).getString("message")));
            }

        }catch (Exception e){
            e.printStackTrace();
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(LoginUser response) {
        mListener.onResponse(response);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> map = new HashMap<String, String>();
        map.put("param.account", mUserName);
        map.put("param.password", mUserPwd);
        map.put("param.origin","android");
        return map;
    }
}
