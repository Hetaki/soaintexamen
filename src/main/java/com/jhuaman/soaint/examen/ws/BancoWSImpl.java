package com.jhuaman.soaint.examen.ws;

import java.util.List;

import com.jhuaman.soaint.examen.service.SucursalService;
import com.jhuaman.soaint.examen.service.SucursalServiceImpl;
import com.jhuaman.soaint.examen.vo.SucursalVO;

public class BancoWSImpl implements BancoWS {

	SucursalService sucursalService = new SucursalServiceImpl();

	@Override
	public List<SucursalVO> sucursales(long idBanco) {
		return sucursalService.listarXbanco(idBanco);
	}

}
