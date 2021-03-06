package com.kystudio.learntoastandnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final int NOTIFICATION_ID = 1011;
    public int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCreateNotification = findViewById(R.id.btnCreateNotification);
        btnCreateNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("channel01", "channel_name",
                            NotificationManager.IMPORTANCE_DEFAULT);
                    manager.createNotificationChannel(channel);
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "channel01");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("哇，有" + counter + "个新消息！");
                builder.setContentText("你已经可以创建新的Notification了。");
                Notification notification = builder.build();

                manager.notify(NOTIFICATION_ID, notification);
            }
        });
    }
}
