package com.alldi.finaltest_201904_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.alldi.finaltest_201904_android.R;
import com.alldi.finaltest_201904_android.datas.Notice;

import java.util.List;

public class NoticeAdapter extends ArrayAdapter<Notice> {

    Context mContext;
    List<Notice> mList;
    LayoutInflater inf;

    public NoticeAdapter(Context context, List<Notice> list){

        super(context, R.layout.notice_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if (row == null){
            row = inf.inflate(R.layout.notice_list_item, null);
        }

        Notice noticeData = mList.get(position);

        TextView titleTxt = row.findViewById(R.id.titleTxt);
        TextView dataTxt = row.findViewById(R.id.dataTxt);

        titleTxt.setText(noticeData.title);
        dataTxt.setText(noticeData.created_at);


        return row;
    }
}
