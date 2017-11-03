package com.example.unitec.project_panasonic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.unitec.project_panasonic.R;

import java.util.List;

/**
 * Created by Unitec on 03/11/2017.
 */

public class AdapterSpinerSampleInterval extends ArrayAdapter<Integer> {
    Context context;
    int resource;
    List<Integer> objects;
    public AdapterSpinerSampleInterval( Context context,  int resource,  List<Integer> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_adapter_spiner,parent,false);
        TextView txtSampleInterval = (TextView)view.findViewById(R.id.spinerSampleInterval);
        int sampleInterval = objects.get(position);
        txtSampleInterval.setText(String.valueOf(sampleInterval));
        return view;
    }
}


