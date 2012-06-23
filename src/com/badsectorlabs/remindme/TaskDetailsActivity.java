package com.badsectorlabs.remindme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TaskDetailsActivity extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		String title = intent.getStringExtra(Main.TITLE);
		
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(title);
		setContentView(textView);
	}
}
