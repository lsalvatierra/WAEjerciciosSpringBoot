package edu.pe.idat.model;

public class ImcForm {

	private Double talla;
	private Double peso;
	public Double getTalla() {
		return talla;
	}
	public void setTalla(Double talla) {
		this.talla = talla;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public ImcForm(Double talla, Double peso) {
		super();
		this.talla = talla;
		this.peso = peso;
	}
	public ImcForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
