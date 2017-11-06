package com.example.unitec.project_panasonic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    Toolbar toolbarResult;
    TextView txtCancelResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initToolBarResult();
    }


    // On click on Toobar
    public void initToolBarResult() {
        toolbarResult = (Toolbar) findViewById(R.id.toolbarResult);
        txtCancelResult = (TextView)findViewById(R.id.backResult);
        setSupportActionBar(toolbarResult);
        txtCancelResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMainActivity = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intentMainActivity);
            }
        });
    }

}
