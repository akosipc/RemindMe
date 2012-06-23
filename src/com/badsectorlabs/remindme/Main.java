package com.badsectorlabs.remindme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.widget.EditText;

public class Main extends Activity {
	public final static String TITLE = "Task Title";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onDestory(){
    	super.onDestroy();
    	Debug.stopMethodTracing();
    }
    public void addTask(View view){
    	Intent intent = new Intent(this, TaskDetailsActivity.class);
    	EditText taskTitle = (EditText) findViewById(R.id.title);
    	intent.putExtra(TITLE, taskTitle.getText().toString());
    	startActivity(intent);
    }
}