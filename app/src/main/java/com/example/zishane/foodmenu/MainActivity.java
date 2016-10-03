package com.example.zishane.foodmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private TextView tvOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOrder = (TextView) findViewById(R.id.tv_Food);
        for (int i : id){
            CheckBox chk = (CheckBox)findViewById(i);
            chk.setOnCheckedChangeListener(this);
        }
    }

    //CheckBox Array 1~10 and small
    int[] id = {R.id.ch1, R.id.ch2,
            R.id.ch3, R.id.ch4,
            R.id.ch5, R.id.ch6,
            R.id.ch7, R.id.ch8,
            R.id.ch9, R.id.ch10,
            R.id.ch_small};

    public void order(View v){
        tvOrder.setText("");
        String msg = "";
        CheckBox ch;

        for (int i : id){
            ch = (CheckBox) findViewById(i);
            if (ch.isChecked()){
                msg += ch.getText() + "\n";

            }
        }

        if (msg.length() > 0){
            tvOrder.setText(msg);
        }else {
            tvOrder.setText("請點餐");
        }
    }

    ArrayList<CompoundButton> selected = new ArrayList<>();

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String msg = "";
        tvOrder.setText("");

        if (isChecked){
            if (buttonView.getId() == R.id.ch_small){
                tvOrder.setTextSize(20);
            }else {
            selected.add(buttonView);
            }
        }else {
            if (buttonView.getId() == R.id.ch_small){
                tvOrder.setTextSize(30);
            }else {
            selected.remove(buttonView);
            }
        }

        for (CompoundButton i : selected){
            msg += i.getText() + "\n";
        }

        if (msg.length() > 0){
            tvOrder.setText(msg);
        }else {
            tvOrder.setText("請點餐");
        }
    }
}

