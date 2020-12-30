package com.jhuaman.soaint.examen.rest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.jhuaman.soaint.examen.ejercicio.MoneyParts;

@Path("/moneypart")
@Produces("application/json")
@Consumes("application/json")
public class EjercicioRestService {

	@GET
	public Set<List<BigDecimal>> sucursales(@QueryParam("monto") String monto) {
		return MoneyParts.build(monto);
	}

}
