package com.alldi.finaltest_201904_android.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.alldi.finaltest_201904_android.BaseFragment;
import com.alldi.finaltest_201904_android.MainActivity;
import com.alldi.finaltest_201904_android.NoticeActivity;
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

        binding.noticeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Notice noticeData = noticeList.get(position);


                Intent intent = new Intent(getActivity(), NoticeActivity.class);
                intent.putExtra("noticeInfo", noticeData);
                startActivity(intent);

            }
        });


    }

    @Override
    public void setValues() {

        noticeAdapter = new NoticeAdapter(getActivity(), noticeList);
        binding.noticeListView.setAdapter(noticeAdapter);

    }

    @Override
    public void bindViews() {

    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity) getActivity()).setListViewOnFragment(noticeList, noticeAdapter);

    }
}
