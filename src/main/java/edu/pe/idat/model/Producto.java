package edu.pe.idat.model;

public class Producto {
	
	private String codProducto;
	private String nomProducto;
	private Double precioProducto;
	public String getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}
	public String getNomProducto() {
		return nomProducto;
	}
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	public Double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}
	public Producto(String codProducto, String nomProducto, Double precioProducto) {
		super();
		this.codProducto = codProducto;
		this.nomProducto = nomProducto;
		this.precioProducto = precioProducto;
	}
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
