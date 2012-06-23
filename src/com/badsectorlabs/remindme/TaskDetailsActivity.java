package com.badsectorlabs.remindme;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

public class TaskDetailsActivity extends Activity{
	public DisplayMetrics display = new DisplayMetrics();
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.details);
		getWindowManager().getDefaultDisplay().getMetrics(display);
		
		Intent intent = getIntent();
		String title = intent.getStringExtra(Main.TITLE);
		
		TextView titleName = (TextView) findViewById(R.id.titlename);
		titleName.setText(title);
		
		Spinner spinner = (Spinner) findViewById(R.id.priority);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.priority, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		DatePicker dp = (DatePicker) findViewById(R.id.datePicker);
		final Calendar c = Calendar.getInstance();
		dp.init(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), null);
	}
	
	public void onDestroy(){
		super.onDestroy();
		Debug.stopMethodTracing();
	}
	public void onPause(){
		super.onPause();
	}
	public void onResume() {
		super.onResume();
	}
	public void addDetails(View view){
		
	}
}