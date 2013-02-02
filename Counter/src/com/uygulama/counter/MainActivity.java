package com.uygulama.counter;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button button1;
	Button button2;
	TextView text1;

	private static String COUNTER = "COUNTER";
	int id = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button1 = (Button) findViewById(R.id.upbutton);
		button2 = (Button) findViewById(R.id.downbutton);
		text1 = (TextView) findViewById(R.id.text1);

		SharedPreferences prefGet = getSharedPreferences(COUNTER,
				Activity.MODE_PRIVATE);
		id = prefGet.getInt("sayi", 0); // Sayi degişkeni varsa getir yoksa 0
										// getir.

		text1.setText(id + "");

		OnClickListener myListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v.getId() == R.id.upbutton) {
					id++;
					text1.setText(id + "");
				} else if (v.getId() == R.id.downbutton) {
					id--;
					text1.setText(id + "");
				}
			}
		};

		button1.setOnClickListener(myListener);
		button2.setOnClickListener(myListener);

	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.d("onStop", "Stopped");
		super.onStop();
		SharedPreferences prefPut = getSharedPreferences(COUNTER,
				Activity.MODE_PRIVATE);
		
		Editor prefEditor=prefPut.edit();
		prefEditor.putInt("sayi", id);
		prefEditor.commit();
		    
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
