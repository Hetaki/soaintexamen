package com.jhuaman.soaint.examen.repository;

import java.util.List;

public interface GenericRepository<T> {

	T create(T t);

	void delete(T t);

	T find(long t);

	T update(T t);

	List<T> findAll();

}
