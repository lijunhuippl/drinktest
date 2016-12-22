package com.example.lijunhui.drinktest;


import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import net.simonvt.menudrawer.MenuDrawer;



public class Balance extends AppCompatActivity {

    private SensorManager sensorManager;
    private Vibrator vibrator;

    private static final String TAG = "TestSensorActivity";
    private static final int SENSOR_SHAKE1= 10;
    private static final int SENSOR_SHAKE2= 9;
    private static final int SENSOR_SHAKE3= 8;
    private static final int SENSOR_SHAKE4= 7;
    private ImageView image;
    private  Toast mToast;
    private MenuDrawer mDrawer;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balance);
        mDrawer = MenuDrawer.attach(this);
        mDrawer.setContentView(R.layout.balance);
        mDrawer.setMenuView(R.layout.select);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        image = (ImageView) this.findViewById(R.id.bg);
        sound.init(this);




        Button button2 = (Button) findViewById(R.id.button_2);
        Button button5 = (Button) findViewById(R.id.button_5);
        Button button4 = (Button) findViewById(R.id.button_4);

        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Balance.this,widmark.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Balance.this,Alcohol.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Balance.this,MainActivity.class);
                startActivity(intent);
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sensorManager != null) {// 注册监听器
            sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
            // 第一个参数是Listener，第二个参数是所得传感器类型，第三个参数值获取传感器信息的频率
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (sensorManager != null) {// 取消监听器
            sensorManager.unregisterListener(sensorEventListener);
        }
    }


    /**
     * 重力感应监听
     */
    private SensorEventListener sensorEventListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            // 传感器信息改变时执行该方法
            float[] values = event.values;
            float x = values[0]; // x轴方向的重力加速度，向右为正
            float y = values[1]; // y轴方向的重力加速度，向前为正
            float z = values[2]; // z轴方向的重力加速度，向上为正
            Log.i(TAG, "x축중력가속도" + x +  "；y축중력가속도" + y +  "；z축중력가속도" + z);
            // 一般在这三个方向的重力加速度达到40就达到了摇晃手机的状态。
            int medumValue = 4;// 如果不敏感请自行调低该数值,低于10的话就不行了,因为z轴上的加速度本身就已经达到10了
            if (Math.abs(x) < -1 ) {
                vibrator.vibrate(200);
                Message msg = new Message();
                msg.what = SENSOR_SHAKE1;
                handler.sendMessage(msg);

               // image.setBackgroundResource(R.drawable.left);
            }
            else if (Math.abs(x) > 1   ) {
                vibrator.vibrate(200);
                Message msg = new Message();
                msg.what = SENSOR_SHAKE2;
                handler.sendMessage(msg);
               // image.setBackgroundResource(R.drawable.right);

            }
             else if ( Math.abs(y) < -1 ) {
                vibrator.vibrate(200);
                Message msg = new Message();
                msg.what = SENSOR_SHAKE3;
                handler.sendMessage(msg);
                //image.setBackgroundResource(R.drawable.frond);
            }
            else if ( Math.abs(y) > 1  ) {
                vibrator.vibrate(200);
                Message msg = new Message();
                msg.what = SENSOR_SHAKE4;
                handler.sendMessage(msg);

                //image.setBackgroundResource(R.drawable.behand);

            }
        }


        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    public class MyUtil {
        private  Toast mToast;
        public  void showToast(Context context, int resId, int duration){
            showToast(context, context.getString(resId), duration);
        }
        public  void showToast(Context context, String msg, int duration) {
            if (mToast == null) {
                mToast = Toast.makeText(context, msg, duration);
            } else {
                mToast.setText(msg);
            }
            mToast.show();
        }
    }

    /**
     * 动作执行
     */
    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case SENSOR_SHAKE1:
                    mToast.makeText(Balance.this, "좌！", mToast.LENGTH_SHORT).show();
                    Log.i(TAG, "좌！");
                    //image.setBackgroundResource(R.drawable.left);
                    sound.play(1);


                    break;
                case SENSOR_SHAKE2:
                    mToast.makeText(Balance.this, "you are drunk", mToast.LENGTH_SHORT).show();
                    Log.i(TAG, "우！");
                    sound.play(1);
                    break;
                case SENSOR_SHAKE3:
                    mToast.makeText(Balance.this, "앞！", mToast.LENGTH_SHORT).show();
                    Log.i(TAG, "앞！");
                    break;
                case SENSOR_SHAKE4:
                    mToast.makeText(Balance.this, "you are drunk！", mToast.LENGTH_SHORT).show();
                    Log.i(TAG, "뒤！");
                    sound.play(1);
                    //image.setBackgroundResource(R.drawable.behand);

                    break;
            }
        }

    };
}
