package com.android.wifiindoorpositioning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaDataSource;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    Spinner floorNum, roomNum;
    Button startBtn, stopBtn;
    WifiManager wifiManager;
    BroadcastReceiver wifiScanReceiver;

    public int floor;
    public String f,r;
    public String room;
    String[] floors = {"층","2층", "3층", "4층"};
    String[] roomNums = {"1호","2호","3호"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        floorNum = (Spinner) findViewById(R.id.floorNum);
        roomNum = (Spinner) findViewById(R.id.roomNum);
        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, floors
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floorNum.setAdapter(adapter);

        ArrayAdapter<String> Radapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, roomNums
        );
        Radapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomNum.setAdapter(Radapter);

        /**
         * @auther Me
         * @since 2022/05/05 9:51 오후
         와이파이 신호 받아 올 수 있도록 wifi메니저 인스턴스 구현
         **/

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        /**
         * @auther Me
         * @since 2022/05/05 9:53 오후
         만약 신호를 받아왔다면 scanSucess로 이동
         **/

        wifiScanReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context c, Intent intent) {
                boolean success = intent.getBooleanExtra(
                        WifiManager.EXTRA_RESULTS_UPDATED, false);
                if (success) {
                    scanSuccess();
                } else {
                    // scan failure handling
                    Log.d("wifi", "error");
                }
            }
        };


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        getApplicationContext().registerReceiver(wifiScanReceiver, intentFilter);


        floorNum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                f = floors[position];

                floor = f.charAt(0) - '0';
                Log.d("floor",floor+"층 선택");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                f = "층";
            }
        });
        roomNum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                r = roomNums[position];
                room = r;
                Log.d("roomNum",room+" 선택");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                r = "호 수";
            }
        });

        /**
         * @auther Me
         * @since 2022/05/05 9:53 오후
         스캔시작 버튼 누르면 동작하도록 구현 스캔하는데 AP가 많으면 2~3초 정도 걸림
         **/

        //TODO Thread를 이용해 n초당 1번씩 스캔하도록 함

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean success = wifiManager.startScan();

                if (!success) {
                    // scan failure handling
                    Log.d("wifi", "error");
                }

            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "측정 중지", Toast.LENGTH_SHORT).show();
            }
        });


    }

    /**
     * @auther Me
     * @since 2022/05/05 9:54 오후
     만약 스캔 성공 했다면 디버그창에 그대로 출력
     **/

    //TODO Firebase에 와이파이 신호 정보 그대로 저장


    private void scanSuccess() {
        List<ScanResult> results = wifiManager.getScanResults();
        for( ScanResult result: results) {
            Log.d("wifi", result.level + " " + result.SSID);
        }
        Toast.makeText(getApplicationContext(), "완료", Toast.LENGTH_SHORT).show();

    }

}