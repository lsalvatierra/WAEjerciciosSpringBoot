package edu.pe.idat.model;

public class VentaProducto {
	
	private String codProducto;
	private String nomProducto;
	private Double cantidadTotal;
	private Double precioTotal;
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
	public Double getCantidadTotal() {
		return cantidadTotal;
	}
	public void setCantidadTotal(Double cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}
	public Double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public VentaProducto(String codProducto, String nomProducto, Double cantidadTotal, Double precioTotal) {
		super();
		this.codProducto = codProducto;
		this.nomProducto = nomProducto;
		this.cantidadTotal = cantidadTotal;
		this.precioTotal = precioTotal;
	}
	public VentaProducto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
