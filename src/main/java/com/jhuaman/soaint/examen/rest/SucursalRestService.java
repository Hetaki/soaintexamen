package com.jhuaman.soaint.examen.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.jhuaman.soaint.examen.service.OrdenPagoService;
import com.jhuaman.soaint.examen.service.OrdenPagoServiceImpl;
import com.jhuaman.soaint.examen.service.SucursalService;
import com.jhuaman.soaint.examen.service.SucursalServiceImpl;
import com.jhuaman.soaint.examen.utils.Utilitario;
import com.jhuaman.soaint.examen.vo.SucursalVO;
import com.jhuaman.soaint.examen.vo.OrdenPagoVO;
import com.jhuaman.soaint.examen.vo.RespuestaVO;


@Path("/sucursal")
@Produces("application/json")
@Consumes("application/json")
public class SucursalRestService {

	SucursalService sucursalService = new SucursalServiceImpl();
	OrdenPagoService ordenPagoService = new OrdenPagoServiceImpl();

	@GET
	public RespuestaVO<List<SucursalVO>> listar() {
		RespuestaVO<List<SucursalVO>> respuesta = new RespuestaVO<>(false, "Lista vacia");
		List<SucursalVO> sucursals = sucursalService.findAll();

		if (!Utilitario.isEmpty(sucursals)) {
			respuesta = new RespuestaVO<>(sucursals);
		}

		return respuesta;
	}

	@GET
	@Path("/{idSucursal}")
	public RespuestaVO<SucursalVO> obtener(@PathParam("idSucursal") long idSucursal) {
		RespuestaVO<SucursalVO> respuesta = new RespuestaVO<>(false, "Objeto vacia");
		SucursalVO sucursal = sucursalService.find(idSucursal);

		if (!Utilitario.isEmpty(sucursal)) {
			respuesta = new RespuestaVO<>(sucursal);
		}
		return respuesta;
	}

	@POST
	public RespuestaVO<SucursalVO> guardar(SucursalVO sucursal) {
		return sucursalService.create(sucursal);
	}

	@PUT
	@Path("/{idSucursal}")
	public RespuestaVO<SucursalVO> actualizar(@PathParam("idSucursal") long idSucursal, SucursalVO sucursal) {
		return sucursalService.update(idSucursal, sucursal);
	}

	@GET
	@Path("/{idSucursal}/ordenes")
	public RespuestaVO<List<OrdenPagoVO>> ordenes(@PathParam("idSucursal") long idSucursal, @QueryParam("codMoneda") String codMoneda) {
		RespuestaVO<List<OrdenPagoVO>> respuesta = new RespuestaVO<>(false, "Lista vacia");
		List<OrdenPagoVO> ordenes = ordenPagoService.listarOrdenesxSucursal(idSucursal, codMoneda);

		if (!Utilitario.isEmpty(ordenes)) {
			respuesta = new RespuestaVO<>(ordenes);
		}
		return respuesta;
	}

}
