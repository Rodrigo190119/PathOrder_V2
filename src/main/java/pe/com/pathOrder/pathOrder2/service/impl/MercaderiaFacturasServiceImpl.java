package pe.com.pathOrder.pathOrder2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.pathOrder.pathOrder2.model.MercaderiaFacturas;
import pe.com.pathOrder.pathOrder2.repository.MercaderiaFacturasRepository;
import pe.com.pathOrder.pathOrder2.service.MercaderiaFacturasService;

@Service
public class MercaderiaFacturasServiceImpl implements MercaderiaFacturasService{
	
	@Autowired
	private MercaderiaFacturasRepository mercaderiaFacturasRepository;

	@Override
	public List<MercaderiaFacturas> findAll() throws Exception {
		return mercaderiaFacturasRepository.findAll();
	}

	@Override
	public Optional<MercaderiaFacturas> findById(Integer id) throws Exception {
		return mercaderiaFacturasRepository.findById(id);
	}

	@Override
	public MercaderiaFacturas save(MercaderiaFacturas t) throws Exception {
		return mercaderiaFacturasRepository.save(t);
	}

	@Override
	public MercaderiaFacturas update(MercaderiaFacturas t) throws Exception {
		return mercaderiaFacturasRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		mercaderiaFacturasRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		mercaderiaFacturasRepository.deleteAll();
	}
}
