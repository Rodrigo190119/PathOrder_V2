package pe.com.pathOrder.pathOrder2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.pathOrder.pathOrder2.model.Bulto;
import pe.com.pathOrder.pathOrder2.repository.BultoRepository;
import pe.com.pathOrder.pathOrder2.service.BultoService;

@Service
public class BultoServiceImpl implements BultoService{
	@Autowired
	private BultoRepository bultoRepository;

	@Override
	public List<Bulto> findAll() throws Exception {
		return bultoRepository.findAll();
	}

	@Override
	public Optional<Bulto> findById(Integer id) throws Exception {
		return bultoRepository.findById(id);
	}

	@Override
	public Bulto save(Bulto t) throws Exception {
		return bultoRepository.save(t);
	}

	@Override
	public Bulto update(Bulto t) throws Exception {
		return bultoRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		bultoRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		bultoRepository.deleteAll();
	}
	
	
}
