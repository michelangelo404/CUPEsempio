package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Prenotazione;
import com.example.demo.repositories.DataAccessRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class PrenotazioneService implements DataAccessRepo<Prenotazione> {

	@Autowired
	private EntityManager ent_man;

	private Session getSessione() {
		return ent_man.unwrap(Session.class);
	}

	@Override
	@Transactional
	public Prenotazione insert(Prenotazione t) {
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
	public Prenotazione findById(int id) {

		Session sessione = this.getSessione();
		Prenotazione temp = null;

		try {
			temp = sessione.get(Prenotazione.class, id);
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

			Prenotazione temp = sessione.get(Prenotazione.class, id);
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
	public boolean update(Prenotazione t) {

		Session sessione = this.getSessione();
		boolean risultato = false;

		try {
			Prenotazione temp = sessione.get(Prenotazione.class, t.getIdPrenotazione());

			if(t.getDataPrenotazione() != null)
				temp.setDataPrenotazione(t.getDataPrenotazione());
			if(t.getOraPrenotazione() != null)
				temp.setOraPrenotazione(t.getOraPrenotazione());

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
	public List<Prenotazione> findAll() {
		Session sessione = this.getSessione();

		List<Prenotazione> elenco = new ArrayList<Prenotazione>();

		try {
			elenco = sessione.createQuery("FROM Prenotazione").list();
		} catch (Exception e) {
			System.out.println("[ERR]" + e.getMessage());
		} finally {
			sessione.close();
		}

		return elenco;
	}

}
