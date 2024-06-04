package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Prenotazione {

	@Id
	private int Idprenotazione;

	private String DataPrenotazione;
	private String OraPrenotazione;
	private String DataContatto;
	private String Prestazione;
	private String CodicePrestazione;
	private String IdPaziente;

	public int getIdPrenotazione() {
		return Idprenotazione;
	}

	public void setIdPrenotazione(int idPrenotazione) {
		Idprenotazione = idPrenotazione;
	}

	public String getDataPrenotazione() {
		return DataPrenotazione;
	}

	public void setDataPrenotazione(String dataPrenotazione) {
		DataPrenotazione = dataPrenotazione;
	}

	public String getOraPrenotazione() {
		return OraPrenotazione;
	}

	public void setOraPrenotazione(String oraPrenotazione) {
		OraPrenotazione = oraPrenotazione;
	}

	public String getDataContatto() {
		return DataContatto;
	}

	public void setDataContatto(String dataContatto) {
		DataContatto = dataContatto;
	}

	public String getPrestazione() {
		return Prestazione;
	}

	public void setPrestazione(String prestazione) {
		Prestazione = prestazione;
	}

	public String getCodicePrestazione() {
		return CodicePrestazione;
	}

	public void setCodicePrestazione(String codicePrestazione) {
		CodicePrestazione = codicePrestazione;
	}

	public String getIdPaziente() {
		return IdPaziente;
	}

	public void setIdPaziente(String idPaziente) {
		IdPaziente = idPaziente;
	}

}
