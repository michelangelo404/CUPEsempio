package com.example.demo.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface DataAccessRepo<T> {

	T insert(T t);

	T findById(int id);

	List<T> findAll();

	boolean delete(int id);

	boolean update(T t);

}
