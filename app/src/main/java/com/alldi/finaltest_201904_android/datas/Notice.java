package com.alldi.finaltest_201904_android.datas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Notice implements Serializable {

    public int id;
    public String created_at;
    public String title;
    public String content;
    public String type;
    public String expire_date;

    public static Notice getNoticeData(JSONObject jsonNotice){

        Notice notice = new Notice();

        try {
            notice.id = jsonNotice.getInt("id");
            notice.content = jsonNotice.getString("content");
            notice.created_at = jsonNotice.getString("created_at");
            notice.expire_date = jsonNotice.getString("expire_date");
            notice.title = jsonNotice.getString("title");
            notice.type = jsonNotice.getString("type");


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return notice;


    }

}
