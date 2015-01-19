package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button bEntrar;
	private EditText passIntroducido;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bEntrar = (Button)findViewById(R.id.btnEntrar);
		bEntrar.setOnClickListener(this);
		
		passIntroducido = (EditText)findViewById(R.id.pass);
		passIntroducido.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.btnEntrar){
			Intent i = new Intent(this, Ok.class);
			i.putExtra("pass", passIntroducido.getText().toString());
			startActivityForResult(i,1);
		}
		
	}
	
	public void onActivityResult(int id, int result, Intent intent){
		TextView tv = (TextView)findViewById(R.id.tvMensaje);
		if(result == RESULT_OK){
			
			tv.setText("Hokeyyy");
		}else{
			tv.setText("Veru mallll");
		}
		
	}

}
