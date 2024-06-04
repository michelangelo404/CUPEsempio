package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Paziente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Idpaziente;

	private String nome;
	private String cognome;
	private String Datanascita;
	private String codicefiscale;

	public int getIdPaziente() {
		return Idpaziente;
	}

	public void setIdPaziente(int idPaziente) {
		Idpaziente = idPaziente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return Datanascita;
	}

	public void setDataNascita(String dataNascita) {
		Datanascita = dataNascita;
	}

	public String getCodiceFiscale() {
		return codicefiscale;
	}

	public void setCodiceFiscale(String Codicefiscale) {
		this.codicefiscale = Codicefiscale;
	}

}