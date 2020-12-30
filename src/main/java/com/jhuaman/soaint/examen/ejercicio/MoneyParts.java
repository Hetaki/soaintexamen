package com.jhuaman.soaint.examen.ejercicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MoneyParts {

	static final String[] DENOMINACIONES = { "0.05", "0.1", "0.2", "0.5", "1", "2", "5", "10", "20", "50", "100", "200" };
	static final List<BigDecimal> BIG_DENOMINACIONES = new ArrayList<BigDecimal>();

	static {
		for (String strDenominacion : DENOMINACIONES) {
			BIG_DENOMINACIONES.add(new BigDecimal(strDenominacion));	
		}
	}

	public static Set<List<BigDecimal>> build(String monto) {
		final BigDecimal bigMonto = new BigDecimal(monto);

		List<BigDecimal> listDenominacion = BIG_DENOMINACIONES.stream().filter(m -> m.compareTo(bigMonto) <= 0).collect(Collectors.toList());

		Set<Set<BigDecimal>> agrupacion = new HashSet<>();

		// Agrupar denominaciones menores que el monto enviado
		for (BigDecimal bigDecimal : listDenominacion) {
			Set<BigDecimal> grupo = new HashSet<>();
			grupo.add(bigDecimal);
			agrupacion.add(new HashSet<>(grupo));
			for (BigDecimal bigDecimal2 : listDenominacion) {
				grupo.add(bigDecimal2);
				agrupacion.add(new HashSet<>(grupo));
			}
		}

		// Obtener agrupacion que la suma sea menor al monto enviado.
		agrupacion = agrupacion.stream()
				.filter(p -> p.stream().reduce(BigDecimal.ZERO, (a, b) -> a.add(b)).compareTo(bigMonto) <= 0)
				.collect(Collectors.toSet());

		Set<List<BigDecimal>> resultado = new HashSet<>();

		for (Set<BigDecimal> numeros : new ArrayList<>(agrupacion)) {
			sumar(new HashSet<>(numeros), bigMonto, new ArrayList<>(), resultado);
		}

		return resultado;
	}

	static boolean sumar(Set<BigDecimal> numeros, BigDecimal tope, List<BigDecimal> sumarizado, Set<List<BigDecimal>> resultado) {
		BigDecimal suma = sumarizado.stream().reduce(BigDecimal.ZERO, (n1, n2) -> n1.add(n2));

		if (suma.compareTo(tope) == 0) {
			resultado.add(new ArrayList<>(sumarizado));
			return true;
		}

		if (suma.compareTo(tope) > 0) {
			return true;
		}

		for (BigDecimal num : new ArrayList<>(numeros)) {
			sumarizado.add(num);
			boolean completo = sumar(numeros, tope, new ArrayList<>(sumarizado), resultado);
			if (completo) {
				numeros.remove(num);
				sumarizado = new ArrayList<>();
				continue;
			}
		}
		return false;
	}

}
