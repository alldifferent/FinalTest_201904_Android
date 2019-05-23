package com.alldi.finaltest_201904_android;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.alldi.finaltest_201904_android.adapters.NoticeAdapter;
import com.alldi.finaltest_201904_android.adapters.ViewPagerAdapter;
import com.alldi.finaltest_201904_android.databinding.ActivityMainBinding;
import com.alldi.finaltest_201904_android.datas.Notice;
import com.alldi.finaltest_201904_android.fragments.InfoFragment;
import com.alldi.finaltest_201904_android.utils.ConnectServer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;
    ViewPagerAdapter viewPagerAdapter;
    NoticeAdapter noticeAdapter;
    List<Notice> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {

        act.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(act.tabLayout));
        act.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                act.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void setValues() {

        act.tabLayout.addTab(act.tabLayout.newTab().setText("내 프로필"));
        act.tabLayout.addTab(act.tabLayout.newTab().setText("공지사항"));



        String userToken = getIntent().getStringExtra("token");

        ConnectServer.getRequestInfo(mContect, userToken, new ConnectServer.JsonHandler() {
            @Override
            public void onResponse(JSONObject json) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            int code = json.getInt("code");

                            if(code == 200){

                                JSONObject data = json.getJSONObject("data");
                                JSONObject user = data.getJSONObject("user");

                                String name = user.getString("name");
                                String email = user.getString("email");
                                String billing_account = user.getString("billing_account");
                                String profile_image = user.getString("profile_image");

                                Fragment currentFrag = viewPagerAdapter.getItem(act.viewPager.getCurrentItem());
                                ((InfoFragment) currentFrag).setaccoutText(billing_account);
                                ((InfoFragment) currentFrag).setEmailText(email);
                                ((InfoFragment) currentFrag).setNameText(name);
                                ((InfoFragment) currentFrag).setImgChange(profile_image);


                            }else {
                                String message = json.getString("message");
                                Toast.makeText(mContect, message, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

            }
        });

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), act.tabLayout.getTabCount());
        act.viewPager.setAdapter(viewPagerAdapter);



    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }


    public void setListViewOnFragment(List<Notice> list, NoticeAdapter noticeAdapter){

        String userToken = getIntent().getStringExtra("token");

        ConnectServer.getRequestNotice(mContect, userToken, new ConnectServer.JsonHandler() {
            @Override
            public void onResponse(JSONObject json) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            int code = json.getInt("code");
                            if (code == 200){

                                JSONObject data = json.getJSONObject("data");
                                JSONArray announcements = data.getJSONArray("announcements");

                                list.clear();

                                for (int i = 0; i < announcements.length(); i++){

                                    JSONObject jsonNotice = announcements.getJSONObject(i);
                                    Notice noticeData = Notice.getNoticeData(jsonNotice);

                                    list.add(noticeData);

                                }

                                noticeAdapter.notifyDataSetChanged();


                            }else {
                                String message = json.getString("message");
                                Toast.makeText(mContect, message, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
    }
}
