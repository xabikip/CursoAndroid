package com.example.listviewfechaasunto;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {
	
	private final String SQL_CREATE = "CREATE TABLE AGENDA (" +
			"_ID INTEGER PRIMARY KEY," +
			"ASUNTO TEXT," +
			"DIA TEXT," +
			"MES TEXT," +
			"ANO TEXT)";

	public DBhelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public int save(String asunto, String dia, String mes, String ano){
		int id = 0;
		SQLiteDatabase persDBWrite = getWritableDatabase();
		if(persDBWrite.isOpen()){
			persDBWrite.execSQL("INSERT INTO AGENDA ("
					+ "ASUNTO, DIA, MES, ANO) VALUES ("
					+ "'" + asunto + "','" +
					dia + "','" + mes + "','" + ano + "')");
			persDBWrite.close();
		}
		SQLiteDatabase persDBRead = getReadableDatabase();
		if(persDBRead.isOpen()){
			Cursor c = persDBRead.rawQuery("SELECT * FROM AGENDA", null);
			if(c.getCount() != 0){
				c.moveToLast();
				id = c.getInt(c.getColumnIndex("_ID"));
			}
			persDBRead.close();
		}
		return id;
	}
	
	@SuppressWarnings("null")
	public ArrayList<String[]> findAll(){

		ArrayList<String[]> arrayAsuntos = new ArrayList<String[]>();
		String[] asunto = new String[5];
		SQLiteDatabase persDBRead = getReadableDatabase();
		if(persDBRead.isOpen()){
			Cursor c = persDBRead.rawQuery("SELECT * FROM AGENDA", null);
			if(c.moveToFirst()){
				do{
					asunto[0] = c.getString(c.getColumnIndex("_ID"));
					asunto[1] = c.getString(c.getColumnIndex("ASUNTO"));
					asunto[2] = c.getString(c.getColumnIndex("DIA"));
					asunto[3] = c.getString(c.getColumnIndex("MES"));
					asunto[4] = c.getString(c.getColumnIndex("ANO"));
					arrayAsuntos.add(asunto);
					asunto = new String[5];
				}while(c.moveToNext());

			}
			persDBRead.close();
		}
		return arrayAsuntos;
		
	}
	
	public void delete(int posicion){
		int id=0;
		SQLiteDatabase dbRead = getReadableDatabase();
		Cursor c = dbRead.rawQuery("select * from agenda", null);
		if (c.getCount() > 0) 
		{
			c.moveToPosition(posicion);
			id = c.getInt(c.getColumnIndex("_ID"));
		}
		c.close();
		dbRead.close();
		SQLiteDatabase db = getWritableDatabase();
		if(db!=null){
			db.execSQL("DELETE FROM AGENDA WHERE _ID=" + id);
			db.close();   
		}
	}

}
