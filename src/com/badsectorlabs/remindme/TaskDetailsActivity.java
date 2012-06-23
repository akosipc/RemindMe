package com.badsectorlabs.remindme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.widget.TextView;

public class TaskDetailsActivity extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		TextView titleName = (TextView) findViewById(R.id.titlename);
		Intent intent = getIntent();
		String title = intent.getStringExtra(Main.TITLE);
		titleName.setText(title);
	}
	
	public void onDestroy(){
		super.onDestroy();
		Debug.stopMethodTracing();
	}
	public void addDetails(View view){
		
	}
}
