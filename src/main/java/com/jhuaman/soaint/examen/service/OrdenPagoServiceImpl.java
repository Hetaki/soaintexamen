package com.jhuaman.soaint.examen.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.jhuaman.soaint.examen.model.OrdenPago;
import com.jhuaman.soaint.examen.model.SucursalOrdenPago;
import com.jhuaman.soaint.examen.repository.OrdenPagoRepository;
import com.jhuaman.soaint.examen.repository.SucursalOrdenPagoRepository;
import com.jhuaman.soaint.examen.utils.EnumEstadoPago;
import com.jhuaman.soaint.examen.utils.EnumMoneda;
import com.jhuaman.soaint.examen.utils.Utilitario;
import com.jhuaman.soaint.examen.vo.OrdenPagoVO;
import com.jhuaman.soaint.examen.vo.RespuestaVO;
import com.jhuaman.soaint.examen.vo.SucursalVO;

public class OrdenPagoServiceImpl implements OrdenPagoService {

	SucursalService sucursalService = new SucursalServiceImpl();
	
	@Override
	public RespuestaVO<OrdenPagoVO> create(OrdenPagoVO t) {
		if (Utilitario.isEmpty(t.getCodMoneda())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'codMoneda'");
		}
		if (Utilitario.isEmpty(t.getCodEstado())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'codEstado'");
		}
		if (Utilitario.isEmpty(t.getMonto())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'monto'");
		}
		SucursalOrdenPagoRepository ordenRepository = new SucursalOrdenPagoRepository();
		OrdenPagoRepository repository = new OrdenPagoRepository();
		OrdenPago model = new OrdenPago();
		model.setFecPago(new Date());
		model.setMoneda(t.getCodMoneda());
		model.setCodEstado(t.getCodEstado());
		model.setMonto(t.getMonto());

		long idOrdenPago = repository.createId(model);

		if (!Utilitario.isEmpty(t.getSucursales())) {
			for (SucursalVO sucursal : t.getSucursales()) {
				SucursalOrdenPago ordenPago = new SucursalOrdenPago();
				ordenPago.setIdSucursal(sucursal.getIdSucursal());
				ordenPago.setIdOrdenPago(idOrdenPago);
				ordenRepository.create(ordenPago);
			}
		}

		return new RespuestaVO<>(true, "Se registr\u00f3 con \u00e9xito");
	}

	@Override
	public RespuestaVO<OrdenPagoVO> delete(long id) {
		OrdenPagoRepository ordenRepository = new OrdenPagoRepository();
		SucursalOrdenPagoRepository detalleRepository = new SucursalOrdenPagoRepository();
		List<SucursalOrdenPago> detalle = detalleRepository.listarDetalle(id);
		if (!Utilitario.isEmpty(detalle)) {
			for (SucursalOrdenPago sucursalOrdenPago : detalle) {
				detalleRepository.delete(sucursalOrdenPago);
			}
		}
		OrdenPago orden = new OrdenPago();
		orden.setIdOrdenPago(id);
		ordenRepository.delete(orden);
		return new RespuestaVO<>(true, "Se elimin\u00f3 con \u00e9xito");
	}

	@Override
	public OrdenPagoVO find(long idOrdenPago) {
		SucursalOrdenPagoRepository detalleRepository = new SucursalOrdenPagoRepository();
		OrdenPagoRepository ordenRepository = new OrdenPagoRepository();
		OrdenPago orden = ordenRepository.find(idOrdenPago);
		OrdenPagoVO ordenVO = new OrdenPagoVO();
		ordenVO.setCodEstado(orden.getCodEstado());
		ordenVO.setDesEstado(EnumEstadoPago.getByCodigo(orden.getCodEstado()).getDescripcion());
		ordenVO.setDesMoneda(EnumMoneda.getByCodigo(orden.getMoneda()).getDescripcion());
		ordenVO.setCodMoneda(orden.getMoneda());
		ordenVO.setMonto(orden.getMonto());
		ordenVO.setFecPago(Utilitario.dateToStringDDMMYYYY(orden.getFecPago()));
		ordenVO.setIdOrdenPago(orden.getIdOrdenPago());

		ordenVO.setSucursales(new ArrayList<>());
		List<SucursalOrdenPago> detalle = detalleRepository.listarDetalle(orden.getIdOrdenPago());
		if (!Utilitario.isEmpty(detalle)) {
			for (SucursalOrdenPago sucursalOrdenPago : detalle) {
				ordenVO.getSucursales().add(sucursalService.find(sucursalOrdenPago.getIdSucursal()));
			}
		}

		return ordenVO;
	}

	@Override
	@Transactional(rollbackOn=Exception.class)
	public RespuestaVO<OrdenPagoVO> update(long id, OrdenPagoVO t) {
		if (Utilitario.isEmpty(t.getCodMoneda())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'codMoneda'");
		}
		if (Utilitario.isEmpty(t.getCodEstado())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'codEstado'");
		}
		if (Utilitario.isEmpty(t.getMonto())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'monto'");
		}
		SucursalOrdenPagoRepository detalleRepository = new SucursalOrdenPagoRepository();
		OrdenPagoRepository ordenRepository = new OrdenPagoRepository();
		OrdenPago model = ordenRepository.find(id);
		model.setFecPago(new Date());
		model.setMoneda(t.getCodMoneda());
		model.setCodEstado(t.getCodEstado());
		model.setMonto(t.getMonto());

		ordenRepository.update(model);

		if (!Utilitario.isEmpty(t.getSucursales())) {
			List<SucursalOrdenPago> detalle = detalleRepository.listarDetalle(model.getIdOrdenPago());
			if (!Utilitario.isEmpty(detalle)) {
				for (SucursalOrdenPago sucursalOrdenPago : detalle) {
					detalleRepository.delete(sucursalOrdenPago);
				}
			}
			for (SucursalVO sucursal : t.getSucursales()) {
				SucursalOrdenPago ordenPago = new SucursalOrdenPago();
				ordenPago.setIdSucursal(sucursal.getIdSucursal());
				ordenPago.setIdOrdenPago(model.getIdOrdenPago());
				detalleRepository.create(ordenPago);
			}
		}

		return new RespuestaVO<>(true, "Se actualiz\u00f3 con \u00e9xito");
	}

	@Override
	public List<OrdenPagoVO> findAll() {
		SucursalOrdenPagoRepository detalleRepository = new SucursalOrdenPagoRepository();
		OrdenPagoRepository ordenRepository = new OrdenPagoRepository();
		List<OrdenPago> ordens = ordenRepository.findAll();

		List<OrdenPagoVO> respuesta = new ArrayList<OrdenPagoVO>();
		for (OrdenPago orden : ordens) {
			OrdenPagoVO ordenVO = new OrdenPagoVO();
			ordenVO.setCodEstado(orden.getCodEstado());
			ordenVO.setCodMoneda(orden.getMoneda());
			ordenVO.setMonto(orden.getMonto());
			ordenVO.setFecPago(Utilitario.dateToStringDDMMYYYY(orden.getFecPago()));
			ordenVO.setIdOrdenPago(orden.getIdOrdenPago());
			ordenVO.setDesEstado(EnumEstadoPago.getByCodigo(orden.getCodEstado()).getDescripcion());
			ordenVO.setDesMoneda(EnumMoneda.getByCodigo(orden.getMoneda()).getDescripcion());

			ordenVO.setSucursales(new ArrayList<>());
			List<SucursalOrdenPago> detalle = detalleRepository.listarDetalle(orden.getIdOrdenPago());
			if (!Utilitario.isEmpty(detalle)) {
				for (SucursalOrdenPago sucursalOrdenPago : detalle) {
					ordenVO.getSucursales().add(sucursalService.find(sucursalOrdenPago.getIdSucursal()));
				}
			}
			respuesta.add(ordenVO);
		}
		return respuesta;
	}

	@Override
	public List<OrdenPagoVO> listarOrdenesxSucursal(long idSucursal, String codMoneda) {
		SucursalOrdenPagoRepository detalleRepository = new SucursalOrdenPagoRepository();
		OrdenPagoRepository repository = new OrdenPagoRepository();
		List<OrdenPago> ordens = repository.listarOrdenesxSucursal(idSucursal, codMoneda);
		List<OrdenPagoVO> respuesta = new ArrayList<OrdenPagoVO>();
		for (OrdenPago orden : ordens) {
			OrdenPagoVO ordenVO = new OrdenPagoVO();
			ordenVO.setCodEstado(orden.getCodEstado());
			ordenVO.setCodMoneda(orden.getMoneda());
			ordenVO.setMonto(orden.getMonto());
			ordenVO.setFecPago(Utilitario.dateToStringDDMMYYYY(orden.getFecPago()));
			ordenVO.setIdOrdenPago(orden.getIdOrdenPago());
			ordenVO.setDesEstado(EnumEstadoPago.getByCodigo(orden.getCodEstado()).getDescripcion());
			ordenVO.setDesMoneda(EnumMoneda.getByCodigo(orden.getMoneda()).getDescripcion());

			ordenVO.setSucursales(new ArrayList<>());
			List<SucursalOrdenPago> detalle = detalleRepository.listarDetalle(orden.getIdOrdenPago());
			if (!Utilitario.isEmpty(detalle)) {
				for (SucursalOrdenPago sucursalOrdenPago : detalle) {
					ordenVO.getSucursales().add(sucursalService.find(sucursalOrdenPago.getIdSucursal()));
				}
			}
			respuesta.add(ordenVO);
		}
		return respuesta;
	}

}
