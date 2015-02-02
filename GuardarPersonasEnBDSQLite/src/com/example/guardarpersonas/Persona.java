package com.example.guardarpersonas;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

@SuppressWarnings("serial")
public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre="";
	private String apellido="";
	private String telf="";
	private String desc="";
	private String grupo="";
	
	private DBHelper dbHelper;
	private int id=0;
	
	public Persona(String nombre, String apellido, String telf, String desc, String grupo)
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.telf=telf;
		this.desc=desc;
		this.grupo=grupo;
	}
	
	public Persona(int id, String nombre, String apellido, String telf, String desc, String grupo)
	{
		this.id=id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.telf=telf;
		this.desc=desc;
		this.grupo=grupo;
	}

	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelf() {
		return telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	public int save(Context contexto){
		dbHelper = new DBHelper( contexto, "PERSONASDB", null, 1);
		SQLiteDatabase persDBWrite = dbHelper.getWritableDatabase();
		if(persDBWrite.isOpen()){
			persDBWrite.execSQL("INSERT INTO PERSONA ("
					+ "NOMBRE, APELLIDO, TELEFONO, DESCRIPCION,"
					+ "GRUPO) VALUES ('" + 
					this.nombre + "','" +
					this.apellido + "','" +
					this.telf + "','" +
					this.desc + "','" +
					this.grupo + "')"
					);
			persDBWrite.close();
		}
		SQLiteDatabase persDBRead = dbHelper.getReadableDatabase();
		if(persDBRead.isOpen()){
			Cursor c = persDBRead.rawQuery("SELECT * FROM PERSONA", null);
			if(c.getCount() != 0){
				c.moveToLast();
				this.id = c.getInt(c.getColumnIndex("_ID"));
			}
			persDBRead.close();
		}
		return this.id;
	}
	
	public Persona findOne(Context contexto, int id){
		Persona persona = null;
		dbHelper = new DBHelper( contexto, "PERSONASDB", null, 1);
		SQLiteDatabase persDBRead = dbHelper.getReadableDatabase();
		if(persDBRead.isOpen()){
			Cursor c = persDBRead.rawQuery("SELECT * FROM PERSONA WHERE _ID="
					+id, null);
			if(c.getCount() > 0){
				c.moveToFirst();
				persona = new Persona(c.getInt(c.getColumnIndex("_ID")),
						c.getString(c.getColumnIndex("NOMBRE")),
						c.getString(c.getColumnIndex("APELLIDO")), 
						c.getString(c.getColumnIndex("TELEFONO")),
						c.getString(c.getColumnIndex("DESCRIPCION")), 
						c.getString(c.getColumnIndex("GRUPO")));
			}
			persDBRead.close();
		}
		return persona;
		
	}
	
	public ArrayList<Persona> findAll(Context contexto, String campo){

		if (campo == null) campo = "_ID";
		ArrayList<Persona> arrayPersonas = new ArrayList<Persona>();
		dbHelper = new DBHelper(contexto, "PERSONASDB", null, 1);
		SQLiteDatabase persDBRead = dbHelper.getReadableDatabase();
		if(persDBRead.isOpen()){
			Cursor c = persDBRead.rawQuery("SELECT * FROM PERSONA ORDER BY "+campo, null);
			if(c.moveToFirst()){
				do{
					arrayPersonas.add(new Persona(c.getInt(c.getColumnIndex("_ID")),
							c.getString(c.getColumnIndex("NOMBRE")),
							c.getString(c.getColumnIndex("APELLIDO")), 
							c.getString(c.getColumnIndex("TELEFONO")),
							c.getString(c.getColumnIndex("DESCRIPCION")), 
							c.getString(c.getColumnIndex("GRUPO"))));
				}while(c.moveToNext());

			}
			persDBRead.close();
		}
		return arrayPersonas;
		
	}
	
	public ArrayList<Persona> find(Context contexto, String campo, String texto){
		ArrayList<Persona> arrayPersonas = new ArrayList<Persona>();
		dbHelper = new DBHelper(contexto, "PERSONASDB", null, 1);
		SQLiteDatabase persDBRead = dbHelper.getReadableDatabase();
		if(persDBRead.isOpen()){
			Cursor c = persDBRead.rawQuery("SELECT * FROM PERSONA WHERE "
											+campo+" LIKE '%"+texto+"%'", null);		
			if(c.moveToFirst()){
				do{
					System.out.println(c.getInt(c.getColumnIndex("_ID")));
					arrayPersonas.add(new Persona(c.getInt(c.getColumnIndex("_ID")),
							c.getString(c.getColumnIndex("NOMBRE")),
							c.getString(c.getColumnIndex("APELLIDO")), 
							c.getString(c.getColumnIndex("TELEFONO")),
							c.getString(c.getColumnIndex("DESCRIPCION")), 
							c.getString(c.getColumnIndex("GRUPO"))));
				}while(c.moveToNext());

			}
			persDBRead.close();
		}
		return arrayPersonas;
		
	}
	
	public void delete(Context contexto, int id){
		dbHelper = new DBHelper(contexto, "PERSONASDB", null, 1);
		SQLiteDatabase persDBWrite = dbHelper.getWritableDatabase();
		if(persDBWrite.isOpen()){
			persDBWrite.execSQL("DELETE FROM PERSONA WHERE _ID='"+id+"'");
			persDBWrite.close();
		}
	}
	
	public void update(Context contexto, int id){
		dbHelper = new DBHelper(contexto, "PERSONASDB", null, 1);
		SQLiteDatabase persDBWrite = dbHelper.getWritableDatabase();
		if(persDBWrite.isOpen()){
			persDBWrite.execSQL("UPDATE PERSONA SET NOMBRE='"+this.nombre+"',"
					+ "APELLIDO='"+this.apellido+"',TELEFONO='"+this.telf+"',"
					+ "DESCRIPCION='"+this.desc+"', GRUPO='"+this.grupo+"'"
					+ " WHERE _ID='"+id+"'");
			persDBWrite.close();
		}
	}

}
