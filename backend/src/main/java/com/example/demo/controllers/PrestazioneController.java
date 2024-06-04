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

import com.example.demo.model.Prestazione;
import com.example.demo.model.Responso;
import com.example.demo.services.PrestazioneService;

@RestController
@RequestMapping("/prestazione")
@CrossOrigin("*")
public class PrestazioneController {

	@Autowired
	private PrestazioneService service;

	@GetMapping("/dettaglio/{varId}")
	public Responso<Prestazione> getPrestazionePerId(@PathVariable Integer varId) {
		Responso<Prestazione> res = new Responso("success", service.findById(varId));
		return res;
	}

	@GetMapping("/lista")
	public Responso<List<Prestazione>> getTuttePrestazioni() {
		Responso res = new Responso("success", service.findAll());
		return res;
	}

	@PostMapping("/inserisci")
	public Responso<Prestazione> insertPrestazione(@RequestBody Prestazione objProd) {
		Responso res = new Responso("success", service.insert(objProd));
		return res;
	}

	@DeleteMapping("/elimina/{varId}")
	public Responso<Boolean> deletePrestazione(@PathVariable Integer varId) {
		if(service.delete(varId)) {
			System.out.println(varId);
			return new Responso<Boolean>("success", true);
		}

		return new Responso<Boolean>("error", false);
	}

	@PutMapping("/modifica/{varId}")
	public Responso<Boolean> updatePrestazione(@PathVariable String varId, @RequestBody Prestazione objProd) {
		objProd.setCodicePrestazione(varId);
		if(service.update(objProd))
			return new Responso<Boolean>("success", true);

		return new Responso<Boolean>("error", false);
	}

}
