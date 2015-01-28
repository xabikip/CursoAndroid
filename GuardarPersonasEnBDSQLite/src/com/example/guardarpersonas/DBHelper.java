package com.example.guardarpersonas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	private final String SQL_CREATE = "CREATE TABLE PERSONA (" +
			"_ID INTEGER PRIMARY KEY," +
			"NOMBRE TEXT," +
			"APELLIDO TEXT," +
			"TELEFONO TEXT," +
			"DESCRIPCION TEXT," +
			"GRUPO TEXT)";

	public DBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
}
