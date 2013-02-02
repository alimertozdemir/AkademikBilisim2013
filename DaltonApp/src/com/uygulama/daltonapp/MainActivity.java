package com.uygulama.daltonapp;




import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		OnClickListener myListener= new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		};
		
		button1=(Button)findViewById(R.id.button1);
		button1.setOnClickListener(myListener);
		registerForContextMenu(button1); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	
	switch(item.getItemId()){
	case R.id.prison:
		Toast.makeText(MainActivity.this, "Send to Prison", Toast.LENGTH_LONG).show();
		break;
	case R.id.release:
		Toast.makeText(MainActivity.this, "Has been released", Toast.LENGTH_LONG).show();
		break;
		
	}
	return super.onOptionsItemSelected(item);
}
	
@Override
public void onCreateContextMenu(ContextMenu menu, View v,
		ContextMenuInfo menuInfo) {
	// TODO Auto-generated method stub
	super.onCreateContextMenu(menu, v, menuInfo);
	getMenuInflater().inflate(R.menu.activity_main, menu);
}

@Override
public boolean onContextItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	switch(item.getItemId()){
	case R.id.prison:
		Toast.makeText(MainActivity.this, "Send to Prison yet", Toast.LENGTH_LONG).show();
		break;
	case R.id.release:
		Toast.makeText(MainActivity.this, "Has been released yet", Toast.LENGTH_LONG).show();
		break;
		
	}
	return super.onContextItemSelected(item);
}

}
