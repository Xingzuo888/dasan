package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class LoginActivitry extends AppCompatActivity implements View.OnClickListener{

    private EditText et_username;
    private EditText et_pwd;
    private Button btn_login;
    private Button btn_reg;
    private Button btn_reset;
    private SeekBar seekBar;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        et_username = (EditText) findViewById(R.id.et_username);
        et_pwd = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_reg = (Button) findViewById(R.id.btn_reg);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        seekBar = (SeekBar) findViewById(R.id.sb_1);
        ratingBar = (RatingBar) findViewById(R.id.rb_1);

        String username = et_username.getText().toString();
        String password = et_pwd.getText().toString();

        btn_login.setOnClickListener(this);
        btn_reg.setOnClickListener(this);
        btn_reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                et_username.setText("");
                et_pwd.setText("");
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setTitle("当前进度值："+ progress + "  用户触摸：" + fromUser);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(seekBar.getContext(),"Start",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(seekBar.getContext(), "Finish", Toast.LENGTH_SHORT).show();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                setTitle("评分：" + rating + "分" + "  用户触发："+ fromUser);
            }
        });
    }

    @Override
    public void onClick(View v) {
       String info = "";
        switch (v.getId()){
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_reg:
                info = "注册";
                break;
        }
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }

    public void myOnclick1(View v){
        seekBar.setProgress(50);
    }
    public void myOnclick2(View v){
        ratingBar.setRating(4);
    }

    public void login() {
        String username = et_username.getText().toString();
        String password = et_pwd.getText().toString();
        if (username.equals("admin") && password.equals("123456")){
            Intent intent = new Intent();
            intent.setClass(this,SuccessActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("password",password);
            startActivity(intent);
        }else {
            Toast.makeText(this, "your username or password is error!", Toast.LENGTH_LONG).show();
        }
    }
}
