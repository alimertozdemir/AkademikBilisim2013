package com.uygulama.activityapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class FirstActivity extends Activity {

	Button decide;
	TextView decision;
	final static int INTENT_CODE=1;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		
		decide = (Button) findViewById(R.id.button1);
		decision= (TextView)findViewById(R.id.text1);
		
		OnClickListener myListener=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent= new Intent(getApplicationContext(),com.uygulama.activityapp.SecondActivity.class);
				intent.putExtra("benial", "Birinci aktiviteden selamlar!");
				startActivityForResult(intent, INTENT_CODE);
				
				/*Intent intentcall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0554 829 70 67"));
						startActivity(intent);   */
			}
		};
		
		decide.setOnClickListener(myListener);
			
		
		
		//String cevap= getIntent().getStringExtra("cevap");
		//decision.setText(cevap);
		
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode==INTENT_CODE){
			if(resultCode==RESULT_OK){
			String extra= data.getStringExtra("cevap");
			decision.setText(extra);
		}
		
		}
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_first, menu);
		return true;
	}

}
