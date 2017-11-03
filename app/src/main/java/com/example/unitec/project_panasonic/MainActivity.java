package com.example.unitec.project_panasonic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetting = (ImageButton)findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(this);

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
        }
    }


}
