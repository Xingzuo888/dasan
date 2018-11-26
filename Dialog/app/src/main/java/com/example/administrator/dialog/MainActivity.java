package com.example.administrator.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String[] single_list = {"男","女","女博士","程序员"};
    String[] multi_list = {"篮球","足球","电影","上网"};
    String[] item_list = {"项目经理","策划","测试","美工","程序员"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }
    private void dialog1(View view){
        AlertDialog.Builder ab1 = new AlertDialog.Builder(this);
        ab1.setTitle("确定对话框");
        ab1.setIcon(R.mipmap.ic_launcher);
        ab1.setMessage("确定对话框提示内容");
        ab1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "点击了确定按钮！", Toast.LENGTH_SHORT).show();
            }
        });
        ab1.setNegativeButton("取消",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "点击了取消按钮！", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = ab1.create();
        dialog.show();
    }
    private void dialog2(View view){
        AlertDialog.Builder ab2 = new AlertDialog.Builder(this);
        ab2.setTitle("选择性别");
        ab2.setIcon(R.mipmap.ic_launcher);
        ab2.setSingleChoiceItems(single_list,0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = single_list[which];
                Toast.makeText(MainActivity.this,"这个人是"+str+"!",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = ab2.create();
        dialog.show();
    }
    private void dialog3(View view){
        AlertDialog.Builder ab3 = new AlertDialog.Builder(this);
        ab3.setTitle("爱好");
        ab3.setIcon(R.mipmap.ic_launcher);
        ab3.setMultiChoiceItems(multi_list,null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this,"我喜欢上了"+multi_list[which]+"!",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"我不喜欢"+multi_list[which]+"!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ab3.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = ab3.create();
        dialog.show();
    }
    private void dialog4(View view){
        AlertDialog.Builder ab4 = new AlertDialog.Builder(this);
        ab4.setTitle("部门列表");
        ab4.setIcon(R.mipmap.ic_launcher);
        ab4.setItems(item_list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"我是"+item_list[which]+"!",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = ab4.create();
        dialog.show();
    }
    private void dialog5(View view){
        View v = LayoutInflater.from(this).inflate(R.layout.dialog_layout,null);
        AlertDialog.Builder ab5 = new AlertDialog.Builder(this);
        ab5.setTitle("自定义对话框");
        ab5.setIcon(R.mipmap.ic_launcher);
        ab5.setView(v);
        ab5.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "点击了确定按钮！", Toast.LENGTH_SHORT).show();
            }
        });
        ab5.setNegativeButton("取消",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "点击了取消按钮！", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = ab5.create();
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                dialog1(v);
                break;
            case R.id.button2:
                dialog2(v);
                break;
            case R.id.button3:
                dialog3(v);
                break;
            case R.id.button4:
                dialog4(v);
                break;
            case R.id.button5:
                dialog5(v);
                break;
        }
    }
}
