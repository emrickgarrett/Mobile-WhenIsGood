package com.example.mobilewhenisgood;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class UserResponseActivity extends Activity {

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
		setContentView(R.layout.activity_user_response);
		
		Bundle b = getIntent().getExtras(); //This will be the event I will respond to.
		
		b.getInt("startyear");
		b.getInt("startmonth");
		b.getInt("startday");
		
		b.getInt("endyear");
		b.getInt("endmonth");
		b.getInt("endday");
		
		b.getString("eventname");
		
		populateList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_response, menu);
		return true;
	}
	
	public void populateList(){
		
	}

}
