package pe.com.pathOrder.pathOrder2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.pathOrder.pathOrder2.model.Regimen;
import pe.com.pathOrder.pathOrder2.repository.RegimenRepository;
import pe.com.pathOrder.pathOrder2.service.RegimenService;

@Service
public class RegimenServiceImpl implements RegimenService{
	
	@Autowired
	private RegimenRepository regimenRepository;

	@Override
	public List<Regimen> findAll() throws Exception {
		return regimenRepository.findAll();
	}

	@Override
	public Optional<Regimen> findById(Integer id) throws Exception {
		return regimenRepository.findById(id);
	}

	@Override
	public Regimen save(Regimen t) throws Exception {
		return regimenRepository.save(t);
	}

	@Override
	public Regimen update(Regimen t) throws Exception {
		return regimenRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		regimenRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		regimenRepository.deleteAll();
	}
	
	
}
