package com.example.listviewfechaasunto;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class Lista_adaptador extends BaseAdapter{
	
	private ArrayList<?> entradas;
	private int R_layout_IdView;
	private Context contexto;
	

	public Lista_adaptador(Context contexto, int R_layout_IdView, ArrayList<?> entradas) {
		super();
		this.entradas = entradas;
		this.R_layout_IdView = R_layout_IdView;
		this.contexto = contexto;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return entradas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return entradas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			LayoutInflater vi = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R_layout_IdView, null);
		}
		onEntrada (entradas.get(position), convertView);
		return convertView;
	}

	public abstract void onEntrada (Object entrada, View view);

}
