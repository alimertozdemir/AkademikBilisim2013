package com.uygulama.activityapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity {
	
	Button send;
	Button release;
	Button call;
	final static int INTENT_CODE=1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		send=(Button) findViewById(R.id.button2);
		release=(Button) findViewById(R.id.button3); 
		call= (Button) findViewById(R.id.button4);
		
		OnClickListener myListener=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent intentcall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0554 829 70 67")); 
				Intent internet = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.alimertozdemir.com"));
                
				 
				Intent intent=new Intent(getApplicationContext(),com.uygulama.activityapp.FirstActivity.class);
				if(v.getId()==R.id.button2){
					intent.putExtra("cevap", "Hapse atıldı!");
				}
				else if(v.getId()==R.id.button3){
					intent.putExtra("cevap", "Hapisten cıkarildi!");	
				}
				else if(v.getId()==R.id.button4){
					//startActivity(intentcall);
					startActivity(internet);
				}
				
				setResult(RESULT_OK,intent);
				finish(); 
			}
		};
		
		send.setOnClickListener(myListener);
		release.setOnClickListener(myListener);
		call.setOnClickListener(myListener);
		
		String aldimseni= getIntent().getStringExtra("benial");
		Toast.makeText(this, aldimseni, Toast.LENGTH_LONG).show();
		
		 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_second, menu);
		return true;
	}

}
