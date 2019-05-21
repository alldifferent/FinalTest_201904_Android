package com.alldi.finaltest_201904_android.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alldi.finaltest_201904_android.BaseFragment;
import com.alldi.finaltest_201904_android.R;
import com.alldi.finaltest_201904_android.adapters.NoticeAdapter;
import com.alldi.finaltest_201904_android.databinding.FragmentInfoListBinding;
import com.alldi.finaltest_201904_android.databinding.FragmentNoticeListBinding;
import com.alldi.finaltest_201904_android.datas.Notice;

import java.util.ArrayList;
import java.util.List;

public class NoticeFragment extends BaseFragment {

    FragmentNoticeListBinding binding;
    List<Notice> noticeList = new ArrayList<>();
    NoticeAdapter noticeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notice_list, container, false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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

    }
}
