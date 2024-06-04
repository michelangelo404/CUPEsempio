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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Paziente;
import com.example.demo.model.Responso;
import com.example.demo.services.PazienteService;

@RestController
@RequestMapping("/paziente")
@CrossOrigin("*")
public class PazienteController {

	@Autowired
	private PazienteService service;

	@GetMapping("/dettaglio/{varId}")
	public Responso<Paziente> getPazientePerId(@PathVariable Integer varId) {
		Responso<Paziente> res = new Responso<Paziente>("success", service.findById(varId));
		return res;
	}

	@GetMapping("/lista")
	public Responso<List<Paziente>> getTuttiPazienti() {
		Responso<List<Paziente>> res = new Responso<List<Paziente>>("success", service.findAll());
		return res;
	}

	@PostMapping("/inserisci")
	public Responso<Paziente> insertPaziente(@RequestBody Paziente objProd) {
		Responso<Paziente> res = new Responso<Paziente>("success", service.insert(objProd));
		return res;
	}

	@DeleteMapping("/elimina/{varId}")
	public Responso<Boolean> deletePaziente(@PathVariable Integer varId) {
		if(service.delete(varId)) {
			System.out.println(varId);
			return new Responso<Boolean>("success", true);
		}

		return new Responso<Boolean>("error", false);
	}

	@PutMapping("/modifica/{varId}")
	public Responso<Boolean> updatePaziente(@PathVariable Integer varId, @RequestBody Paziente objProd) {
		objProd.setIdPaziente(varId);
		if(service.update(objProd))
			return new Responso<Boolean>("success", true);

		return new Responso<Boolean>("error", false);
	}

	@GetMapping("/cerca")
	public Responso<List<Paziente>> getPazientePerNomeCognome(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName, @RequestParam(required = false) String codiceFiscale) {

		Responso<List<Paziente>> res = new Responso<List<Paziente>>("success",
				service.searchPatients(firstName, lastName, codiceFiscale));
		return res;
	}

}
