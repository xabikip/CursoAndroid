package com.example.listviewfechaasunto;

import java.util.ArrayList;
import java.util.List;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends ListActivity implements OnClickListener{
	
	private List<String> ArrayDia=null;
	private List<String> ArrayMes=null;
	private List<String> ArrayAno=null;
	private List<String> ArrayLista=null;
	private ArrayAdapter<String> adaptDia=null;
	private ArrayAdapter<String> adaptMes=null;
	private ArrayAdapter<String> adaptAno=null;
	private ArrayAdapter<String> adaptLista=null;
	private Spinner spinDia, spinMes, spinAno;
	private Button boton;
	private EditText asunto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		boton = (Button)findViewById(R.id.boton1);
		boton.setOnClickListener(this);
		
		asunto = (EditText)findViewById(R.id.asunto);
		
		ArrayDia=new ArrayList<String>();
		for(int i=1;i<=31;i++){
			ArrayDia.add(String.valueOf(i));
		}
		spinDia =(Spinner)findViewById(R.id.dia);
		adaptDia=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ArrayDia);
		spinDia.setAdapter(adaptDia);
		
		ArrayMes=new ArrayList<String>();
		ArrayMes.add("Enero");
		ArrayMes.add("Febrero");
		ArrayMes.add("Marzo");
		ArrayMes.add("Abril");
		ArrayMes.add("Mayo");
		ArrayMes.add("Junio");
		ArrayMes.add("Julio");
		ArrayMes.add("Agosto");
		ArrayMes.add("Setiembre");
		ArrayMes.add("Otubre");
		ArrayMes.add("Noviembre");
		ArrayMes.add("Diciembre");
		spinMes =(Spinner)findViewById(R.id.mes);
		adaptMes=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ArrayMes);
		spinMes.setAdapter(adaptMes);
		
		ArrayAno=new ArrayList<String>();
		for(int i=2000;i<=2100;i++){
			ArrayAno.add(String.valueOf(i));
		}
		spinAno =(Spinner)findViewById(R.id.ano);
		adaptAno=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ArrayAno);
		spinAno.setAdapter(adaptAno);
		
		ArrayLista=new ArrayList<String>();
		adaptLista=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ArrayLista);
		setListAdapter(adaptLista);
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
		if (v.getId()==R.id.boton1){
			if(is_empty()){
				ArrayLista.add(spinDia.getSelectedItem().toString()+ " de " +
						spinMes.getSelectedItem().toString()+ " del " +
						spinAno.getSelectedItem().toString()+ " \n" +
						asunto.getText().toString());
				adaptLista.notifyDataSetChanged();
				asunto.setText("");
			}else{
				Toast toast = Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT);
				toast.show();
			}
		}
		
	}
	
	@Override
	public void onListItemClick(ListView l, View v,final int position, long id){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.mensaje)
	           .setTitle(R.string.titulo);
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	        	   ArrayLista.remove(position);
	        	   adaptLista.notifyDataSetChanged();
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
	
	private boolean is_empty() {
		if(asunto.getText().toString().trim().length() == 0 ){
			return false;
		}else{
			return true;
		}
	}
}
