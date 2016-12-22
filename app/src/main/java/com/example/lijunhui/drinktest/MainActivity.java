package com.example.lijunhui.drinktest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

import net.simonvt.menudrawer.MenuDrawer;

public class MainActivity extends Activity {
	
	Button mOutgoingCallButton; // 발신전화버튼
	Button mIncomingCallButton; // 수신전화버튼
	Button ContactButton;
	private MenuDrawer mDrawer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phone); // 레이아웃 뷰
		mDrawer = MenuDrawer.attach(this);
		mDrawer.setContentView(R.layout.phone);
		mDrawer.setMenuView(R.layout.select);
		
		mOutgoingCallButton = (Button) findViewById(R.id.outgoingCallButton); //발신버튼
		mIncomingCallButton = (Button) findViewById(R.id.incomingCallButton); //발신버튼
		
		mOutgoingCallButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				showOutgoingCallList();
				
			}
		});
		
		mIncomingCallButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				showIncomingCallList();
				
			}
		});
		Button button2 = (Button) findViewById(R.id.button_2);
		Button button5 = (Button) findViewById(R.id.button_5);
		Button button3 = (Button) findViewById(R.id.button_3);

		button2.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,widmark.class);
				startActivity(intent);
			}
		});
		button5.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,Alcohol.class);
				startActivity(intent);
			}
		});
		button3.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,Balance.class);
				startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) { //옵션메뉴만들기
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	private void showOutgoingCallList(){ //발신차단리스트보여주기
		
		Intent intent = new Intent(getApplicationContext(), com.example.lijunhui.drinktest.OutgoingCallListActivity.class);
		startActivity(intent);
		
	}
	
	private void showIncomingCallList(){ //수신차단리스트보여주기

        Intent intent = new Intent(getApplicationContext(), com.example.lijunhui.drinktest.IncomingCallListActivity.class);
        startActivity(intent);
		
	}

}
