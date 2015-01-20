package com.example.guardarpersonas;

import java.io.Serializable;

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
	
	public Persona(String nombre, String apellido, String telf, String desc)
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.telf=telf;
		this.desc=desc;
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

}
