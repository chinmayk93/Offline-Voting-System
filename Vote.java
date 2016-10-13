package com.example.voting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Vote extends Activity {

	int position = 0;
	String s,write;
	String[] entryarray;
	int number;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vote);
		final ListView lv=(ListView) findViewById(R.id.listView1);
		String [] stars = getResources().getStringArray(R.array.items);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_single_choice, stars);
		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lv.getItemIdAtPosition(position);
		lv.setAdapter(adapter);
		

			
		
		 

		Button bt5=(Button) findViewById(R.id.vote);
		
		try{
			FileInputStream f1=openFileInput("vote.txt");
        	InputStreamReader inputReader=new InputStreamReader(f1);
        	char[] inputbuffer=new char[50];
        	int charRead;
        	
        	while((charRead=inputReader.read(inputbuffer))>0){
        		String readstring=String.copyValueOf(inputbuffer,0,charRead);
        		s+=readstring;
        		inputbuffer=new char[50];
             }	
        	if(s!=null){
        		entryarray=s.split(",");
        	}
        		else{
        			Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_LONG).show();
        		}
        	
        	
		}catch(IOException e){
			e.printStackTrace();
		}
		
		bt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				for(int j=0;j<entryarray.length;j++){
					if(position==j){
						entryarray[j]="1";
					}
					
				}
				for(int i=0;i<entryarray.length;i++){
					write+=entryarray[i]+",";
					
				}
				
				try{
				BufferedWriter bufferwriter=new BufferedWriter(new OutputStreamWriter(openFileOutput("vote.txt",MODE_PRIVATE)));
				bufferwriter.write(write);
				bufferwriter.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				Intent in=new Intent(getBaseContext(),EndApp.class);
				startActivity(in);
			}
		});
		
		
	}
  
	


	

}
