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
import com.alldi.finaltest_201904_android.databinding.FragmentInfoListBinding;
import com.bumptech.glide.Glide;

public class InfoFragment extends BaseFragment {

    FragmentInfoListBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info_list, container, false);

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

    public void setNameText(String userName){

        binding.userNameTxt.setText(userName);

    }
    public void setaccoutText(String account){

        binding.accountTxt.setText(account);

    }
    public void setEmailText(String emailText){

        binding.emailTxt.setText(emailText);

    }

    public void setImgChange(String userUrl){

        Glide.with(getActivity()).load(userUrl).into(binding.userImg);

    }
}
