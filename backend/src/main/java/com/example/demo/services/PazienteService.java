package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Paziente;
import com.example.demo.repositories.DataAccessRepo;
import com.example.demo.repositories.PazienteRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class PazienteService implements DataAccessRepo<Paziente> {

	@Autowired
	private EntityManager ent_man;

	@Autowired
	private PazienteRepository patientRepository;

	private Session getSessione() {
		return ent_man.unwrap(Session.class);
	}

	@Override
	@Transactional
	public Paziente insert(Paziente t) {
		Session sessione = this.getSessione();

		try {
			sessione.save(t);
			sessione.flush();
		} catch (Exception e) {
			System.out.println("[ERR]" + e.getMessage());
		} finally {
			sessione.close();
		}

		return t;
	}

	@Override
	@Transactional
	public Paziente findById(int id) {

		Session sessione = this.getSessione();
		Paziente temp = null;

		try {
			temp = sessione.get(Paziente.class, id);
		} catch (Exception e) {
			System.out.println("[ERR]" + e.getMessage());
		} finally {
			sessione.close();
		}

		return temp;

	}

	@Override
	@Transactional
	public boolean delete(int id) {
		Session sessione = this.getSessione();
		boolean risultato = false;

		try {

			Paziente temp = sessione.get(Paziente.class, id);
			System.out.println(temp);
			if(temp != null) {
				sessione.delete(temp);
				sessione.flush();
			}

			risultato = true;
		} catch (Exception e) {
			System.out.println("[ERR]" + e.getMessage());
		} finally {
			sessione.close();
		}

		return risultato;
	}

	@Override
	@Transactional
	public boolean update(Paziente t) {

		Session sessione = this.getSessione();
		boolean risultato = false;

		try {
			Paziente temp = sessione.get(Paziente.class, t.getIdPaziente());

			if(t.getNome() != null)
				temp.setNome(t.getNome());
			if(t.getCognome() != null)
				temp.setCognome(t.getCognome());

			sessione.save(temp);
			sessione.flush();

			risultato = true;
		} catch (Exception e) {
			System.out.println("[ERR]" + e.getMessage());
		} finally {
			sessione.close();
		}

		return risultato;

	}

	@Override
	@Transactional
	public List<Paziente> findAll() {
		Session sessione = this.getSessione();

		List<Paziente> elenco = new ArrayList<Paziente>();

		try {
			elenco = sessione.createQuery("FROM Paziente").list();
		} catch (Exception e) {
			System.out.println("[ERR]" + e.getMessage());
		} finally {
			sessione.close();
		}

		return elenco;
	}

	@Transactional
	public List<Paziente> searchPatients(String Nome, String Cognome, String CodiceFiscale) {
		Nome = Nome.trim();
		Cognome = Cognome.trim();
		CodiceFiscale = CodiceFiscale.trim();
		// Se entrambi i criteri sono vuoti, restituisci tutti i pazienti
		if(Nome == "" && Cognome == "" && CodiceFiscale == "") {
			System.out.println("nome e cognome non lo prende");
			return this.findAll();
		}

		// Se entrambi i criteri sono forniti, esegui una ricerca per nome e cognome e
		// codice fiscale
		if(Nome != "" && Cognome != "" && CodiceFiscale != "") {
			return patientRepository.findByNomeAndCognomeAndCodicefiscale(Nome, Cognome, CodiceFiscale);
		}

		// Se è fornito solo il nome, esegui una ricerca per nome
		if(Nome != "" && Cognome == "" && CodiceFiscale == "") {
			return patientRepository.findByNome(Nome);
		}

		// Se è fornito solo il cognome, esegui una ricerca per cognome
		if(Nome == "" && Cognome != "" && CodiceFiscale == "") {
			return patientRepository.findByCognome(Cognome);
		}

		// Se nessun criterio è fornito, restituisci una lista vuota
		return List.of();
	}
}
