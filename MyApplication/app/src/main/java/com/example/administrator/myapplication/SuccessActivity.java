package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/9/26.
 */

public class SuccessActivity extends AppCompatActivity {
    private TextView tv_username = null;
    private TextView tv_password = null;
    private String username,password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        tv_username = (TextView) findViewById(R.id.tv_username);
        tv_password = (TextView) findViewById(R.id.tv_password);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        password = intent.getStringExtra("password");
        Toast.makeText(this, username + password, Toast.LENGTH_SHORT).show();

        tv_username.setText("用户名：" + username);
        tv_password.setText("密码：" + password);
    }
}
