package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Ok extends Activity{
	
	private String contraseña;
	private String pass="123abc";
	
	public Ok() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ok);
		
		contraseña = getIntent().getExtras().getString("pass");
		
		Intent i = getIntent();
		
		if(contraseña.equals(this.pass)){
			setResult(RESULT_OK, i);
		}else{
			setResult(RESULT_CANCELED, i);
		}
		finish();
	}

}