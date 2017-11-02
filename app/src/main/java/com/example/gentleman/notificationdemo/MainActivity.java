package com.example.gentleman.notificationdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }


    @SuppressWarnings("deprecation")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button :
                //设置通知通道
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                String id = "my_channel_01";
                CharSequence name = "gentleman";
                String description = "xzh";
                //设置重要性
                int importance = NotificationManager.IMPORTANCE_LOW;
                NotificationChannel mChannel = new NotificationChannel(id, name,importance);
                //设置描述
                mChannel.setDescription(description);
                //开启指示灯
                mChannel.enableLights(true);
                //设置指示灯颜色
                mChannel.setLightColor(Color.RED);
                //设置震动
                mChannel.enableVibration(true);
                //设置震动频率
                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                mNotificationManager.createNotificationChannel(mChannel);


                mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                int notifyID = 1;
                String CHANNEL_ID = "my_channel_01";
                Notification notification = new Notification.Builder(MainActivity.this)
                        .setContentTitle("New Message")
                        .setContentText("You've received new messages.")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setChannelId(CHANNEL_ID)
                        .build();
                mNotificationManager.notify(notifyID, notification);


                break;
            default:
                break;
        }
    }
}
