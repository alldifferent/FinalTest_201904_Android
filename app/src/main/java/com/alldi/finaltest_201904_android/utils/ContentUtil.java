package com.alldi.finaltest_201904_android.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ContentUtil {

    private static final String prefName= "UserLoginPref";

    private static final String USER_TOKEN = "UserToken";

    public static void setUserToken(Context context, String userToken){

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putString(USER_TOKEN, userToken).apply();

    }

    public static String getUserToken(Context context){

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return pref.getString(USER_TOKEN, "");

    }

}
