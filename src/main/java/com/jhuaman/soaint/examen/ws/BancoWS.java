package com.jhuaman.soaint.examen.ws;

import java.util.List;

import javax.jws.WebService;

import com.jhuaman.soaint.examen.vo.SucursalVO;

@WebService
public interface BancoWS {

	List<SucursalVO> sucursales(long idBanco);

}
