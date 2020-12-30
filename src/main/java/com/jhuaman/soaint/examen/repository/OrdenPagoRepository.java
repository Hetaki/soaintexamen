package com.jhuaman.soaint.examen.repository;

import java.util.List;

import javax.persistence.Query;

import com.jhuaman.soaint.examen.model.OrdenPago;
import com.jhuaman.soaint.examen.utils.Utilitario;

public class OrdenPagoRepository extends GenericRepositoryJPA<OrdenPago> {

	public long createId(OrdenPago t) {
		entityManager.getTransaction().begin();
		t = entityManager.merge(t);
		entityManager.flush();
		entityManager.getTransaction().commit();
		return t.getIdOrdenPago();
	}

	@SuppressWarnings("unchecked")
	public List<OrdenPago> listarOrdenesxSucursal(long idSucursal, String codMoneda) {
		String strQuery = "SELECT o.* FROM OrdenPago o INNER JOIN SucursalOrdenPago s ON o.idOrdenPago=s.idOrdenPago WHERE s.idSucursal = ?1 ";
		if (!Utilitario.isEmpty(codMoneda)) {
			strQuery += " AND o.moneda = ?2 ";
		}
		Query query = this.entityManager.createNativeQuery(strQuery, OrdenPago.class);
		query.setParameter(1, idSucursal);
		if (!Utilitario.isEmpty(codMoneda)) {
			query.setParameter(2, codMoneda);
		}
		return query.getResultList();
	}

}
