package com.example.voting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class Count extends Activity {
	String temp;
	String[] entryarray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_count);
		TextView tv1=(TextView) findViewById(R.id.bjp);
		TextView tv2=(TextView) findViewById(R.id.congress);
		TextView tv3=(TextView) findViewById(R.id.mns);
		TextView tv4=(TextView) findViewById(R.id.shivsena);
		
		try{
		FileInputStream in=openFileInput("vote.txt");
		InputStreamReader isr=new InputStreamReader(in);
		char[] inputBuffer=new char[50];
		int charRead;
		while((charRead=isr.read(inputBuffer))>0){
			String readString=String.copyValueOf(inputBuffer,0,charRead);
			temp+=readString;
			inputBuffer=new char[50];
		}if(temp!=null)
    	{
    		entryarray = temp.split(",");
    	}else {
			Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_LONG).show();
			
		}
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		tv1.setText(entryarray[0]);
		tv2.setText(entryarray[1]);
		tv3.setText(entryarray[2]);
		tv4.setText(entryarray[3]);
		/*for(int i=0;i<entryarray.length;i++){
			if(i==0){
				tv1.setText(entryarray[0]);
			}else{
				if(i==1){
			    tv2.setText(entryarray[i]);	
				}else{
					if(i==2){
						tv3.setText(entryarray[i]);
					}else{
						if(i==3){
							tv4.setText(entryarray[i]);
						}
					}
				}
			}
			
		}*/
	}

	

}
