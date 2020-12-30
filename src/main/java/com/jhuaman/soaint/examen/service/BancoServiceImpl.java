package com.jhuaman.soaint.examen.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.jhuaman.soaint.examen.model.Banco;
import com.jhuaman.soaint.examen.repository.BancoRepository;
import com.jhuaman.soaint.examen.utils.Utilitario;
import com.jhuaman.soaint.examen.vo.BancoVO;
import com.jhuaman.soaint.examen.vo.RespuestaVO;

public class BancoServiceImpl implements BancoService {

	@Override
	@Transactional(rollbackOn=Exception.class)
	public RespuestaVO<BancoVO> create(BancoVO t) {
		if (Utilitario.isEmpty(t.getDireccion())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'direccion'");
		}
		if (Utilitario.isEmpty(t.getNombre())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'nombre'");
		}
		BancoRepository bancoRepository = new BancoRepository();
		Banco banco = new Banco();
		banco.setDireccion(t.getDireccion());
		banco.setFecRegistro(new Date());
		banco.setNombre(t.getNombre());

		bancoRepository.create(banco);

		return new RespuestaVO<>(true, "Se registr\u00f3 con \u00e9xito");
	}

	@Override
	public RespuestaVO<BancoVO> delete(long id) {
		return new RespuestaVO<>(true, "Se elimin\u00f3 con \u00e9xito");
	}

	@Override
	public BancoVO find(long idBanco) {
		BancoRepository bancoRepository = new BancoRepository();
		Banco banco = bancoRepository.find(idBanco);
		BancoVO bancoVO = new BancoVO();
		bancoVO.setDireccion(banco.getDireccion());
		bancoVO.setIdBanco(banco.getIdBanco());
		bancoVO.setNombre(banco.getNombre());
		bancoVO.setFecRegistro(Utilitario.dateToStringDDMMYYYY(banco.getFecRegistro()));
		return bancoVO;
	}

	@Override
	@Transactional(rollbackOn=Exception.class)
	public RespuestaVO<BancoVO> update(long id, BancoVO t) {
		if (Utilitario.isEmpty(t.getDireccion())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'direccion'");
		}
		if (Utilitario.isEmpty(t.getNombre())) {
			return new RespuestaVO<>(false, "No se ha enviado el parametro 'nombre'");
		}
		BancoRepository bancoRepository = new BancoRepository();
		Banco banco = bancoRepository.find(id);
		banco.setDireccion(t.getDireccion());
		banco.setNombre(t.getNombre());

		bancoRepository.update(banco);

		return new RespuestaVO<>(true, "Se actualiz\u00f3 con \u00e9xito");
	}

	@Override
	public List<BancoVO> findAll() {
		BancoRepository bancoRepository = new BancoRepository();
		List<Banco> bancos = bancoRepository.findAll();

		List<BancoVO> respuesta = new ArrayList<BancoVO>();
		for (Banco banco : bancos) {
			BancoVO bancoVO = new BancoVO();
			bancoVO.setDireccion(banco.getDireccion());
			bancoVO.setIdBanco(banco.getIdBanco());
			bancoVO.setNombre(banco.getNombre());
			bancoVO.setFecRegistro(Utilitario.dateToStringDDMMYYYY(banco.getFecRegistro()));
			respuesta.add(bancoVO);
		}
		return respuesta;
	}

}
