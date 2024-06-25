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
	private String datanascita;
	private String codicefiscale;

	public int getIdpaziente() {
		return Idpaziente;
	}

	public void setIdpaziente(int idpaziente) {
		Idpaziente = idpaziente;
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

	public String getDatanascita() {
		return datanascita;
	}

	public void setDatanascita(String datanascita) {
		this.datanascita = datanascita;
	}

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

}