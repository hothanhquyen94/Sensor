package com.example.unitec.project_panasonic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MesureActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbarMeasure;
    TextView txtBack,txtStopResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesure);

        initToolBarMeasure();
    }

    // inits Toobar Measure and onclick
    public void initToolBarMeasure(){
        toolbarMeasure = (Toolbar) findViewById(R.id.toolbarMeasure);
        txtBack = (TextView)findViewById(R.id.backMeasure);
        txtStopResult = (TextView)findViewById(R.id.stopMeasure);
        setSupportActionBar(toolbarMeasure);
        txtBack.setOnClickListener(this);
        txtStopResult.setOnClickListener(this);
    }


    // Onclick ToolBar
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backMeasure:
                toolbarMeasure.findViewById(R.id.backMeasure).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent_Main = new Intent(MesureActivity.this, MainActivity.class);
                        startActivity(intent_Main);
                    }
                });
                break;
            case R.id.stopMeasure:
                toolbarMeasure.findViewById(R.id.stopMeasure).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentResultActivity = new Intent(MesureActivity.this, ResultActivity.class);
                        startActivity(intentResultActivity);
                    }
                });
        }
    }
}

