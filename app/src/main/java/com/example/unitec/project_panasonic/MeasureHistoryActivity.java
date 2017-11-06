package com.example.unitec.project_panasonic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class MeasureHistoryActivity extends AppCompatActivity {

    Toolbar toolbarHistory;
    LinearLayout linearLayoutBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure_history);
        initToolBarHistory();
    }

    public void initToolBarHistory() {
        toolbarHistory = (Toolbar) findViewById(R.id.toolbarHistory);
        setSupportActionBar(toolbarHistory);
        linearLayoutBack = (LinearLayout) findViewById(R.id.linearBack);
        linearLayoutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(MeasureHistoryActivity.this, MainActivity.class);
                startActivity(intentBack);
            }
        });
    }

}
