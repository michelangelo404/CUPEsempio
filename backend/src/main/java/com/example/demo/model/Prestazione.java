package com.example.demo.model;

import jakarta.persistence.Id;

public class Prestazione {

	@Id
	private String CodicePrestazione;
	private String Prestazione;
	private Integer Costo;

	public String getCodicePrestazione() {
		return CodicePrestazione;
	}

	public void setCodicePrestazione(String varId) {
		CodicePrestazione = varId;
	}

	public String getPrestazione() {
		return Prestazione;
	}

	public void setPrestazione(String prestazione) {
		Prestazione = prestazione;
	}

	public Integer getCosto() {
		return Costo;
	}

	public void setCosto(Integer costo) {
		Costo = costo;
	}

}
