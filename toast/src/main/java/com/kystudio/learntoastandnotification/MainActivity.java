package com.kystudio.learntoastandnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnShowToastShort, btnShowToastLong,btnShowToastImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowToastShort = (Button) findViewById(R.id.btnShowToastShort);
        btnShowToastLong = (Button) findViewById(R.id.btnShowToastLong);
        btnShowToastImage = (Button) findViewById(R.id.btnShowToastImage);
        btnShowToastShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, R.string.show_toast_short, Toast.LENGTH_SHORT).show();
                Toast shorToast = Toast.makeText(MainActivity.this, R.string.show_toast_short, Toast.LENGTH_SHORT);
                //shorToast.setGravity(Gravity.CENTER,0 ,0);//垂直、水平居中
                //shorToast.setGravity(Gravity.CENTER,0 ,100);//垂直居中
                shorToast.setGravity(Gravity.CENTER,100 ,0);//水平居中
                shorToast.show();
            }
        });

        btnShowToastLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.show_toast_long, Toast.LENGTH_LONG).show();
            }
        });

        btnShowToastImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast showToastImage = Toast.makeText(MainActivity.this, R.string.show_toast_image, Toast.LENGTH_SHORT);
                showToastImage.setGravity(Gravity.CENTER,0,0);

                // 这段代码使得图片与文字共存于Toast中
                LinearLayout toastView = (LinearLayout) showToastImage.getView();
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.mipmap.ic_launcher);
                toastView.addView(imageView,0);

                /*
                // 这段代码使得Toast只能显示图片
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.mipmap.ic_launcher);
                showToastImage.setView(imageView);
                */
                showToastImage.show();
            }
        });
    }
}
