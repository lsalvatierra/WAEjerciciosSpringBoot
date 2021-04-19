package edu.pe.idat.model;

public class PromedioFinalForm {

	private Double evacontinua1;
	private Double evacontinua2;
	private Double evacontinua3;
	private Double evafinal;
	public Double getEvacontinua1() {
		return evacontinua1;
	}
	public void setEvacontinua1(Double evacontinua1) {
		this.evacontinua1 = evacontinua1;
	}
	public Double getEvacontinua2() {
		return evacontinua2;
	}
	public void setEvacontinua2(Double evacontinua2) {
		this.evacontinua2 = evacontinua2;
	}
	public Double getEvacontinua3() {
		return evacontinua3;
	}
	public void setEvacontinua3(Double evacontinua3) {
		this.evacontinua3 = evacontinua3;
	}
	public Double getEvafinal() {
		return evafinal;
	}
	public void setEvafinal(Double evafinal) {
		this.evafinal = evafinal;
	}
	public PromedioFinalForm(Double evacontinua1, Double evacontinua2, Double evacontinua3, Double evafinal) {
		super();
		this.evacontinua1 = evacontinua1;
		this.evacontinua2 = evacontinua2;
		this.evacontinua3 = evacontinua3;
		this.evafinal = evafinal;
	}
	public PromedioFinalForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
