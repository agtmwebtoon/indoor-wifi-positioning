package com.android.wifiindoorpositioning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    EditText floorNum, roomNum;
    Button startBtn, stopBtn;

    public int floor;
    public String room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        floorNum = (EditText) findViewById(R.id.floorNum);
        roomNum = (EditText) findViewById(R.id.roomNum);
        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);

        try{
            String f = floorNum.getText().toString().trim();

            floor = Integer.parseInt(f);
            Toast.makeText(this, "층 수: " + floor, Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e){
            Toast.makeText(this, "숫자만 입력하세요", Toast.LENGTH_SHORT).show();
        }
        room = roomNum.getText().toString().trim();

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*test*/
                mDatabase.child("test").setValue("테스트");
                Log.d("TAG", "층수: " + floor + ", 호 수: " + room);

                Toast.makeText(getApplicationContext(), "측정 시작", Toast.LENGTH_SHORT).show();
                //TODO: 센싱 데이터 값도 db에 넣기.
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "측정 중지", Toast.LENGTH_SHORT).show();
            }
        });
    }

}