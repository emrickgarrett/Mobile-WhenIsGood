package com.example.mobilewhenisgood;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class BrowseEvents extends Activity {

	public UserInfo dummy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browse_events);
		
		Bundle b = getIntent().getExtras();
		dummy = (UserInfo) b.getSerializable("userinfo");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.browse_events, menu);
		return true;
	}

}
