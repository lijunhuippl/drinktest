package com.example.lijunhui.drinktest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import net.simonvt.menudrawer.MenuDrawer;

public class widmark extends AppCompatActivity {
    EditText beer_count;
    EditText soju_count;
    EditText makguli_count;
    EditText etc1;
    EditText etc1_count;
    EditText etc2;
    EditText etc2_count;
    EditText weight;
    EditText time;
    TextView beer_ml;
    TextView soju_ml;
    TextView makguli_ml;
    RadioGroup gender;
    Button cal;
    double intEtc1;
    double intEtc2;
    int intEtc1_count;
    int intEtc2_count;
    int intWeight;
    int intTime;
    double beer = 0.04;
    double soju = 0.18;
    double makguli = 0.07;
    double gender_doub=0.7;
    double beer_vol;
    double soju_vol;
    double makguli_vol;
    double etc1_vol;
    double etc2_vol;
    private MenuDrawer mDrawer;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alcohol_layout);
        mDrawer = MenuDrawer.attach(this);
        mDrawer.setContentView(R.layout.alcohol_layout);
        mDrawer.setMenuView(R.layout.select);

        Button button3 = (Button) findViewById(R.id.button_3);
        Button button5 = (Button) findViewById(R.id.button_5);
        Button button4 = (Button) findViewById(R.id.button_4);


        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(widmark.this,Balance.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(widmark.this,Alcohol.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(widmark.this,MainActivity.class);
                startActivity(intent);
            }
        });

        beer_count = (EditText)findViewById(R.id.beer_count);
        beer_ml = (TextView)findViewById(R.id.beer_ml);
        beer_count.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable paramAnonymousEditable){
                beer_ml.setText(beer_count.getText().toString());
                int intBeer_ml = Integer.parseInt(beer_count.getText().toString());
                beer_vol = intBeer_ml * beer;
            }
            public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
            public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });

        soju_count = (EditText)findViewById(R.id.soju_count);
        soju_ml = (TextView)findViewById(R.id.soju_ml);
        soju_count.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                int intSoju_ml = Integer.parseInt(soju_count.getText().toString());
                int resultSoju_ml = intSoju_ml * 40;
                String str1 = String.valueOf(resultSoju_ml);
                soju_ml.setText(str1);
                soju_vol = resultSoju_ml * soju;
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        makguli_count = (EditText)findViewById(R.id.makguli_count);
        makguli_ml = (TextView)findViewById(R.id.makguli_ml);
        makguli_count.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                int intMakguli_ml = Integer.parseInt(makguli_count.getText().toString());
                int resultMakguli_ml = intMakguli_ml * 200;
                String str2 = String.valueOf(resultMakguli_ml);
                makguli_ml.setText(str2);
                makguli_vol = resultMakguli_ml * makguli;
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        etc1 = (EditText)findViewById(R.id.etc1);
        etc1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                intEtc1 = Integer.parseInt(etc1.getText().toString())/100;
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        etc1_count = (EditText)findViewById(R.id.etc1_count);
        etc1_count.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                intEtc1_count = Integer.parseInt(etc1_count.getText().toString());
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        etc1_vol = intEtc1/100 * intEtc1_count;

        etc2 = (EditText)findViewById(R.id.etc2);
        etc2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                intEtc2 = Integer.parseInt(etc2.getText().toString())/100;
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        etc2_count = (EditText)findViewById(R.id.etc2_count);
        etc1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                intEtc2_count = Integer.parseInt(etc2_count.getText().toString());
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        etc2_vol = intEtc2 * intEtc2_count;

        weight = (EditText)findViewById(R.id.weight);
        weight.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                intWeight = Integer.parseInt(weight.getText().toString());
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        time = (EditText)findViewById(R.id.time);
        time.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                intTime = Integer.parseInt(time.getText().toString());
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        /*gender = (RadioGroup)findViewById(R.id.gender);
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_btn = (RadioButton)findViewById(checkedId);
                switch (checkedId){
                    case R.id.male:
                        gender_doub = 0.7;
                        break;
                    case R.id.female:
                        gender_doub = 0.6;
                        break;
                }
            }
        });*/

        cal = (Button)findViewById(R.id.cal);
        cal.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                double alcohol_vol1 = beer_vol+soju_vol+makguli_vol+etc1_vol+etc2_vol;
                double alcohol_vol2 = alcohol_vol1*0.7894;
                double human = intWeight * gender_doub;
                double result = alcohol_vol2/human;
                double result_time = intTime*0.015;
                double blood = result-result_time;
                double fin = blood-1;
                Toast.makeText(widmark.this,"결과:"+fin+"%",Toast.LENGTH_SHORT).show();
            }
        });


    }
}