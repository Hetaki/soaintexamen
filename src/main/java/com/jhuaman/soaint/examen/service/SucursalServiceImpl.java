package com.jhuaman.soaint.examen.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.jhuaman.soaint.examen.model.Sucursal;
import com.jhuaman.soaint.examen.repository.SucursalRepository;
import com.jhuaman.soaint.examen.utils.Utilitario;
import com.jhuaman.soaint.examen.vo.RespuestaVO;
import com.jhuaman.soaint.examen.vo.SucursalVO;

public class SucursalServiceImpl implements SucursalService {

	BancoService bancoService = new BancoServiceImpl();
	
	@Override
	@Transactional(rollbackOn=Exception.class)
	public RespuestaVO<SucursalVO> create(SucursalVO t) {
		if (Utilitario.isEmpty(t.getDireccion())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'direccion'");
		}
		if (Utilitario.isEmpty(t.getNombre())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'nombre'");
		}
		SucursalRepository sucursalRepository = new SucursalRepository();
		Sucursal sucursal = new Sucursal();
		sucursal.setDireccion(t.getDireccion());
		sucursal.setFecRegistro(new Date());
		sucursal.setNombre(t.getNombre());
		sucursal.setIdBanco(t.getIdBanco());

		sucursalRepository.create(sucursal);

		return new RespuestaVO<>(true, "Se registro con \u00e9xito");
	}

	@Override
	public RespuestaVO<SucursalVO> delete(long id) {
		return new RespuestaVO<>(true, "Se elimino con \u00e9xito");
	}

	@Override
	public SucursalVO find(long idSucursal) {
		SucursalRepository sucursalRepository = new SucursalRepository();
		Sucursal sucursal = sucursalRepository.find(idSucursal);
		SucursalVO sucursalVO = new SucursalVO();
		sucursalVO.setDireccion(sucursal.getDireccion());
		sucursalVO.setIdSucursal(sucursal.getIdSucursal());
		sucursalVO.setNombre(sucursal.getNombre());
		sucursalVO.setIdBanco(sucursal.getIdBanco());
		sucursalVO.setFecRegistro(Utilitario.dateToStringDDMMYYYY(sucursal.getFecRegistro()));
		sucursalVO.setBanco(bancoService.find(sucursal.getIdBanco()));
		return sucursalVO;
	}

	@Override
	public RespuestaVO<SucursalVO> update(long id, SucursalVO t) {
		if (Utilitario.isEmpty(t.getDireccion())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'direccion'");
		}
		if (Utilitario.isEmpty(t.getNombre())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'nombre'");
		}
		SucursalRepository sucursalRepository = new SucursalRepository();
		Sucursal sucursal = sucursalRepository.find(id);
		sucursal.setDireccion(t.getDireccion());
		sucursal.setNombre(t.getNombre());
		sucursal.setIdBanco(t.getIdBanco());

		sucursalRepository.update(sucursal);

		return new RespuestaVO<>(true, "Se actualizo con \u00e9xito");
	}

	@Override
	public List<SucursalVO> findAll() {
		SucursalRepository sucursalRepository = new SucursalRepository();
		List<Sucursal> sucursals = sucursalRepository.findAll();

		List<SucursalVO> respuesta = new ArrayList<SucursalVO>();
		for (Sucursal sucursal : sucursals) {
			SucursalVO sucursalVO = new SucursalVO();
			sucursalVO.setDireccion(sucursal.getDireccion());
			sucursalVO.setIdSucursal(sucursal.getIdSucursal());
			sucursalVO.setNombre(sucursal.getNombre());
			sucursalVO.setFecRegistro(Utilitario.dateToStringDDMMYYYY(sucursal.getFecRegistro()));
			sucursalVO.setIdBanco(sucursal.getIdBanco());
			sucursalVO.setBanco(bancoService.find(sucursal.getIdBanco()));
			respuesta.add(sucursalVO);
		}
		return respuesta;
	}

	@Override
	public List<SucursalVO> listarXbanco(long idBanco) {
		SucursalRepository sucursalRepository = new SucursalRepository();
		List<Sucursal> sucursals = sucursalRepository.listarXbanco(idBanco);

		List<SucursalVO> respuesta = new ArrayList<SucursalVO>();
		for (Sucursal sucursal : sucursals) {
			SucursalVO sucursalVO = new SucursalVO();
			sucursalVO.setDireccion(sucursal.getDireccion());
			sucursalVO.setIdSucursal(sucursal.getIdSucursal());
			sucursalVO.setNombre(sucursal.getNombre());
			sucursalVO.setFecRegistro(Utilitario.dateToStringDDMMYYYY(sucursal.getFecRegistro()));
			sucursalVO.setIdBanco(sucursal.getIdBanco());
			sucursalVO.setBanco(bancoService.find(sucursal.getIdBanco()));
			respuesta.add(sucursalVO);
		}
		return respuesta;
	}

}
