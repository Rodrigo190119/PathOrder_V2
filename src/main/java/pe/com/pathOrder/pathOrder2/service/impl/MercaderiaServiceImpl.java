package pe.com.pathOrder.pathOrder2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.pathOrder.pathOrder2.model.Mercaderia;
import pe.com.pathOrder.pathOrder2.repository.MercaderiaRepository;
import pe.com.pathOrder.pathOrder2.service.MercaderiaService;

@Service
public class MercaderiaServiceImpl implements MercaderiaService{
	
	@Autowired
	private MercaderiaRepository mercaderiaRepository;

	@Override
	public List<Mercaderia> findAll() throws Exception {
		return mercaderiaRepository.findAll();
	}

	@Override
	public Optional<Mercaderia> findById(Integer id) throws Exception {
		return mercaderiaRepository.findById(id);
	}

	@Override
	public Mercaderia save(Mercaderia t) throws Exception {
		return mercaderiaRepository.save(t);
	}

	@Override
	public Mercaderia update(Mercaderia t) throws Exception {
		return mercaderiaRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		mercaderiaRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		mercaderiaRepository.deleteAll();
	}
	
	
}
