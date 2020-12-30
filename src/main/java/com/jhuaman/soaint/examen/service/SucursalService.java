package com.jhuaman.soaint.examen.service;

import java.util.List;

import com.jhuaman.soaint.examen.vo.SucursalVO;

public interface SucursalService extends GenericService<SucursalVO> {

	List<SucursalVO> listarXbanco(long idBanco);

}
