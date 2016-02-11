package com.example.chenleicpp.volleydemo.bean;

import com.example.chenleicpp.volleydemo.AppConfig;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by chenleicpp on 1/28/16.
 */
public class LoginUser {

    public static final String URL = AppConfig.URL_WEB + "login" + AppConfig.URL_ACTION;

    private boolean samePwd;
    private String hpCode;
    private String token;
    private String hpName;
    private String depCode;
    private String userId;
    private String depName;
    private String userName;
    private List<UserApp> userApp;
    private String userType;

    public static class UserApp{
        private String appCode;
        private String appName;
        private String appType;
        private String appUrl;

        public String getAppCode() {
            return appCode;
        }

        public void setAppCode(String appCode) {
            this.appCode = appCode;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public String getAppUrl() {
            return appUrl;
        }

        public void setAppUrl(String appUrl) {
            this.appUrl = appUrl;
        }

        @Override
        public String toString() {
            return "UserApp{" +
                    "appCode='" + appCode + '\'' +
                    ", appName='" + appName + '\'' +
                    ", appType='" + appType + '\'' +
                    ", appUrl='" + appUrl + '\'' +
                    '}';
        }
    }

    public boolean isSamePwd() {
        return samePwd;
    }

    public void setSamePwd(boolean samePwd) {
        this.samePwd = samePwd;
    }

    public String getHpCode() {
        return hpCode;
    }

    public void setHpCode(String hpCode) {
        this.hpCode = hpCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHpName() {
        return hpName;
    }

    public void setHpName(String hpName) {
        this.hpName = hpName;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public static LoginUser parseData(String data){
        Gson gson = new Gson();
        LoginUser user = gson.fromJson(data,LoginUser.class);
        return user;
    }

    public List<UserApp> getUserApp() {
        return userApp;
    }

    public void setUserApp(List<UserApp> userApp) {
        this.userApp = userApp;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "samePwd=" + samePwd +
                ", hpCode='" + hpCode + '\'' +
                ", token='" + token + '\'' +
                ", hpName='" + hpName + '\'' +
                ", depCode='" + depCode + '\'' +
                ", userId='" + userId + '\'' +
                ", depName='" + depName + '\'' +
                ", userName='" + userName + '\'' +
                ", userApp=" + userApp +
                ", userType='" + userType + '\'' +
                '}';
    }
}
