package com.jhuaman.soaint.examen.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.jhuaman.soaint.examen.service.OrdenPagoService;
import com.jhuaman.soaint.examen.service.OrdenPagoServiceImpl;
import com.jhuaman.soaint.examen.utils.Utilitario;
import com.jhuaman.soaint.examen.vo.OrdenPagoVO;
import com.jhuaman.soaint.examen.vo.RespuestaVO;

@Path("/ordenpago")
@Produces("application/json")
@Consumes("application/json")
public class OrdenPagoRestService {

	OrdenPagoService ordenPagoService = new OrdenPagoServiceImpl();

	@GET
	public RespuestaVO<List<OrdenPagoVO>> listar() {
		RespuestaVO<List<OrdenPagoVO>> respuesta = new RespuestaVO<>(false, "Lista vacia");
		List<OrdenPagoVO> ordenPagos = ordenPagoService.findAll();

		if (!Utilitario.isEmpty(ordenPagos)) {
			respuesta = new RespuestaVO<>(ordenPagos);
		}

		return respuesta;
	}

	@GET
	@Path("/{idOrdenPago}")
	public RespuestaVO<OrdenPagoVO> obtener(@PathParam("idOrdenPago") long idOrdenPago) {
		RespuestaVO<OrdenPagoVO> respuesta = new RespuestaVO<>(false, "Objeto vacia");
		OrdenPagoVO ordenPago = ordenPagoService.find(idOrdenPago);

		if (!Utilitario.isEmpty(ordenPago)) {
			respuesta = new RespuestaVO<>(ordenPago);
		}
		return respuesta;
	}

	@POST
	public RespuestaVO<OrdenPagoVO> guardar(OrdenPagoVO ordenPago) {
		return ordenPagoService.create(ordenPago);
	}

	@PUT
	@Path("/{idOrdenPago}")
	public RespuestaVO<OrdenPagoVO> actualizar(@PathParam("idOrdenPago") long idOrdenPago, OrdenPagoVO ordenPago) {
		return ordenPagoService.update(idOrdenPago, ordenPago);
	}

	@DELETE
	@Path("/{idOrdenPago}")
	public RespuestaVO<OrdenPagoVO> eliminar(@PathParam("idOrdenPago") long idOrdenPago) {
		return ordenPagoService.delete(idOrdenPago);
	}

}
