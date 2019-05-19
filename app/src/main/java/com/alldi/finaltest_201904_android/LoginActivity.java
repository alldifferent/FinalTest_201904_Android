package com.alldi.finaltest_201904_android;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.alldi.finaltest_201904_android.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    
    ActivityLoginBinding act;

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

    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }
}
