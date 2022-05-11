package com.android.wifiindoorpositioning.wifimodel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.wifiindoorpositioning.R;

import java.util.ArrayList;

public class listViewAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflator = null;
    ArrayList<wifiModel> model;


    public listViewAdapter(Context context, ArrayList<wifiModel> model){
        this.mContext = context;
        this.mLayoutInflator = LayoutInflater.from(mContext);
        this.model = model;

    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public Object getItem(int i) {
        return model.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        @SuppressLint({"InflateParams", "ViewHolder"})
        View mView = mLayoutInflator.inflate(R.layout.list_view_layout, null);

        TextView ssid = (TextView) mView.findViewById(R.id.ssid);
        TextView level = (TextView) mView.findViewById(R.id.level);
        TextView freq = (TextView) mView.findViewById(R.id.freq);
        TextView timestamp = (TextView) mView.findViewById(R.id.timestamp);

        ssid.setText(model.get(i).getSSID());
        level.setText("level: " + model.get(i).getLevel() + "db");
        freq.setText("freq: " + model.get(i).getFrequency());
        timestamp.setText(model.get(i).getTimestamp());

        return mView;


    }
}
