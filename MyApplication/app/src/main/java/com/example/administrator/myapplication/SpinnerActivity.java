package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Administrator on 2018/10/11.
 */

public class SpinnerActivity extends AppCompatActivity {
    private RadioGroup radioGroup;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprinner);

        radioGroup = (RadioGroup) findViewById(R.id.rg_1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                setTitle(radioButton.getText());
            }
        });

    }
}
