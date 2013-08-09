package com.example.mobilewhenisgood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	public static String TAG = "WhenIsGood";
	private UserInfo dummy; //Debug purposes only

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView create = (TextView) findViewById(R.id.create_event);
		TextView browse = (TextView) findViewById(R.id.browse_events);
		create.setOnClickListener(this);
		browse.setOnClickListener(this);
		
		
		//Create dummy user information for use in app.
		dummy = new UserInfo();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i;
		switch(v.getId()){
		case R.id.create_event:
			i = new Intent(this, CreateEvents.class);
			startActivity(i);
			break;
		case R.id.browse_events:
			i = new Intent(this, BrowseEvents.class);
			startActivity(i);
			break;
		}
	}

}
