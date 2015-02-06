package com.example.listviewfechaasunto;

public class lista_entrada {
	private int idImagen;
	private String txtSup;
	private String txtInf;
	
	public lista_entrada(int IdImagen, String txtSup, String txtInf){
		this.idImagen = IdImagen;
		this.txtSup = txtSup;
		this.txtInf = txtInf;
	}

	public int getIdImagen() {
		return idImagen;
	}

	public String getTxtSup() {
		return txtSup;
	}

	public String getTxtInf() {
		return txtInf;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public void setTxtSup(String txtSup) {
		this.txtSup = txtSup;
	}

	public void setTxtInf(String txtInf) {
		this.txtInf = txtInf;
	}
	
	
}
