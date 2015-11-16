package com.sintn.hera.mobile.cash.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.R;

import java.util.List;

    /**
     * Created by Administrator on 2015/11/12 0012.
     */
    public class MyWalletAdapter extends BaseAdapter {

        private List<String> contentList;
        private List<Integer> imgId;
        private Context context;

        public MyWalletAdapter(List<String> contentList, Context context, List<Integer> imgId) {
            this.contentList = contentList;
            this.context = context;
            this.imgId = imgId;
        }

        @Override
        public int getCount() {
            return contentList.size();
        }

        @Override
        public Object getItem(int position) {
            return contentList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = LayoutInflater.from(context).inflate(R.layout.my_wallet_item, null);
            TextView tvContent = (TextView)view.findViewById(R.id.tvContent);
            ImageView imgIcon = (ImageView) view.findViewById(R.id.imgBankIcon);
            tvContent.setText(contentList.get(position));
            imgIcon.setImageResource(imgId.get(position));
            return view;
        }
}
