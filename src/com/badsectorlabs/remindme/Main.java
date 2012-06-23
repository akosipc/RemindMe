package com.badsectorlabs.remindme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
	public final static String TITLE = "Task Title";
	public final static String[] ITEMS = new String[] {
		"Pete", "More", "Love"
	};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ArrayAdapter<String> list = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, ITEMS);
        ListView lv = (ListView) findViewById(R.id.taskList);
        lv.setTextFilterEnabled(true);
        lv.setAdapter(list);
        lv.setOnItemClickListener(new OnItemClickListener(){
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        		getDetails(view);
        	}
        });
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
    public void getDetails(View view){
    	Log.d("Enter: ", "TaskDetails");
    }
}