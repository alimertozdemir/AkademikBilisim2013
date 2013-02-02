package com.uygulama.listviewdeneme;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity{

	String[] arabalar= {"Subaru","Mercedes","Bmw","Porsche"};
	TextView text1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ArrayAdapter<String> myAdapter= new ArrayAdapter <String>(this,R.layout.listitem,R.id.textitem,arabalar);
		setListAdapter(myAdapter);
		text1=(TextView)findViewById(R.id.listtext);
	}

	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String araba= arabalar[position];
		text1.setText(araba);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true; 
	}

}
