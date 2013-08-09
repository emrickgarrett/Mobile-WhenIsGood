package com.example.mobilewhenisgood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

/**
 * 
 * @author Garrett
 * Class to upload data to the server, returns a result to CreateEvents.activity
 */
public class UploadEventActivity extends Activity {

	double startHour;
	double endHour;
	
	int startYear;
	int startMonth;
	int startDay;
	
	int endYear;
	int endMonth;
	int endDay;
	
	String eventName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upload_event);
		
		Bundle b = getIntent().getExtras();
		
		stripBundle(b);
		
		//Sends a result back to my activity, return false if it was unsuccessful please.
		sendResult(sendData());
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.upload_event, menu);
		return true;
	}

	
	/**
	 * Assigns values to variables mentioned above.
	 */
	public void stripBundle(Bundle b){
		startHour = b.getDouble("starthour");
		endHour = b.getDouble("endhour");
		
		startYear = b.getInt("startyear");
		startMonth = b.getInt("startmonth");
		startDay = b.getInt("startday");
		
		endYear = b.getInt("endyear");
		endMonth = b.getInt("endmonth");
		endDay = b.getInt("endday");
		
		eventName = b.getString("eventname");
	}
	
	public void sendResult(boolean b){
		Intent returnIntent = new Intent();
		
		if(b){
			setResult(RESULT_OK, returnIntent);
		}else{
			setResult(RESULT_CANCELED, returnIntent);
		}
		finish();
		
	}
	
	public boolean sendData(){
		return false;
	}
}
