package com.alldi.finaltest_201904_android;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alldi.finaltest_201904_android.databinding.ActivityLogoBinding;
import com.alldi.finaltest_201904_android.utils.ContentUtil;

public class LogoActivity extends BaseActivity {

    ActivityLogoBinding act;

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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (ContentUtil.getUserToken(mContect).length() == 0){

                    Intent intent = new Intent(mContect, LoginActivity.class);
                    startActivity(intent);
                    finish();

                }else {

                    String token = ContentUtil.getUserToken(mContect);
                    Intent intent = new Intent(mContect, MainActivity.class);
                    intent.putExtra("token", token);
                    startActivity(intent);
                    finish();

                }

            }
        }, 2000);

    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(LogoActivity.this, R.layout.activity_logo);
    }

}
