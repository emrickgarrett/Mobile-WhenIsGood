package com.example.mobilewhenisgood;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class CreateEvents extends Activity implements OnClickListener {

	public UserInfo dummy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_events);
		
		Bundle b = getIntent().getExtras();
		dummy = (UserInfo) b.getSerializable("userinfo");
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
		View area = findViewById(R.id.create_content_area);
		
		switch(v.getId()){
		case R.id.date_field:
			System.out.println("date field");
			break;
		case R.id.time_field:
			System.out.println("Time Field");
			break;
		case R.id.end_date_field:
			System.out.println("End Date Field");
			break;
		case R.id.create_event_button:
			System.out.println("Event Created!");
			break;
		}
		
	}

}
