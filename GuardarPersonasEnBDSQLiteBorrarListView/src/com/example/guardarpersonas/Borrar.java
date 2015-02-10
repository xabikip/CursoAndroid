package com.example.guardarpersonas;

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
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Borrar extends Activity implements OnClickListener{
	private Button btnTodos, btnBorrar, btnVolver;
	private ArrayList<Persona> arrayPersonas =null;
	private ArrayList<Persona> arrayPersonas2 =null;
	private ListView lista;
	private Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_borrar);
		
		btnTodos = (Button)findViewById(R.id.botonTodos);
		btnTodos.setOnClickListener(this);
		btnBorrar = (Button)findViewById(R.id.botonBorrar);
		btnBorrar.setOnClickListener(this);
		btnVolver = (Button)findViewById(R.id.botonVolver);
		btnVolver.setOnClickListener(this);
		
		i = getIntent();
		
		Persona persona = new Persona();
		arrayPersonas = new ArrayList<Persona>();
		arrayPersonas = persona.findAll(this, null);
		lista = (ListView)findViewById(R.id.ListView_listado);
		lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, arrayPersonas){
			
			@Override
			public void onEntrada(Object entrada, View view) {
				// TODO Auto-generated method stub
				if(entrada != null){
					TextView txtSupEntrada = (TextView)view.findViewById(R.id.TextV_superior);
					if(txtSupEntrada != null){
						txtSupEntrada.setText(((Persona)entrada).getNombre() + "  " +
								              ((Persona)entrada).getApellido());
					}
					TextView txtId = (TextView)view.findViewById(R.id.TextV_id);
					if(txtId != null){
						String id_txt = Integer.toString(((Persona)entrada).getId());
						txtId.setText(id_txt);
					}
					
				}
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.borrar, menu);
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
		// TODO Auto-generated method stub
		if (v.getId()==R.id.botonVolver){
			i.putExtra("accion", "volver");
			setResult(RESULT_OK, i);
			finish();
		}else if(v.getId()==R.id.botonTodos){
			if(btnTodos.getText().equals("Selec. Todos")){
				int size = lista.getChildCount();
				for(int i = 0; i<size; i++){
					LinearLayout entrada = (LinearLayout) lista.getChildAt(i);
					CheckBox ch = (CheckBox) entrada.getChildAt(0);
					if(ch instanceof CheckBox){
						ch.setChecked(true);
					}
				}	
				btnTodos.setText("Deselc. todos");
			}else if(btnTodos.getText().equals("Deselc. todos")){
				int size = lista.getChildCount();
				for(int i=0;i<size;i++){
					LinearLayout entrada = (LinearLayout) lista.getChildAt(i);
					CheckBox ch = (CheckBox) entrada.getChildAt(0);
					if(ch instanceof CheckBox && ch.isChecked()){
						ch.setChecked(false);
					}
				}
				btnTodos.setText("Selec. Todos");
			}
			
		}else if (v.getId()==R.id.botonBorrar){
			int size = lista.getChildCount();
			for(int i = 0; i<size; i++){
				LinearLayout entrada = (LinearLayout) lista.getChildAt(i);
				CheckBox ch = (CheckBox) entrada.getChildAt(0);
				LinearLayout ln = (LinearLayout) entrada.getChildAt(1);
				TextView tv = (TextView) ln.getChildAt(1);
				if(ch instanceof CheckBox && ch.isChecked()){
					Persona persona = new Persona();
					if(tv instanceof TextView){
						int id = Integer.parseInt(tv.getText().toString());
						persona.delete(this, id);
					}
				}
			}
			Persona persona = new Persona();
			arrayPersonas.clear();
			arrayPersonas2 = persona.findAll(this, null);
			Iterator<Persona> it = arrayPersonas2.iterator();	
			while(it.hasNext())
			{	
				Persona obj = it.next();
				arrayPersonas.add(obj);			
			}
			((Lista_adaptador)lista.getAdapter()).notifyDataSetChanged();	
			for(int i=0;i<size;i++){
				LinearLayout entrada = (LinearLayout) lista.getChildAt(i);
				CheckBox ch = (CheckBox) entrada.getChildAt(0);
				if(ch instanceof CheckBox && ch.isChecked()){
					ch.setChecked(false);
				}
			}
		}
	
	}
}
