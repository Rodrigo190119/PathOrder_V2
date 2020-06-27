package pe.com.pathOrder.pathOrder2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.pathOrder.pathOrder2.model.TipoDespacho;
import pe.com.pathOrder.pathOrder2.repository.TipoDespachoRepository;
import pe.com.pathOrder.pathOrder2.service.TipoDespachoService;

@Service
public class TipoDespachoServiceImpl implements TipoDespachoService{
	
	@Autowired
	private TipoDespachoRepository tipoDespachoRepository;

	@Override
	public List<TipoDespacho> findAll() throws Exception {
		return tipoDespachoRepository.findAll();
	}

	@Override
	public Optional<TipoDespacho> findById(Integer id) throws Exception {
		return tipoDespachoRepository.findById(id);
	}

	@Override
	public TipoDespacho save(TipoDespacho t) throws Exception {
		return tipoDespachoRepository.save(t);
	}

	@Override
	public TipoDespacho update(TipoDespacho t) throws Exception {
		return tipoDespachoRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		tipoDespachoRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		tipoDespachoRepository.deleteAll();
	}
	
	
}
