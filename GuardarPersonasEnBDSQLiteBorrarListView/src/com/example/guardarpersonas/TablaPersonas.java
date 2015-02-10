package com.example.guardarpersonas;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TablaPersonas extends Activity implements OnClickListener{
	
	private TableLayout tl;
	private String linea;
	private Button bt;
	private TableRow tr;
	private TextView text;
	private int cont=1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabla_personas);
		tl=(TableLayout)findViewById(R.id.TableLayout);
		bt=(Button)findViewById(R.id.volverContact);
		bt.setOnClickListener( this);
		try {
			FileInputStream fi = openFileInput("personas.txt");
			DataInputStream entrada = new DataInputStream(fi);
			while ((linea=entrada.readLine())!=null) {
				tr = new TableRow(this);
				text = new TextView(this);
				text.setText("PERSONA "+ cont);
				tr.addView(text);
				tl.addView(tr);
				String[] split = linea.split(";");
				for (int i = 0; i < split.length; i++) {
					tr = new TableRow(this);
					text = new TextView(this);
					text.setText(split[i]);
					tr.addView(text);
					tl.addView(tr);
				}
				cont++;
		    }
			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tabla_personas, menu);
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
		if (v.getId()==R.id.volverContact)
			{
				finish();
			}
	}
}
