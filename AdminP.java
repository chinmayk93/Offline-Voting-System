package com.example.voting;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminP extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_p);
		Button addlogin=(Button) findViewById(R.id.addlogin);
		final EditText login=(EditText) findViewById(R.id.admin);
		final EditText pass=(EditText) findViewById(R.id.apassword);
		
		final String abc=login.getText().toString();
		final String xyz=pass.getText().toString();
		
		addlogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
					Intent h=new Intent(getBaseContext(),Count.class);
					startActivity(h);
					
				}
				
				
			
		});
	}

	

}
