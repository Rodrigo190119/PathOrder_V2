package pe.com.pathOrder.pathOrder2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.pathOrder.pathOrder2.model.Factura;
import pe.com.pathOrder.pathOrder2.repository.FacturaRepository;
import pe.com.pathOrder.pathOrder2.service.FacturaService;

@Service
public class FacturaServiceImpl implements FacturaService{
	
	@Autowired
	private FacturaRepository facturaRepository;

	@Override
	public List<Factura> findAll() throws Exception {
		return facturaRepository.findAll();
	}

	@Override
	public Optional<Factura> findById(Integer id) throws Exception {
		return facturaRepository.findById(id);
	}

	@Override
	public Factura save(Factura t) throws Exception {
		return facturaRepository.save(t);
	}

	@Override
	public Factura update(Factura t) throws Exception {
		return facturaRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		facturaRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		facturaRepository.deleteAll();
	}
	
	
}
