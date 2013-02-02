package com.uygulama.layoutdeneme;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button send;
	Button release;
	Button uc;
	TextView text1;
	Toast tost;
	View layout;
	View ornek;
	int year, month, day, month_day;
	int hour,minute;

	static final int DATE_DIALOG_ID = 0;
	private OnClickListener myListener;
	LayoutInflater inflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_main);
		//setContentView(R.layout.ornek_ornek);

		send = (Button) findViewById(R.id.button1);
		release = (Button) findViewById(R.id.button2);
		text1 = (TextView) findViewById(R.id.text2);
		uc= (Button) findViewById(R.id.button3);

		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				text1.setText("Cezaevine gönderildi");
				// TostGoster("Cezaevine gönderildi");
				// dialoggoster();
				showDialog(DATE_DIALOG_ID);

			}
		});

		release.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// text1.setText("Cezaevinden cıkarıldı");
				// TostGoster("Cezaevinden cikarildi");
				dialoggoster();
			}
		});
		
		
		uc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void TostGoster(String a) {
		tost = Toast.makeText(getApplicationContext(), a, Toast.LENGTH_LONG);
		tost.show();

	}

	public void dialoggoster() {
		LayoutInflater inflater = getLayoutInflater();
		final View checkboxLayout = inflater
				.inflate(R.layout.ornek_ornek, null);
		CheckBox cb = (CheckBox) checkboxLayout.findViewById(R.id.checkBox);

		AlertDialog.Builder builder = new AlertDialog.Builder(this)
				.setTitle("Kullanım Sartları")
				.setView(checkboxLayout)
				.setPositiveButton("Kabul ediyorum",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						});

		AlertDialog dialog = builder.create();
		dialog.show();

	}

	@Override
	protected Dialog onCreateDialog(int id){
		switch(id){
		case DATE_DIALOG_ID:
			
		 final Calendar c=Calendar.getInstance();
		 year=c.get(Calendar.YEAR);
		 month=c.get(Calendar.MONTH);
		 day=c.get(Calendar.DAY_OF_MONTH);
			
		return new DatePickerDialog(this, datePickerListener, year, month, month_day);
			//return new TimePicker(this, timePickerListener, hour, minute);
		} 
		return null;
}
	
	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int selectedYear, int selectedMonth,
				int selectedDay) {
			// TODO Auto-generated method stub
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;
			
		}
	}; 
	
private TimePicker.OnTimeChangedListener timePickerListener= new TimePicker.OnTimeChangedListener() {
	
	@Override
	public void onTimeChanged(TimePicker view, int selectedhour, int selectedminute) {
		// TODO Auto-generated method stub
		hour=selectedhour;
		minute=selectedminute;
		
	}
};
	


}
