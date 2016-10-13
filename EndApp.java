package com.example.voting;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EndApp extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end_app);
		Button bt1=(Button) findViewById(R.id.home);
		Button bt2=(Button) findViewById(R.id.exit);
		Button bt3=(Button) findViewById(R.id.admin);
		
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i1=new Intent(getBaseContext(),MainActivity.class);
				startActivity(i1);
				finish();
				
			}
		});
		
        bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i4=new Intent(getBaseContext(),MainActivity.class); 
				i4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i4.putExtra("exit", true);
				startActivity(i4);
				
				
				
			}
		});
        
        bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i3=new Intent(getBaseContext(),AdminP.class);
				startActivity(i3);
				finish();
				
			}
		});
	}

	

}
