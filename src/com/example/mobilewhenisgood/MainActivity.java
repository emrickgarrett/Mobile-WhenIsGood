package com.example.mobilewhenisgood;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	public static String TAG = "WhenIsGood";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView create = (TextView) findViewById(R.id.create_event);
		TextView browse = (TextView) findViewById(R.id.browse_events);
		create.setOnClickListener(this);
		browse.setOnClickListener(this);
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
		switch(v.getId()){
		case R.id.create_event:
			System.out.println("Event created");
			break;
		case R.id.browse_events:
			System.out.println("Browse Events");
			break;
		}
	}

}
