package com.jhuaman.soaint.examen.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.jhuaman.soaint.examen.service.BancoService;
import com.jhuaman.soaint.examen.service.BancoServiceImpl;
import com.jhuaman.soaint.examen.service.SucursalService;
import com.jhuaman.soaint.examen.service.SucursalServiceImpl;
import com.jhuaman.soaint.examen.utils.Utilitario;
import com.jhuaman.soaint.examen.vo.BancoVO;
import com.jhuaman.soaint.examen.vo.RespuestaVO;
import com.jhuaman.soaint.examen.vo.SucursalVO;


@Path("/banco")
@Produces("application/json")
@Consumes("application/json")
public class BancoRestService {

	BancoService bancoService = new BancoServiceImpl();
	SucursalService sucursalService = new SucursalServiceImpl();

	@GET
	public RespuestaVO<List<BancoVO>> listar() {
		RespuestaVO<List<BancoVO>> respuesta = new RespuestaVO<>(false, "Lista vacia");
		List<BancoVO> bancos = bancoService.findAll();

		if (!Utilitario.isEmpty(bancos)) {
			respuesta = new RespuestaVO<>(bancos);
		}

		return respuesta;
	}

	@GET
	@Path("/{idBanco}")
	public RespuestaVO<BancoVO> obtener(@PathParam("idBanco") long idBanco) {
		RespuestaVO<BancoVO> respuesta = new RespuestaVO<>(false, "Objeto vacia");
		BancoVO banco = bancoService.find(idBanco);

		if (!Utilitario.isEmpty(banco)) {
			respuesta = new RespuestaVO<>(banco);
		}
		return respuesta;
	}

	@POST
	public RespuestaVO<BancoVO> guardar(BancoVO banco) {
		return bancoService.create(banco);
	}

	@PUT
	@Path("/{idBanco}")
	public RespuestaVO<BancoVO> actualizar(@PathParam("idBanco") long idBanco, BancoVO banco) {
		return bancoService.update(idBanco, banco);
	}

	@GET
	@Path("/{idBanco}/sucursales")
	public RespuestaVO<List<SucursalVO>> sucursales(@PathParam("idBanco") long idBanco) {
		RespuestaVO<List<SucursalVO>> respuesta = new RespuestaVO<>(false, "Lista vacia");
		List<SucursalVO> sucursals = sucursalService.listarXbanco(idBanco);

		if (!Utilitario.isEmpty(sucursals)) {
			respuesta = new RespuestaVO<>(sucursals);
		}

		return respuesta;
	}

}
