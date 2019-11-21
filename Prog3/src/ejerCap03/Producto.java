package ejerCap03;

import java.util.ArrayList;

public class Producto {
	
	private int id;
	private String nombre;
	private float precio;
	private ArrayList<Compra> listaCompras;
	
	public Producto(int id, String nombre, float precio, ArrayList<Compra> listaCompras) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.listaCompras = listaCompras;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ArrayList<Compra> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(ArrayList<Compra> listaCompras) {
		this.listaCompras = listaCompras;
	}
	
	
	
	

}
