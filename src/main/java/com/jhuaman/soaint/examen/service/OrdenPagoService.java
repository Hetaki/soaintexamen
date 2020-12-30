package com.jhuaman.soaint.examen.service;

import java.util.List;

import com.jhuaman.soaint.examen.vo.OrdenPagoVO;

public interface OrdenPagoService extends GenericService<OrdenPagoVO> {

	List<OrdenPagoVO> listarOrdenesxSucursal(long idSucursal, String codMoneda);

}
