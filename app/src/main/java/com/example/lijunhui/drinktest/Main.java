package com.example.lijunhui.drinktest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import net.simonvt.menudrawer.MenuDrawer;

import java.util.Timer;
import java.util.TimerTask;



public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        mDrawer = MenuDrawer.attach(this);
        mDrawer.setContentView(R.layout.activity_main);
        mDrawer.setMenuView(R.layout.select);

        Button button3 = (Button) findViewById(R.id.button_3);
        Button button2 = (Button) findViewById(R.id.button_2);
        Button button5 = (Button) findViewById(R.id.button_5);
        Button button4 = (Button) findViewById(R.id.button_4);



        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               Intent intent = new Intent(Main.this,Balance.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Main.this,widmark.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Main.this,Alcohol.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Main.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Timer timer = new Timer();
        //3.创建TimerTask对象
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Main.this,widmark.class);
                startActivity(intent);
                finish();
            }
        };
        //2.使用timer.schedule（）方法调用timerTask，定时3秒后执行run
        timer.schedule(timerTask, 2000);


    }
    private MenuDrawer mDrawer;


    }





