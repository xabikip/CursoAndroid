package com.example.guardarpersonas;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuardarActivity extends Activity implements OnClickListener, OnFocusChangeListener {

	private EditText nombre, apellido, telf, desc;
	private Button btnGuardar, btnCancelar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guardar);
		
		nombre=(EditText)findViewById(R.id.nombreGuardar);
		apellido=(EditText)findViewById(R.id.apellidoGuardar);
		telf=(EditText)findViewById(R.id.telfGuardar);
		desc=(EditText)findViewById(R.id.descGuardar);
		btnGuardar=(Button)findViewById(R.id.guardar);
		btnCancelar=(Button)findViewById(R.id.cancelar);
		
		btnGuardar.setOnClickListener(this);
		btnCancelar.setOnClickListener(this);
		
		nombre.setOnFocusChangeListener(this);
		apellido.setOnFocusChangeListener(this);
		telf.setOnFocusChangeListener(this);
		desc.setOnFocusChangeListener(this);
		
		Intent i = getIntent();
		if(i.getExtras().getString("accion").equals("edit")){
			nombre.setText(i.getExtras().getString("nombre"));
			apellido.setText(i.getExtras().getString("apellido"));
			telf.setText(i.getExtras().getString("telf"));
			desc.setText(i.getExtras().getString("desc"));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.guardar, menu);
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
		Intent i = getIntent();
		if (v.getId()==R.id.guardar)
		{
			if(is_empty()){
				i.putExtra("nombre",nombre.getText().toString());
				i.putExtra("apellido",apellido.getText().toString());
				i.putExtra("telf",telf.getText().toString());
				i.putExtra("desc",desc.getText().toString());
				if(i.getExtras().getString("accion").equals("new")){
					i.putExtra("accion","new");
				}else{
					i.putExtra("id", i.getExtras().getString("id"));
					i.putExtra("accion","edit");
				}
				setResult(RESULT_OK, i);
				finish();
			}else{
				Toast toast = Toast.makeText(this, "Relena todos los campos", Toast.LENGTH_SHORT);
				toast.show();
			}
			
		}else if(v.getId()==R.id.cancelar){
			Toast toast1 = Toast.makeText(this, "Ha cancelado la accion", Toast.LENGTH_SHORT);
			toast1.show();
			setResult(RESULT_CANCELED, i);
			finish();
		}
		
	}
	
	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		if(v.getId()==R.id.nombreGuardar){
			if(hasFocus){
				nombre.setText("");
			}else{
				nombre.setText(nombre.getText().toString().toUpperCase());
			}
		}
		if(v.getId()==R.id.apellidoGuardar){
			if(hasFocus){
				apellido.setText("");
			}else{
				apellido.setText(apellido.getText().toString().toUpperCase());
			}
		}
		if(v.getId()==R.id.telfGuardar){
			if(hasFocus){
				telf.setText("");
			}else{
				telf.setText(telf.getText().toString().toUpperCase());
			}
		}
		if(v.getId()==R.id.descGuardar){
			if(hasFocus){
				desc.setText("");
			}else{
				desc.setText(desc.getText().toString().toUpperCase());
			}
		}
		
	}
	
	private boolean is_empty() {
		if(nombre.getText().toString().trim().length() == 0 || apellido.getText().toString().trim().length() == 0 || telf.getText().toString().trim().length() == 0 || desc.getText().toString().trim().length() == 0){
			return false;
		}else{
			return true;
		}
	}
}
