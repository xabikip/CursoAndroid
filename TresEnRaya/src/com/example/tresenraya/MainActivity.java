package com.example.tresenraya;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button bEmpezar, b1,b2,b3,b4,b5,b6,b7,b8,b9;
	private String judador;
	private TextView tvTurno;
	private int cont=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inicializar();
		
	}

	private void inicializar() {
		bEmpezar = (Button)findViewById(R.id.empezar);
		bEmpezar.setOnClickListener(this);
		
		tvTurno = (TextView)findViewById(R.id.turno);
		
		b1 = (Button)findViewById(R.id.b1);
		b1.setOnClickListener(this);
		b2 = (Button)findViewById(R.id.b2);
		b2.setOnClickListener(this);
		b3 = (Button)findViewById(R.id.b3);
		b3.setOnClickListener(this);
		b4 = (Button)findViewById(R.id.b4);
		b4.setOnClickListener(this);
		b5 = (Button)findViewById(R.id.b5);
		b5.setOnClickListener(this);
		b6 = (Button)findViewById(R.id.b6);
		b6.setOnClickListener(this);
		b7 = (Button)findViewById(R.id.b7);
		b7.setOnClickListener(this);
		b8 = (Button)findViewById(R.id.b8);
		b8.setOnClickListener(this);
		b9 = (Button)findViewById(R.id.b9);
		b9.setOnClickListener(this);
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
		if (v.getId()==R.id.empezar && bEmpezar.getText().toString().equals("Empezar")){
			habilitarBotones(true);
			bEmpezar.setText("Salir");
			this.judador = "x";
			tvTurno.setText("Turno del jugador: x");
			borrarCampos();
			this.cont=0;
		}else if(v.getId()==R.id.empezar && bEmpezar.getText().toString().equals("Salir")){
			borrarCampos();
			bEmpezar.setText("Empezar");
			habilitarBotones(false);
		}else if(v.getId()==R.id.b1){
			escribirJugada(this.judador, b1);
			comprobarGanador();
			cambiarJugador();
		}else if(v.getId()==R.id.b2){
			escribirJugada(this.judador, b2);
			comprobarGanador();
			cambiarJugador();
		}else if(v.getId()==R.id.b3){
			escribirJugada(this.judador, b3);
			comprobarGanador();
			cambiarJugador();
		}else if(v.getId()==R.id.b4){
			escribirJugada(this.judador, b4);
			comprobarGanador();
			cambiarJugador();
		}else if(v.getId()==R.id.b5){
			escribirJugada(this.judador, b5);
			comprobarGanador();
			cambiarJugador();
		}else if(v.getId()==R.id.b6){
			escribirJugada(this.judador, b6);
			comprobarGanador();
			cambiarJugador();
		}else if(v.getId()==R.id.b7){
			escribirJugada(this.judador, b7);
			comprobarGanador();
			cambiarJugador();
		}else if(v.getId()==R.id.b8){
			escribirJugada(this.judador, b8);
			comprobarGanador();
			cambiarJugador();
		}else if(v.getId()==R.id.b9){
			escribirJugada(this.judador, b9);
			comprobarGanador();
			cambiarJugador();
		}
		
	}
	private void comprobarGanador(){
		if(b1.getText().toString().equals(this.judador)
			&& b2.getText().toString().equals(this.judador)
			&& b3.getText().toString().equals(this.judador)){
			ganado();
		}else if(b4.getText().toString().equals(this.judador)
				 && b5.getText().toString().equals(this.judador)
				 && b6.getText().toString().equals(this.judador)){
			ganado();
		}else if(b7.getText().toString().equals(this.judador)
				 && b8.getText().toString().equals(this.judador)
				 && b9.getText().toString().equals(this.judador)){
			ganado();
		}else if(b1.getText().toString().equals(this.judador)
				 && b4.getText().toString().equals(this.judador)
				 && b7.getText().toString().equals(this.judador)){
			ganado();
		}else if(b2.getText().toString().equals(this.judador)
				 && b5.getText().toString().equals(this.judador)
				 && b8.getText().toString().equals(this.judador)){
			ganado();
		}else if(b3.getText().toString().equals(this.judador)
				 && b6.getText().toString().equals(this.judador)
				 && b9.getText().toString().equals(this.judador)){
			ganado();
		}else if(b1.getText().toString().equals(this.judador)
				 && b5.getText().toString().equals(this.judador)
				 && b9.getText().toString().equals(this.judador)){
			ganado();
		}else if(b3.getText().toString().equals(this.judador)
				 && b5.getText().toString().equals(this.judador)
				 && b7.getText().toString().equals(this.judador)){
			ganado();
		}else if(this.cont == 9){
			Toast toast = Toast.makeText(this, "Habeis empatado", Toast.LENGTH_SHORT);
			toast.show();
			habilitarBotones(false);
			bEmpezar.setText("Empezar");
		}
	}

	private void ganado() {
		Toast toast = Toast.makeText(this, "Has ganado " + this.judador, Toast.LENGTH_SHORT);
		toast.show();
		habilitarBotones(false);
		bEmpezar.setText("Empezar");
	}
	
	private void cambiarJugador(){
		if(this.judador.toString().equals("x")){
			this.judador = "0";
			tvTurno.setText("Turno del jugador: O");
		}else{
			this.judador = "x";
			tvTurno.setText("Turno del jugador: x");
		}
	}
	
	private void escribirJugada(String jugador, Button boton){
		boton.setText(jugador);
		boton.setEnabled(false);
		this.cont++;
	}

	private void borrarCampos() {
		b1.setText("");
		b2.setText("");
		b3.setText("");
		b4.setText("");
		b5.setText("");
		b6.setText("");
		b7.setText("");
		b8.setText("");
		b9.setText("");
	}
	
	void habilitarBotones(boolean estado){
		b1.setEnabled(estado);
		b2.setEnabled(estado);
		b3.setEnabled(estado);
		b4.setEnabled(estado);
		b5.setEnabled(estado);
		b6.setEnabled(estado);
		b7.setEnabled(estado);
		b8.setEnabled(estado);
		b9.setEnabled(estado);
	}
}
