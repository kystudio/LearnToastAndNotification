package com.kystudio.learntoastandnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnCreateNotification;
    public static final int NOTIFICATION_ID = 1011;
    public int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateNotification = (Button) findViewById(R.id.btnCreateNotification);
        btnCreateNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("哇，有" + counter + "个新消息！");
                builder.setContentText("你已经可以创建新的Notification了。");
                Notification notification = builder.build();
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(NOTIFICATION_ID, notification);
            }
        });
    }
}
