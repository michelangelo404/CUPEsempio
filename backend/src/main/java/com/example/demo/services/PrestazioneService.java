package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Prestazione;
import com.example.demo.repositories.DataAccessRepo;

@Service
public class PrestazioneService implements DataAccessRepo<Prestazione> {

	@Override
	public Prestazione insert(Prestazione t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prestazione findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prestazione> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Prestazione t) {
		// TODO Auto-generated method stub
		return false;
	}

}
