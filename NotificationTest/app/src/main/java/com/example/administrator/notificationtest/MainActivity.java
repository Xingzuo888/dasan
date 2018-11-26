package com.example.administrator.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_notice:
                Intent intent = new Intent(this,NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentIntent(pi)
//                        .setStyle(new NotificationCompat.BigTextStyle().bigText("Learn how to build notification, send and ync data, and use voice action. Get the official Andriod IDE and developer tools to build apps for Andriod"))//显示全部内容
//                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.big_image)))//显示大图片
                        .setPriority(NotificationCompat.PRIORITY_MAX)//设置重要程度  DEFAULT 默认，MIN 最底，LOW 较低，HIGH 较高，MAX 最重要
//                        .setSound(Uri.fromFile(new File("/system/medio/audio/ringtones/Luna.ogg")))//允许通知播放一段音频
//                        .setVibrate(new long[]{0,1000,1000,1000}) //通知时振动 下标0 表示静止 下标1 振动  下标2 静止  依次类推  还要声明权限
//                        .setLights(Color.GREEN,1000,1000)//控制LED灯 一闪一闪
//                        .setAutoCancel(true)//取消显示的第一种方法
                        .setDefaults(NotificationCompat.DEFAULT_ALL)//使用默认效果
                        .build();
                manager.notify(1,notification);
                break;
            default:
                break;
        }
    }
}
