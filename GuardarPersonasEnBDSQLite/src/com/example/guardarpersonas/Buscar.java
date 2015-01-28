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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Buscar extends Activity implements OnClickListener, OnCheckedChangeListener {
	
	private Button btnVolver, btnAceptar, btnBuscar;
	private EditText etNombre, etApellido, etTelf, etDesc;
	private RadioGroup rg;
	private ArrayList<Persona> arrayPersonas = new ArrayList<Persona>();
	private ArrayList<Persona> arrayPersBuscadas = new ArrayList<Persona>();
	private ArrayList<Button> arrayButton = new ArrayList<Button>();
	private ArrayList<String> alLista = new ArrayList<String>();
	private String checked;
	private int IdSeleccionado;
	private LinearLayout ll;
	private Intent i;
	private Spinner sLista;

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

		alLista.add("familia");
		alLista.add("amigos");
		alLista.add("trabajo");
		alLista.add("cuadrilla");
		alLista.add("clase");
		
		sLista = (Spinner)findViewById(R.id.gruposBuscar);
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
						this, android.R.layout.simple_list_item_1, alLista);
		sLista.setAdapter(adaptador);

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
				Persona persona = new Persona();
				arrayPersBuscadas = persona.find(this, "NOMBRE", etNombre.getText().toString().toUpperCase());
				Iterator<Persona> miIterator = arrayPersBuscadas.iterator();
				while(miIterator.hasNext()){
					Persona pers = miIterator.next();
					crearBoton(pers);
				}
			}else if(this.checked.equals("apellido")){
				Persona persona = new Persona();
				arrayPersBuscadas = persona.find(this, "APELLIDO", etApellido.getText().toString().toUpperCase());
				Iterator<Persona> miIterator = arrayPersBuscadas.iterator();
				while(miIterator.hasNext()){
					Persona pers = miIterator.next();
					crearBoton(pers);
				}
			}else if(this.checked.equals("telf")){
				Persona persona = new Persona();
				arrayPersBuscadas = persona.find(this, "TELEFONO", etTelf.getText().toString().toUpperCase());
				Iterator<Persona> miIterator = arrayPersBuscadas.iterator();
				while(miIterator.hasNext()){
					Persona pers = miIterator.next();
					crearBoton(pers);
				}
			}else if(this.checked.equals("desc")){
				Persona persona = new Persona();
				arrayPersBuscadas = persona.find(this, "DESCRIPCION", etDesc.getText().toString().toUpperCase());
				Iterator<Persona> miIterator = arrayPersBuscadas.iterator();
				while(miIterator.hasNext()){
					Persona pers = miIterator.next();
					crearBoton(pers);
				}
			}else if(this.checked.equals("grupo")){
				Persona persona = new Persona();
				arrayPersBuscadas = persona.find(this, "GRUPO", sLista.getSelectedItem().toString());
				Iterator<Persona> miIterator = arrayPersBuscadas.iterator();
				while(miIterator.hasNext()){
					Persona pers = miIterator.next();
					crearBoton(pers);
				}
				 
			}	
		}else if(v.getId()==R.id.aceptar){
			i.putExtra("nombre", etNombre.getText().toString());
			i.putExtra("apellido", etApellido.getText().toString());
			i.putExtra("telf", etTelf.getText().toString());
			i.putExtra("desc", etDesc.getText().toString());
			i.putExtra("grupo", sLista.getSelectedItem().toString());
			i.putExtra("accion", "aceptar");
			setResult(RESULT_OK, i);
			finish();
		}
		
	}

	private void crearBoton(final Persona persona) {
		Button bt = new Button(this);
		arrayButton.add(bt);
		bt.setText(String.valueOf(arrayButton.size()));
		bt.setId(persona.getId());
		bt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
		    	etNombre.setText(persona.getNombre());
		    	etApellido.setText(persona.getApellido());
		    	etTelf.setText(persona.getTelf());
		    	etDesc.setText(persona.getDesc());
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
         }else if (checkedId == R.id.grupoRadio){
        	 etNombre.setEnabled(false);
             etApellido.setEnabled(false);
             etTelf.setEnabled(false);
             etDesc.setEnabled(false);
             this.checked = "grupo";
             System.out.println("Hemen baiiiii");
         }
		
	}
}
