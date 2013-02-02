package com.uygulama.intentimplicit;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	Button button1;
	Button button2;
	Button button3;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		button1=(Button)findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		button3=(Button)findViewById(R.id.button3);
		
		OnClickListener myListener= new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId()==R.id.button1){
				Intent dial = new Intent(Intent.ACTION_CALL,Uri.parse("tel:0554 829 70 67"));
                startActivity(dial);  
                }
				else if(v.getId()==R.id.button2){
					Intent browse = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.alimertozdemir.com"));
	                startActivity(browse);  
	                }
				
				else if(v.getId()==R.id.button3){
					Intent search = new Intent(Intent.ACTION_WEB_SEARCH );
					 search.putExtra(SearchManager.QUERY, "alimertozdemir");
					 startActivity(search);
	                }
			}
		};
		
		
		button1.setOnClickListener(myListener);
		button2.setOnClickListener(myListener);
		button3.setOnClickListener(myListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
