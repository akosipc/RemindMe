package com.badsectorlabs.remindme.helpers;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.badsectorlabs.remindme.models.Task;

public class DataHandler extends SQLiteOpenHelper{
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "RemindMe";
	private static final String TABLE_TASK = "tasks";
	private static final String KEY_ID = "id";
	private static final String KEY_TITLE = "title";
	private static final String KEY_DETAILS = "details";
	private static final String KEY_DEADLINE = "deadline";
	private static final String KEY_PRIORITY = "priority";
	
	public DataHandler(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public DataHandler(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TASK_TABLE = "CREATE TABLE " + TABLE_TASK + "(" 
			+ KEY_ID + 	" INTEGER PRIMARY KEY," 
			+ KEY_TITLE + " TEXT,"
			+ KEY_DETAILS + " TEXT,"
			+ KEY_DEADLINE + " TEXT,"
			+ KEY_PRIORITY + " TEXT" + ")";
		db.execSQL(CREATE_TASK_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_TASK);
		onCreate(db);
	}
	
	public void addTask(Task t){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_TITLE, t.getTitle());
		values.put(KEY_DETAILS, t.getDetails());
		values.put(KEY_DEADLINE, t.getDeadline().toString());
		values.put(KEY_PRIORITY, t.getPriority());
		
		db.insert(TABLE_TASK, null, values);
		db.close();
	}
	/*public Task getTask(int id){
		
	}
	public List<Task> getAllTask() {
		
	}
	public int getTask(){
		
	}
	public int updateTask(Task t){
		
	}
	public void deleteTask(Task t){
		
	}*/
}
