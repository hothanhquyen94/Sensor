package com.example.unitec.project_panasonic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnSetting,btnHistory,btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart  = (ImageButton)findViewById(R.id.btnstart);
        btnHistory = (ImageButton)findViewById(R.id.btnHistory);
        btnSetting = (ImageButton)findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
        btnStart.setOnClickListener(this);

    }

    /**
     * event onclick button on mainActivity
     * */
    @Override

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSetting:
                Intent intent_Setting = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent_Setting);
                break;
            case R.id.btnHistory:
                Intent intent_History = new Intent(MainActivity.this,MeasureHistoryActivity.class);
                startActivity(intent_History);
                break;
            case R.id.btnstart:
                Intent intent_Measure = new Intent(MainActivity.this,MesureActivity.class);
                startActivity(intent_Measure);
        }
    }


}
