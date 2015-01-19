package com.example.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button   btnIgual, btnMas, btnResta, btnDivide, btnMulti, btnPunto;	
	private Button   btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
	private TextView TVPantalla;
	
	private String boton, op="", opActual="", pasoAnterior;
	private float num=0, result=0;
	private boolean primero = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.TVPantalla = (TextView)this.findViewById(R.id.pantalla);
		
		this.btnIgual = (Button)this.findViewById(R.id.btnIgual);
		btnIgual.setOnClickListener(this);
		
		this.btnMas = (Button)this.findViewById(R.id.btnMas);
		btnMas.setOnClickListener(this);
		
		this.btnResta = (Button)this.findViewById(R.id.btnResta);
		btnResta.setOnClickListener(this);
		
		this.btnDivide = (Button)this.findViewById(R.id.btnDivide);
		btnDivide.setOnClickListener(this);
		
		this.btnMulti = (Button)this.findViewById(R.id.btnMulti);
		btnMulti.setOnClickListener(this);
		
		this.btnPunto = (Button)this.findViewById(R.id.btnPunto);
		btnPunto.setOnClickListener(this);
		
		
		this.btn1 = (Button)this.findViewById(R.id.btn1);
		btn1.setOnClickListener(this);
		
		this.btn2 = (Button)this.findViewById(R.id.btn2);
		btn2.setOnClickListener(this);
		
		this.btn3 = (Button)this.findViewById(R.id.btn3);
		btn3.setOnClickListener(this);
		
		this.btn4 = (Button)this.findViewById(R.id.btn4);
		btn4.setOnClickListener(this);
		
		this.btn5 = (Button)this.findViewById(R.id.btn5);
		btn5.setOnClickListener(this);
		
		this.btn6 = (Button)this.findViewById(R.id.btn6);
		btn6.setOnClickListener(this);
		
		this.btn7 = (Button)this.findViewById(R.id.btn7);
		btn7.setOnClickListener(this);
		
		this.btn8 = (Button)this.findViewById(R.id.btn8);
		btn8.setOnClickListener(this);
		
		this.btn9 = (Button)this.findViewById(R.id.btn9);
		btn9.setOnClickListener(this);
		
		this.btn0 = (Button)this.findViewById(R.id.btn0);
		btn0.setOnClickListener(this);
		
		
		
		
	}
	
	public void onClick(View v){
		
		String TVPantallaText = TVPantalla.getText().toString();
		
		boton = switchearBoton(v);
		
		if(boton == "0" || boton == "1" || boton == "2" || boton == "3" || boton == "4" || boton == "5" || boton == "6"
				|| boton == "7"|| boton == "8"|| boton == "9"){
			if(TVPantallaText.equals("0") || pasoAnterior == "operador"){
				this.TVPantalla.setText(boton);
				pasoAnterior = "num";
			}else{
				this.TVPantalla.setText(TVPantallaText + boton);
				pasoAnterior = "num";
			}
		}else{
			pasoAnterior = "operador";
			opActual = boton;
			if(primero){
				op = boton;
				num = Float.parseFloat(TVPantallaText);
				primero = false;
			}else{
				if(op == "+" && !opActual.equals("=")){
					result = num + Float.parseFloat(TVPantallaText);
					TVPantalla.setText(String.valueOf(result));
					op = boton;
					num = result;
				}else if(op == "-" && !opActual.equals("=")){
					result = num - Float.parseFloat(TVPantallaText);
					TVPantalla.setText(String.valueOf(result));
					op = boton;
					num = result;
				}else if(op.equals("/") && !opActual.equals("=")){
					result = num / Float.parseFloat(TVPantallaText);
					TVPantalla.setText(String.valueOf(result));
					op = boton;
					num = result;
				}else if(op.equals("*") && !opActual.equals("=")){
					result = num * Float.parseFloat(TVPantallaText);
					TVPantalla.setText(String.valueOf(result));
					op = boton;
					num = result;
				}else if(opActual.equals("=") ){
					primero = true;
					result = 0;
					if(op == "+"){
						result = num + Float.parseFloat(TVPantallaText);
					}else if(op == "-"){
						result = num - Float.parseFloat(TVPantallaText);
					}else if(op == "/"){
						result = num / Float.parseFloat(TVPantallaText);
					}else if(op == "*"){
						result = num * Float.parseFloat(TVPantallaText);
					}
					this.TVPantalla.setText(String.valueOf(result));
				}
			}				
		}
		
	}

	private String switchearBoton(View v) {
		switch(v.getId()){
		case R.id.btnIgual:
			 this.boton = "=";break;
		case R.id.btnMas:
			 this.boton = "+";break;
		case R.id.btnResta:
			 this.boton = "-";break;
		case R.id.btnDivide:
			 this.boton = "/";break;
		case R.id.btnMulti:
			 this.boton = "*";break;
		case R.id.btn0:
			 this.boton = "0";break;
		case R.id.btn1:
			 this.boton = "1";break;
		case R.id.btn2:
			 this.boton = "2";break;
		case R.id.btn3:
			 this.boton = "3";break;
		case R.id.btn4:
			 this.boton = "4";break;
		case R.id.btn5:
			 this.boton = "5";break;
		case R.id.btn6:
			 this.boton = "6";break;
		case R.id.btn7:
			 this.boton = "7";break;
		case R.id.btn8:
			 this.boton = "8";break;
		case R.id.btn9:
			 this.boton = "9";break;		 
		}
		return boton;
	}
}
