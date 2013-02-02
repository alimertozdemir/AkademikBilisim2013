package com.uygulama.storageapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private final String Fname="/sdcard/testwrite.txt";
	private String str;
	private FileWriter fWriter;
	Button button1;
	Button button2;
	TextView text1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		text1=(TextView)findViewById(R.id.text1);
		button1=(Button)findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		
		
		OnClickListener myListener= new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId()==R.id.button1){
					try{
						fWriter=new FileWriter(Fname);
						fWriter.write(text1.getText().toString());
						fWriter.flush();
						fWriter.close();
						String tost="Dosyaya başarıyla yazıldı";
						Toast.makeText(getApplicationContext(), tost, Toast.LENGTH_LONG).show();
					}
					catch (Exception e){
						System.out.println("Exception: "+e);
						String tost= "Dosyaya yazma başarısız";
						Toast.makeText(getApplicationContext(), tost, Toast.LENGTH_LONG).show();
					}
					
				} 
				else if(v.getId()==R.id.button2){
				Intent intent= new Intent(getApplicationContext(),com.uygulama.storageapp.SecondActivity.class);
				startActivity(intent);
				}
				
			}
		};
		
		button1.setOnClickListener(myListener);
		button2.setOnClickListener(myListener);
		
		
		
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
