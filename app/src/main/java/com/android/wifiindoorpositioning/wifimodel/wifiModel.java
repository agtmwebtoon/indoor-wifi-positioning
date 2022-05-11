package com.android.wifiindoorpositioning.wifimodel;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class wifiModel {

    private String SSID;
    private int level;
    private int frequency;
    private long timestamp;

    public wifiModel(String SSID, int level, int frequency, long timestamp) {
        this.SSID = SSID;
        this.level = level;
        this.frequency = frequency;
        this.timestamp = timestamp;
    }

    public wifiModel(){}

    public String getSSID() {
        return SSID;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getLevel() {
        return level;
    }

    public String getTimestamp() {
        Date d = new Date(timestamp);
        @SuppressLint("SimpleDateFormat")
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ret = format.format(d);
        return ret;
    }
}
