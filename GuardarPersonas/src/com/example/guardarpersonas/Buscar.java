package com.example.guardarpersonas;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Buscar extends Activity implements OnClickListener, OnCheckedChangeListener {
	
	private Button btnVolver, btnAceptar, btnBuscar;
	private EditText etNombre, etApellido, etTelf, etDesc;
	private RadioGroup rg;
	private ArrayList<Persona> arrayPersonas = new ArrayList<Persona>();
	private ArrayList<Persona> arrayPersBuscadas = new ArrayList<Persona>();
	private ArrayList<Button> arrayButton = new ArrayList<Button>();
	private String checked;
	private int IdSeleccionado;
	private LinearLayout ll;
	private Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar);
		
		btnVolver = (Button)findViewById(R.id.volver);
		btnVolver.setOnClickListener(this);
		btnAceptar = (Button)findViewById(R.id.aceptar);
		btnAceptar.setOnClickListener(this);
		btnAceptar.setEnabled(false);
		btnBuscar = (Button)findViewById(R.id.buscar);
		btnBuscar.setOnClickListener(this);
		
		etNombre = (EditText)findViewById(R.id.nombreBuscar);
		etApellido = (EditText)findViewById(R.id.apllidoBuscar);
		etTelf = (EditText)findViewById(R.id.telfBuscar);
		etDesc = (EditText)findViewById(R.id.descBuscar);
		
		ll = (LinearLayout)findViewById(R.id.lineaRaditoButtons);
		
		rg = (RadioGroup)findViewById(R.id.radiogrup);
		rg.setOnCheckedChangeListener(this);
		i = getIntent();
		arrayPersonas = (ArrayList<Persona>) i.getExtras().getSerializable("personas");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buscar, menu);
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
		if (v.getId()==R.id.volver){	
			finish();
		}else if (v.getId()==R.id.buscar){
			arrayPersBuscadas.clear();
			arrayButton.clear();
			ll.removeAllViews();
			if(this.checked.equals("nombre")){
				 Iterator<Persona> itr = arrayPersonas.iterator();
				 while(itr.hasNext()) {
				     Persona pers = itr.next();
				     if(pers.getNombre().contains(etNombre.getText().toString().toUpperCase())){
				    	 crearBoton(pers);
				     }  
				  }
			}else if(this.checked.equals("apellido")){
				 Iterator<Persona> itr = arrayPersonas.iterator();
				 while(itr.hasNext()) {
				     Persona pers = itr.next();
				     if(pers.getApellido().contains(etApellido.getText().toString().toUpperCase())){
				    	crearBoton(pers);
				     }  
				  }
			}else if(this.checked.equals("telf")){
				 Iterator<Persona> itr = arrayPersonas.iterator();
				 while(itr.hasNext()) {
				     Persona pers = itr.next();
				     if(pers.getTelf().contains(etTelf.getText().toString().toUpperCase())){
				    	 crearBoton(pers);
				     }  
				  }
			}else if(this.checked.equals("telf")){
				Iterator<Persona> itr = arrayPersonas.iterator();
				 while(itr.hasNext()) {
				     Persona pers = itr.next();
				     if(pers.getDesc().contains(etDesc.getText().toString().toUpperCase())){
				    	 crearBoton(pers);
				     }  
				  }
				
			}	
		}else if(v.getId()==R.id.aceptar){
			i.putExtra("nombre", etNombre.getText().toString());
			i.putExtra("apellido", etApellido.getText().toString());
			i.putExtra("telf", etTelf.getText().toString());
			i.putExtra("desc", etDesc.getText().toString());
			i.putExtra("accion", "aceptar");
			setResult(RESULT_OK, i);
			finish();
		}
		
	}

	private void crearBoton(Persona pers) {
		arrayPersBuscadas.add(pers);
		Button bt = new Button(this);
		arrayButton.add(bt);
		bt.setText(String.valueOf(arrayButton.size()));
		bt.setId(arrayButton.size()-1);
		bt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
		    	etNombre.setText(arrayPersBuscadas.get(view.getId()).getNombre());
		    	etApellido.setText(arrayPersBuscadas.get(view.getId()).getApellido());
		    	etTelf.setText(arrayPersBuscadas.get(view.getId()).getTelf());
		    	etDesc.setText(arrayPersBuscadas.get(view.getId()).getDesc());
		    	btnAceptar.setEnabled(true);
		    }
		});
		ll.addView(bt);
	}


	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		 if (checkedId == R.id.nombreRadio) {
             etNombre.setEnabled(true);
             etApellido.setEnabled(false);
             etTelf.setEnabled(false);
             etDesc.setEnabled(false);
             this.checked = "nombre";
         } else if (checkedId == R.id.apellidoRadio) {
        	 etNombre.setEnabled(false);
             etApellido.setEnabled(true);
             etTelf.setEnabled(false);
             etDesc.setEnabled(false);
             this.checked = "apellido";
         } else if(checkedId == R.id.telfRadio){
        	 etNombre.setEnabled(false);
             etApellido.setEnabled(false);
             etTelf.setEnabled(true);
             etDesc.setEnabled(false);
             this.checked = "telf";
         }else if (checkedId == R.id.descRadio){
        	 etNombre.setEnabled(false);
             etApellido.setEnabled(false);
             etTelf.setEnabled(false);
             etDesc.setEnabled(true);
             this.checked = "desc";
         }
		
	}
}
