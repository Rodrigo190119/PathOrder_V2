package pe.com.pathOrder.pathOrder2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.pathOrder.pathOrder2.model.AgenteAduanero;
import pe.com.pathOrder.pathOrder2.repository.AgenteAduaneroRepository;
import pe.com.pathOrder.pathOrder2.service.AgenteAduaneroService;

@Service
public class AgenteAduaneroServiceImpl implements AgenteAduaneroService {
	
	@Autowired
	private AgenteAduaneroRepository agenteAduaneroRepository;

	@Override
	public List<AgenteAduanero> findAll() throws Exception {
		return agenteAduaneroRepository.findAll();
	}

	@Override
	public Optional<AgenteAduanero> findById(Integer id) throws Exception {
		return agenteAduaneroRepository.findById(id);
	}

	@Override
	public AgenteAduanero save(AgenteAduanero t) throws Exception {
		return agenteAduaneroRepository.save(t);
	}

	@Override
	public AgenteAduanero update(AgenteAduanero t) throws Exception {
		return agenteAduaneroRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		agenteAduaneroRepository.deleteById(id);
		
	}

	@Override
	public void deleteAll() throws Exception {
		agenteAduaneroRepository.deleteAll();
	}
	
	
}
