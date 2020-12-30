package com.jhuaman.soaint.examen.repository;

import java.util.List;

import javax.persistence.Query;

import com.jhuaman.soaint.examen.model.Sucursal;

public class SucursalRepository extends GenericRepositoryJPA<Sucursal> {

	@SuppressWarnings("unchecked")
	public List<Sucursal> listarXbanco(long idBanco) {
		String strQuery = "SELECT o.* FROM Sucursal o WHERE o.idBanco = ?1 ";
		Query query = this.entityManager.createNativeQuery(strQuery, Sucursal.class);
		query.setParameter(1, idBanco);
		return query.getResultList();
	}

}
