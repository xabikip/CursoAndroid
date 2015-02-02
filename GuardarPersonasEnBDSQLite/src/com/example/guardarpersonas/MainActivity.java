package com.example.guardarpersonas;

import java.util.ArrayList;
import java.util.Iterator;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button btnNuevo, btnEditar, btnBorrar, btnBuscar;
	private EditText nombre, apellido, telf, desc, grupo;
	private LinearLayout Gl;
	private ArrayList<Persona> arrayPersonas = new ArrayList<Persona>();
	private ArrayList<Button> arrayButton = new ArrayList<Button>();
	private int IdSeleccionado=0;
	private String accion;
	private int botonPos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnNuevo=(Button)findViewById(R.id.nuevo);
		btnEditar=(Button)findViewById(R.id.editar);
		btnBorrar=(Button)findViewById(R.id.borrar);
		btnBuscar=(Button)findViewById(R.id.buscar);
		nombre=(EditText)findViewById(R.id.nombre);
		apellido=(EditText)findViewById(R.id.apellido);
		telf=(EditText)findViewById(R.id.telf);
		desc=(EditText)findViewById(R.id.desc);
		grupo=(EditText)findViewById(R.id.grupo);
		Gl=(LinearLayout)findViewById(R.id.botones);
		btnNuevo.setOnClickListener(this);
		btnEditar.setOnClickListener(this);
		btnBorrar.setOnClickListener(this);
		btnBuscar.setOnClickListener(this);
		btnEditar.setEnabled(false);
		btnBorrar.setEnabled(false);
		nombre.setEnabled(false);
		apellido.setEnabled(false);
		telf.setEnabled(false);
		desc.setEnabled(false);
		grupo.setEnabled(false);
		
		Persona persona = new Persona();
		arrayPersonas = persona.findAll(this, null);
		Iterator<Persona> miIterator = arrayPersonas.iterator();
		while(miIterator.hasNext()){
			Persona pers = miIterator.next();
			crearBoton(pers);
		}
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

		if (v.getId()==R.id.nuevo)
		{	
			Intent i = new Intent(this, GuardarActivity.class);
			i.putExtra("accion", "new");
			startActivityForResult(i,1);
		}
		else if (v.getId()==R.id.borrar)
		{	
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(R.string.mensaje)
		           .setTitle(R.string.titulo);
			builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	    arrayButton.get(botonPos).setVisibility(View.GONE);
		        	    arrayButton.clear();
			   			arrayPersonas.clear();
			   			Gl.removeAllViews();
			   			Persona persona = new Persona();
			   			Context context = MainActivity.this;
			   			persona.delete(context, IdSeleccionado);
			   			arrayPersonas = persona.findAll(context, null);
			   			Iterator<Persona> miIterator = arrayPersonas.iterator();
			   			while(miIterator.hasNext()){
			   				Persona pers = miIterator.next();
			   				crearBoton(pers);
			   			}
			   			nombre.setText("");
			   			apellido.setText("");
			   			telf.setText("");
			   			desc.setText("");
			   			grupo.setText("");
			   			btnEditar.setEnabled(false);
			       		btnBorrar.setEnabled(false);
			       		btnNuevo.setEnabled(true);
		           }
		       });
			builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		               // User cancelled the dialog
		           }
		       });
			AlertDialog dialog = builder.create();
			dialog.show();		
		}
		else if (v.getId()==R.id.editar)
		{	
			Intent i = new Intent(this, GuardarActivity.class);
			i.putExtra("nombre", nombre.getText().toString());
			i.putExtra("apellido", apellido.getText().toString());
			i.putExtra("telf", telf.getText().toString());
			i.putExtra("desc", desc.getText().toString());
			i.putExtra("grupo", grupo.getText().toString());
			i.putExtra("id", IdSeleccionado);
			System.out.println(IdSeleccionado);
			i.putExtra("accion", "edit");
			startActivityForResult(i,1);
		}else if (v.getId()==R.id.buscar){
			Intent i = new Intent(this, Buscar.class);
			startActivityForResult(i,2);
		}
	}
	
	public void onActivityResult(int id, int result, Intent intent){
		if(result == RESULT_OK){
			
			accion = intent.getExtras().getString("accion");
			
			if(accion.equals("new")){
				final Button bt = new Button(this);
				arrayButton.add(bt);
				bt.setText(String.valueOf(arrayButton.size()));
				botonPos = Integer.parseInt(String.valueOf(arrayButton.size()));
				bt.setId(intent.getIntExtra("id",0));
				bt.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View view) {
		            	botonPos = arrayButton.indexOf(bt);
		            	IdSeleccionado = view.getId();
		            	Persona persona = new Persona();
		            	Context context = MainActivity.this;
		            	persona = persona.findOne(context, IdSeleccionado);
		            	nombre.setText(persona.getNombre());
		            	apellido.setText(persona.getApellido());
		            	telf.setText(persona.getTelf());
		            	desc.setText(persona.getDesc());
		            	grupo.setText(persona.getGrupo());
		            	btnEditar.setEnabled(true);
		        		btnBorrar.setEnabled(true);
		        		btnNuevo.setEnabled(true);
		            }
		        });
				Gl.addView(bt);
			}else if(accion.equals("aceptar")){
				nombre.setText(intent.getExtras().getString("nombre"));
				apellido.setText(intent.getExtras().getString("apellido"));
				telf.setText(intent.getExtras().getString("telf"));
				desc.setText(intent.getExtras().getString("desc"));
				btnEditar.setEnabled(true);
        		btnBorrar.setEnabled(true);
			}
		}else if (result == 1){
				Persona persona = new Persona();
	        	Context context = MainActivity.this;
	        	persona = persona.findOne(context, intent.getIntExtra("id",0));
				nombre.setText(persona.getNombre());
				apellido.setText(persona.getApellido());
				telf.setText(persona.getTelf());
				desc.setText(persona.getDesc());
				grupo.setText(persona.getGrupo());
		}
		
	}
	
	public void crearBoton(Persona persona){
		final Button bt = new Button(this);
		arrayButton.add(bt);
		bt.setText(String.valueOf(arrayButton.size()));
		bt.setId(persona.getId());
		bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	botonPos = arrayButton.indexOf(bt);
            	IdSeleccionado = view.getId();
            	Persona persona = new Persona();
            	Context context = MainActivity.this;
            	persona = persona.findOne(context, IdSeleccionado);
            	nombre.setText(persona.getNombre());
            	apellido.setText(persona.getApellido());
            	telf.setText(persona.getTelf());
            	desc.setText(persona.getDesc());
            	grupo.setText(persona.getGrupo());
            	btnEditar.setEnabled(true);
        		btnBorrar.setEnabled(true);
        		btnNuevo.setEnabled(true);
            }
        });
		Gl.addView(bt);
	}
}
