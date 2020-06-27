package pe.com.pathOrder.pathOrder2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.pathOrder.pathOrder2.model.Dam;
import pe.com.pathOrder.pathOrder2.repository.DamRepository;
import pe.com.pathOrder.pathOrder2.service.DamService;

@Service
public class DamServiceImpl implements DamService{
	
	@Autowired
	private DamRepository damRepository;
	
	@Override
	public List<Dam> findAll() throws Exception {
		return damRepository.findAll();
	}

	@Override
	public Optional<Dam> findById(Integer id) throws Exception {
		return damRepository.findById(id);
	}

	@Override
	public Dam save(Dam t) throws Exception {
		return damRepository.save(t);
	}

	@Override
	public Dam update(Dam t) throws Exception {
		return damRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		damRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		damRepository.deleteAll();
	}
	
	
}
