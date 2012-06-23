package com.badsectorlabs.remindme;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.badsectorlabs.remindme.helpers.DataHandler;
import com.badsectorlabs.remindme.models.Task;

public class TaskDetailsActivity extends Activity{
	public DisplayMetrics display = new DisplayMetrics();
	private TextView titleName;
	private Spinner spinner;
	private DatePicker dp;
	private EditText details;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.details);
		getWindowManager().getDefaultDisplay().getMetrics(display);
		
		Intent intent = getIntent();
		String title = intent.getStringExtra(Main.TITLE);
		
		details = (EditText) findViewById(R.id.body);
		
		titleName = (TextView) findViewById(R.id.titlename);
		titleName.setText(title);
		
		spinner = (Spinner) findViewById(R.id.priority);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.priority, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		dp = (DatePicker) findViewById(R.id.datePicker);
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
		DataHandler db = new DataHandler(this);
		SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
		Date date = null;
		try {
			date = s.parse(dp.getMonth()+"-"+dp.getDayOfMonth()+"-"+dp.getYear());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		db.addTask(new Task(titleName.getText().toString(), details.getText().toString(), date, spinner.getSelectedItem().toString()));
		Log.d("Saved: ", titleName.getText().toString());
	}
}