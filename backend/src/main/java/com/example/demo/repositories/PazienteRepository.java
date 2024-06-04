package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Paziente;

@Repository
public interface PazienteRepository extends JpaRepository<Paziente, Long> {

	List<Paziente> findByNomeAndCognomeAndCodicefiscale(String Nome, String Cognome, String Codicefiscale);

	List<Paziente> findByNome(String Nome);

	List<Paziente> findByCognome(String Cognome);

}
