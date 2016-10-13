package com.example.voting;

import java.io.BufferedReader;


import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	String s;
	String[] entryArray;
	String log="a,1111,0,b,2222,0,c,3333,0";
	String vote="0,0,0,0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1=(Button)findViewById(R.id.addlogin);
        Button bt2=(Button)findViewById(R.id.b2);
        final EditText login=(EditText)findViewById(R.id.editText1);
        final EditText adhar=(EditText)findViewById(R.id.editText2);
        
        try{
			BufferedWriter bufferwriter=new BufferedWriter(new OutputStreamWriter(openFileOutput("login.txt",MODE_PRIVATE)));
			bufferwriter.write(log);
			bufferwriter.flush();
			bufferwriter.close();
			}catch(IOException z){
				z.printStackTrace();
			}
        
        try{
			BufferedWriter bufferwriter=new BufferedWriter(new OutputStreamWriter(openFileOutput("vote.txt",MODE_PRIVATE)));
			bufferwriter.write(vote);
			bufferwriter.flush();
			bufferwriter.close();
			}catch(IOException x){
				x.printStackTrace();
			}
        
        
        try{
        	FileInputStream f1=openFileInput("login.txt");
        	InputStreamReader inputreader=new InputStreamReader(f1);
        	char[] inputbuffer=new char[50];
        	int charRead;
        	
        	while((charRead=inputreader.read(inputbuffer))>0){
        		String readstring=String.copyValueOf(inputbuffer,0,charRead);
        		s+=readstring;
        		inputbuffer=new char[50];
        		System.out.print("s is" +s);
        		Toast.makeText(getBaseContext(), "Read done", Toast.LENGTH_LONG).show();
        	
        	
        		
        	}
        	
        	if(s!=null)
        	{
        		entryArray = s.split(",");
        		
        	}else {
				Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_LONG).show();
				
			}
        	
        }catch (IOException e)
        {
        	e.printStackTrace();
        }
        
        bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				// TODO Auto-generated method stub
				Intent i=new Intent(getBaseContext(),AdminP.class);
				startActivity(i);
				finish();
			}
		});
        
        bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				// TODO Auto-generated method stub
				String et1=login.getText().toString();
				String et2=adhar.getText().toString();
				if(et1.equals("") || et2.equals("")){
					Toast.makeText(getBaseContext(), "Enter Login id And Adhar Card Number",Toast.LENGTH_LONG ).show();
					
				}else{
					for(int i = 0;i<entryArray.length;i=i+3)
					{
						if(et1.equals(entryArray[i]) && et2.equals(entryArray[i+1]))
						{
							if(entryArray[i+2].equals("0"))
							{   
								Intent in=new Intent(getBaseContext(),Vote.class);
								in.putExtra("login", et1);
								in.putExtra("adhar", et2);
								startActivity(in);
								finish();
								break;
							}
							else{
								Toast.makeText(getBaseContext(), "You are Already Voted", Toast.LENGTH_LONG);
								login.setText("");
								adhar.setText("");
								break;
							}
						}else{
							if(i==entryArray.length-3);
							Toast.makeText(getBaseContext(), "You are not valid user", Toast.LENGTH_LONG).show();
						}
					}
				}
	
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
