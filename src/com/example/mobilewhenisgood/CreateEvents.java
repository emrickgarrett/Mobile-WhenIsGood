package com.example.mobilewhenisgood;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class CreateEvents extends Activity implements OnClickListener {

	public UserInfo dummy;
	
	boolean isStartDate = false;
	boolean isStartTime = false;
	
	//For Default dates and times!
	private int defaultYear;
	private int defaultMonth;
	private int defaultDay;
	
	private int defaultHour;
	private int defaultMinute;
	
	private int startYear;
	private int startMonth;
	private int startDay;
	private int endYear;
	private int endMonth;
	private int endDay;
	
	private double startHour;
	private double endHour;
	
	private final int START_DATE_DIALOG_ID = 1;
	private final int END_DATE_DIALOG_ID = 2;
	private final int START_TIME_DIALOG_ID = 3;
	private final int END_TIME_DIALOG_ID = 4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_events);
		
		Bundle b = getIntent().getExtras();
		dummy = (UserInfo) b.getSerializable("userinfo");
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_events, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case R.id.date_field:
			System.out.println("date field");
			isStartDate = true;
			showDialog(START_DATE_DIALOG_ID);
			break;
		case R.id.time_field:
			isStartTime = true;
			showDialog(START_TIME_DIALOG_ID);
			System.out.println("Time Field");
			break;
		case R.id.end_date_field:
			isStartDate = false;
			System.out.println("End Date Field");
			showDialog(END_DATE_DIALOG_ID);
			break;
		case R.id.end_time_field:
			isStartTime = false;
			showDialog(END_TIME_DIALOG_ID);
			System.out.println("End Time Field");
			break;
		case R.id.create_event_button:
			System.out.println("Event Created!");
			createEvent();
			break;
		}
		
	}
	
	public void init(){
		final Calendar c = Calendar.getInstance();
		defaultYear = c.get(Calendar.YEAR);
		defaultMonth = c.get(Calendar.MONTH);
		defaultDay = c.get(Calendar.DAY_OF_MONTH);
		
		defaultHour = 8;
		defaultMinute = 0;
		
	}
	
	public void createEvent(){
		Toast.makeText(this, "Creating Event...", Toast.LENGTH_SHORT).show();
		Intent i = new Intent(this, UploadEventActivity.class);
		Bundle b = new Bundle();
		if(!addDataToBundle(b)){
			Toast.makeText(this, "Upload Failed, make sure you entered all fields.", Toast.LENGTH_SHORT).show();
			return;
		}
		i.putExtras(b);
		startActivityForResult(i, 1);
	}
	
	public boolean addDataToBundle(Bundle b){
		
		if(startYear == 0) return false;
		if(startMonth == 0) return false;
		if(startDay == 0) return false;
		if(endYear == 0) return false;
		if(endMonth == 0) return false;
		if(endDay == 0) return false;
		if(startHour == 0) return false;
		if(endHour == 0) return false;
		
		EditText nameField = (EditText)findViewById(R.id.name_field);
		
		if(nameField.getText().toString().equals("")) return false;
		
		b.putString("eventname", nameField.getText().toString());
		b.putInt("startyear", startYear);
		b.putInt("endyear", endYear);
		b.putInt("startday", startDay);
		b.putInt("endDay", endDay);
		b.putInt("startMonth", startMonth);
		b.putInt("endMonth", endMonth);
		b.putDouble("starthour", startHour);
		b.putDouble("endHour", endHour);
		
		return true;
		
	}
	
	public void resetFields(){
		startDay = 0;
		endDay = 0;
		startMonth = 0;
		endMonth = 0;
		startYear = 0;
		endYear = 0;
		
		startHour = 0;
		endHour = 0;
		
		EditText field = (EditText) findViewById(R.id.name_field);
		field.setText("");
		field.setHint("Insert Name Here");
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == 1) {

		     if(resultCode == RESULT_OK){

		      Toast.makeText(this, "Upload was successful", Toast.LENGTH_SHORT).show();
		      finish();

		     }

     	if (resultCode == RESULT_CANCELED) {

	    	 Toast.makeText(this, "Upload Failed, try again", Toast.LENGTH_SHORT).show();
	    	 resetFields();

	     	}
		}
	}

	
	@Override
	protected Dialog onCreateDialog(int id) {
		
		DatePickerDialog d;
		TimePickerDialog t;
		
		switch (id) {
		case START_DATE_DIALOG_ID:
		   d =  new DatePickerDialog(this, datePickerListener, 
                         defaultYear, defaultMonth,defaultDay);
		   return d;
		case END_DATE_DIALOG_ID:
			d = new DatePickerDialog(this, datePickerListener,
					defaultYear, defaultMonth, defaultDay);
			return d;
		case START_TIME_DIALOG_ID:
			t =  new TimePickerDialog(this, timePickerListener, defaultHour, defaultMinute, false);
			
			return t;
		case END_TIME_DIALOG_ID:
			t =  new TimePickerDialog(this, timePickerListener, defaultHour, defaultMinute, false);
			
			return t;
		}
		return null;
	}
 
	private DatePickerDialog.OnDateSetListener datePickerListener 
                = new DatePickerDialog.OnDateSetListener() {
 
		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			
			
			int year,month,day;
			
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;
 
			if(isStartDate){
				startYear = year;
				startMonth = month;
				startDay = day;
				System.out.println("Start Date:");
			}else{
				System.out.println("End Date");
				endYear = year;
				endMonth = month;
				endDay = day;
			}
 
		}
	};
	
	private TimePickerDialog.OnTimeSetListener timePickerListener = 
            new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int selectedHour,
				int selectedMinute) {
			
			int hour, minute;
			
			hour = selectedHour;
			minute = selectedMinute;
			
			if(isStartTime){
				
				startHour = hour;
				
				if(minute > 0){
					startHour += .5;
				}
				
			}else{
				
				endHour = hour;
				
				if(minute > 0){
					endHour += .5;
				}
				
			}
 
		}

	};
	
}
