package pe.com.pathOrder.pathOrder2.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.pathOrder.pathOrder2.model.Canal;
import pe.com.pathOrder.pathOrder2.model.OrdenDespacho;
import pe.com.pathOrder.pathOrder2.repository.OrdenDespachoRepository;
import pe.com.pathOrder.pathOrder2.service.CanalService;
import pe.com.pathOrder.pathOrder2.service.OrdenDespachoService;

@Service
public class OrdenDespachoServiceImpl implements OrdenDespachoService{
	
	@Autowired
	private OrdenDespachoRepository ordenDespachoRepository;
	@Autowired
	private CanalService canalService;
	
	@Override
	public List<OrdenDespacho> findAll() throws Exception {
		return ordenDespachoRepository.findAll();
	}

	@Override
	public Optional<OrdenDespacho> findById(Integer id) throws Exception {
		return ordenDespachoRepository.findById(id);
	}

	@Override
	public OrdenDespacho save(OrdenDespacho t) throws Exception {
		return ordenDespachoRepository.save(t);
	}

	@Override
	public OrdenDespacho update(OrdenDespacho t) throws Exception {
		return ordenDespachoRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		ordenDespachoRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		ordenDespachoRepository.deleteAll();
	}

	@Override
	public OrdenDespacho saveWithCanal(OrdenDespacho t) throws Exception {
		Random r = new Random();
		Integer x = r.nextInt(3) + 1;
		Optional<Canal> aux = canalService.findById(x);
		if(aux.isPresent()) {
			t.setCanal(aux.get());
		}
		return ordenDespachoRepository.save(t);
	}
	
	
}
