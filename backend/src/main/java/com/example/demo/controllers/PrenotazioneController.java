package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Prenotazione;
import com.example.demo.model.Responso;
import com.example.demo.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazione")
@CrossOrigin("*")
public class PrenotazioneController {

	@Autowired
	private PrenotazioneService service;

	@GetMapping("/dettaglio/{varId}")
	public Responso<Prenotazione> getPrenotazionePerId(@PathVariable Integer varId) {
		Responso<Prenotazione> res = new Responso("success", service.findById(varId));
		return res;
	}

	@GetMapping("/lista")
	public Responso<List<Prenotazione>> getTuttePrenotazioni() {
		Responso res = new Responso("success", service.findAll());
		return res;
	}

	@PostMapping("/inserisci")
	public Responso<Prenotazione> insertPrenotazione(@RequestBody Prenotazione objProd) {
		Responso res = new Responso("success", service.insert(objProd));
		return res;
	}

	@DeleteMapping("/elimina/{varId}")
	public Responso<Boolean> deletePrenotazione(@PathVariable Integer varId) {
		if(service.delete(varId)) {
			System.out.println(varId);
			return new Responso<Boolean>("success", true);
		}

		return new Responso<Boolean>("error", false);
	}

	@PutMapping("/modifica/{varId}")
	public Responso<Boolean> updatePrenotazione(@PathVariable Integer varId, @RequestBody Prenotazione objProd) {
		objProd.setIdPrenotazione(varId);
		if(service.update(objProd))
			return new Responso<Boolean>("success", true);

		return new Responso<Boolean>("error", false);
	}

}
