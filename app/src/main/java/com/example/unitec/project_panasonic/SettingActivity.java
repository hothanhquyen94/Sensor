package com.example.unitec.project_panasonic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unitec.project_panasonic.Adapter.AdapterSpinerSampleInterval;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    Spinner spinnerSample;
    TextView txtBack,txtSave;
    List<Integer> listSampleInterval;
    EditText editAdapterIp,editAdapterPort, editDataInterval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        InputTypeSetting();
        initToobar();
        Spiner_SampleInterval();







    }
    // Init ToolBar
    public void initToobar() {
        toolbar = (Toolbar) findViewById(R.id.toolbarSetting);
        txtBack = (TextView) findViewById(R.id.back);
        txtSave = (TextView) findViewById(R.id.save);
        setSupportActionBar(toolbar);
        txtBack.setOnClickListener(this);
        txtSave.setOnClickListener(this);
        }

    // event onclick at toolBar

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.back:
                toolbar.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentMain = new Intent(SettingActivity.this,MainActivity.class);
                        startActivity(intentMain);
                    }
                });
                break;
            case R.id.save:
                Toast.makeText(this,"SAVE OK",Toast.LENGTH_LONG).show();
        }
    }

    // inits Spiner show set value sample Interval
    public void Spiner_SampleInterval(){
        spinnerSample = (Spinner)findViewById(R.id.vspinerInterval) ;
        int[] ints ={5,10,20,50,100};
        listSampleInterval = new ArrayList<Integer>();
        for (int i = 0;i<ints.length;i++){
            listSampleInterval.add(ints[i]);
        }
        AdapterSpinerSampleInterval adapterSpiner = new AdapterSpinerSampleInterval(this,R.layout.custom_adapter_spiner,listSampleInterval);
        spinnerSample.setAdapter(adapterSpiner);
    }


    // set input data on Edit text
    public void InputTypeSetting(){
        editAdapterIp = (EditText) findViewById(R.id.ipAddress);
        editAdapterPort = (EditText) findViewById(R.id.adapterPort);
        editDataInterval =  (EditText) findViewById(R.id.dataInterval);
        editAdapterPort.setInputType(InputType.TYPE_CLASS_NUMBER |
                InputType.TYPE_NUMBER_FLAG_DECIMAL |
                InputType.TYPE_NUMBER_FLAG_SIGNED);
        editDataInterval.setInputType(InputType.TYPE_CLASS_NUMBER |
                InputType.TYPE_NUMBER_FLAG_DECIMAL |
                InputType.TYPE_NUMBER_FLAG_SIGNED);

        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       android.text.Spanned dest, int dstart, int dend) {
                if (end > start) {
                    String destTxt = dest.toString();
                    String resultingTxt = destTxt.substring(0, dstart)
                            + source.subSequence(start, end)
                            + destTxt.substring(dend);
                    if (!resultingTxt
                            .matches("^\\d{1,3}(\\.(\\d{1,3}(\\.(\\d{1,3}(\\.(\\d{1,3})?)?)?)?)?)?")) {
                        return "";
                    } else {
                        String[] splits = resultingTxt.split("\\.");
                        for (int i = 0; i < splits.length; i++) {
                            if (Integer.valueOf(splits[i]) > 255) {
                                return "";
                            }
                        }
                    }
                }
                return null;
            }
        };
        editAdapterIp.setFilters(filters);
    }
}