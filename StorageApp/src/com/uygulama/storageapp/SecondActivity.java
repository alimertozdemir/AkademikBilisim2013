package com.uygulama.storageapp;

import java.io.BufferedReader;
import java.io.FileReader;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

	TextView text2;
	private final String Fname="/sdcard/testwrite.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		text2 = (TextView) findViewById(R.id.text2);

		BufferedReader buf = null;
		String myE = "";
		try {
			buf = new BufferedReader(new FileReader(Fname));
			String line = "";
			while ((line = buf.readLine()) != null) {
				Log.e("deneme", "test");
				myE += line;
			}
			text2.setText(myE);
			buf.close();
		} catch (Exception e) {
			e.printStackTrace(); // Hatayı loga dusurmesi icin
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_second, menu);
		return true;
	}

}
