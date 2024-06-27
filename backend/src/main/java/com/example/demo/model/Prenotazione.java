package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idprenotazione;

	private String dataprenotazione;
	private String oraprenotazione;
	private String datacontatto;
	private String codiceprestazione;
	private String idpaziente;

	public int getIdprenotazione() {
		return idprenotazione;
	}

	public void setIdprenotazione(int idprenotazione) {
		this.idprenotazione = idprenotazione;
	}

	public String getDataprenotazione() {
		return dataprenotazione;
	}

	public void setDataprenotazione(String dataprenotazione) {
		this.dataprenotazione = dataprenotazione;
	}

	public String getOraprenotazione() {
		return oraprenotazione;
	}

	public void setOraprenotazione(String oraprenotazione) {
		this.oraprenotazione = oraprenotazione;
	}

	public String getDatacontatto() {
		return datacontatto;
	}

	public void setDatacontatto(String datacontatto) {
		this.datacontatto = datacontatto;
	}

	public String getCodiceprestazione() {
		return codiceprestazione;
	}

	public void setCodiceprestazione(String codiceprestazione) {
		this.codiceprestazione = codiceprestazione;
	}

	public String getIdpaziente() {
		return idpaziente;
	}

	public void setIdpaziente(String idpaziente) {
		this.idpaziente = idpaziente;
	}

}
