package com.example.componentlistview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends ListActivity{
	
	private List<String> listaArray=null;
	private ArrayAdapter<String> adaptador=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listaArray=new ArrayList<String>();
		listaArray.add("Iphone");
		listaArray.add("Windows phone");
		listaArray.add("Android");
		listaArray.add("Blackberry");
		
		adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaArray);
		setListAdapter(adaptador);
		
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
	
	public void evento(View vista){
		listaArray.add("Nuevo");
		adaptador.notifyDataSetChanged();
	}
	
	@Override
	public void onListItemClick(ListView l, View v,final int position, long id){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.mensaje)
	           .setTitle(R.string.titulo);
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	        	   listaArray.remove(position);
	       		   adaptador.notifyDataSetChanged();
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

}
