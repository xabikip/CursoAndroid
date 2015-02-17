package com.example.dibujable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class PuntosCardinales extends View{

	public PuntosCardinales(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressLint("DrawAllocation")
	protected void onDraw(Canvas canvas){
		canvas.drawColor(Color.BLACK);
		
		Paint norte = new Paint(Paint.ANTI_ALIAS_FLAG);
		norte.setColor(Color.WHITE);
		canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/4, canvas.getWidth()/16, norte);
		
		Paint sur = new Paint(Paint.ANTI_ALIAS_FLAG);
		sur.setColor(Color.RED);
		canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight() - canvas.getHeight()/4, canvas.getWidth()/16, sur);
		
		Paint este = new Paint(Paint.ANTI_ALIAS_FLAG);
		este.setColor(Color.YELLOW);
		canvas.drawCircle(canvas.getWidth()/2 - canvas.getHeight()/4 , canvas.getHeight()/2, canvas.getWidth()/16, este);
		
		Paint oeste = new Paint(Paint.ANTI_ALIAS_FLAG);
		oeste.setColor(Color.BLUE);
		canvas.drawCircle(canvas.getWidth()/2 + canvas.getHeight()/4, canvas.getHeight()/2, canvas.getWidth()/16, oeste);
		
		Paint lineaVert = new Paint();
		lineaVert.setColor(Color.WHITE);
		canvas.drawLine(canvas.getWidth()/2, canvas.getHeight()/4, canvas.getWidth()/2, canvas.getHeight() - canvas.getHeight()/4, lineaVert);
		
		Paint lineaHoriz = new Paint();
		lineaHoriz.setColor(Color.WHITE);
		canvas.drawLine(canvas.getWidth()/2 - canvas.getHeight()/4 , canvas.getHeight()/2, canvas.getWidth()/2 + canvas.getHeight()/4, canvas.getHeight()/2, lineaHoriz);
		
		Paint puntoSur = new Paint();
		puntoSur.setColor(Color.BLACK);
		puntoSur.setStyle(Paint.Style.STROKE);
		puntoSur.setStrokeWidth(5);
		canvas.drawPoint(canvas.getWidth()/2, canvas.getHeight() - canvas.getHeight()/4, puntoSur);
		
		Paint puntoNorte = new Paint();
		puntoNorte.setColor(Color.BLACK);
		puntoNorte.setStyle(Paint.Style.STROKE);
		puntoNorte.setStrokeWidth(5);
		canvas.drawPoint(canvas.getWidth()/2, canvas.getHeight()/4, puntoNorte);
		
		Paint puntoEste = new Paint();
		puntoEste.setColor(Color.BLACK);
		puntoEste.setStyle(Paint.Style.STROKE);
		puntoEste.setStrokeWidth(5);
		canvas.drawPoint(canvas.getWidth()/2 - canvas.getHeight()/4 , canvas.getHeight()/2, puntoEste);
		
		Paint puntoOeste = new Paint();
		puntoOeste.setColor(Color.BLACK);
		puntoOeste.setStyle(Paint.Style.STROKE);
		puntoOeste.setStrokeWidth(5);
		canvas.drawPoint(canvas.getWidth()/2 + canvas.getHeight()/4, canvas.getHeight()/2, puntoOeste);
		
		Paint lineaDiag1 = new Paint();
		lineaDiag1.setColor(Color.WHITE);
		canvas.drawLine(canvas.getWidth()/2 + canvas.getHeight()/8,  
						canvas.getHeight()/4 + canvas.getHeight()/8, 
						(canvas.getWidth()/2 - canvas.getHeight()/4) + canvas.getHeight()/8, 
						canvas.getHeight()/2 + canvas.getHeight()/8, 
						lineaDiag1);
		
		Paint lineaDiag2 = new Paint();
		lineaDiag2.setColor(Color.WHITE);
		canvas.drawLine((canvas.getWidth()/2 - canvas.getHeight()/4) + canvas.getHeight()/8,  
						canvas.getHeight()/4 + canvas.getHeight()/8, 
						canvas.getWidth()/2 + canvas.getHeight()/8, 
						canvas.getHeight()/2 + canvas.getHeight()/8, 
						lineaDiag2);
		
		Paint CirculoDentro = new Paint(Paint.ANTI_ALIAS_FLAG);
		CirculoDentro.setColor(Color.WHITE);
		CirculoDentro.setStyle(Paint.Style.STROKE);
		CirculoDentro.setStrokeWidth(8);
		canvas.drawCircle(canvas.getWidth()/2,  canvas.getHeight()/2, canvas.getHeight()/6, CirculoDentro);
		
		Paint punto1 = new Paint();
		punto1.setColor(Color.MAGENTA);
		punto1.setStyle(Paint.Style.STROKE);
		punto1.setStrokeWidth(10);
		canvas.drawPoint(((canvas.getWidth()/2 - canvas.getHeight()/4) + canvas.getHeight()/8) + canvas.getHeight()/16, 
						(canvas.getHeight()/4 + canvas.getHeight()/8) - canvas.getHeight()/32, 
						punto1);
		
		Paint punto2 = new Paint();
		punto2.setColor(Color.LTGRAY);
		punto2.setStyle(Paint.Style.STROKE);
		punto2.setStrokeWidth(10);
		canvas.drawPoint((canvas.getWidth()/2 + canvas.getHeight()/8) - canvas.getHeight()/16, 
						(canvas.getHeight()/4 + canvas.getHeight()/8) - canvas.getHeight()/32, 
						punto2);
		
		Paint punto3 = new Paint();
		punto3.setColor(Color.CYAN);
		punto3.setStyle(Paint.Style.STROKE);
		punto3.setStrokeWidth(10);
		canvas.drawPoint((canvas.getWidth()/2 + canvas.getHeight()/8) - canvas.getHeight()/16, 
						(canvas.getHeight()/4 + canvas.getHeight()/8) - canvas.getHeight()/32, 
						punto2);
	}
	
	
	

}
