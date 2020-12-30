package com.jhuaman.soaint.examen.repository;

import java.util.List;

import javax.persistence.Query;

import com.jhuaman.soaint.examen.model.SucursalOrdenPago;

public class SucursalOrdenPagoRepository extends GenericRepositoryJPA<SucursalOrdenPago> {

	@SuppressWarnings("unchecked")
	public List<SucursalOrdenPago> listarDetalle(long idOrdenPago) {
		String strQuery = "SELECT o.* FROM SucursalOrdenPago o WHERE o.idOrdenPago = ?1 ";
		Query query = this.entityManager.createNativeQuery(strQuery, SucursalOrdenPago.class);
		query.setParameter(1, idOrdenPago);
		return query.getResultList();
	}

}
