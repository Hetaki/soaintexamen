package com.jhuaman.soaint.examen.service;

import java.util.List;

import com.jhuaman.soaint.examen.vo.RespuestaVO;

public interface GenericService<T> {

	RespuestaVO<T> create(T t);

	RespuestaVO<T> delete(long id);

	T find(long id);

	RespuestaVO<T> update(long id, T t);

	List<T> findAll();

}
