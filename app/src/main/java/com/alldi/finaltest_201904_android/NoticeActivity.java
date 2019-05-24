package com.alldi.finaltest_201904_android;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alldi.finaltest_201904_android.adapters.NoticeAdapter;
import com.alldi.finaltest_201904_android.databinding.ActivityNoticeBinding;
import com.alldi.finaltest_201904_android.datas.Notice;

import java.util.ArrayList;
import java.util.List;

public class NoticeActivity extends BaseActivity {

    ActivityNoticeBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        Notice noticeData = (Notice) getIntent().getSerializableExtra("noticeInfo");
        String title = noticeData.title;
        String data = noticeData.created_at;
        String content = noticeData.content;

        act.contentTxt.setText(content);
        act.dateTxt.setText(data);
        act.titleTxt.setText(title);

    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_notice);

    }
}
