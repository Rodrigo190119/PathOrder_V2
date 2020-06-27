package pe.com.pathOrder.pathOrder2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.pathOrder.pathOrder2.model.Canal;
import pe.com.pathOrder.pathOrder2.repository.CanalRepository;
import pe.com.pathOrder.pathOrder2.service.CanalService;

@Service
public class CanalServiceImpl implements CanalService{
	@Autowired
	private CanalRepository canalRepository;

	@Override
	public List<Canal> findAll() throws Exception {
		return canalRepository.findAll();
	}

	@Override
	public Optional<Canal> findById(Integer id) throws Exception {
		return canalRepository.findById(id);
	}

	@Override
	public Canal save(Canal t) throws Exception {
		return canalRepository.save(t);
	}

	@Override
	public Canal update(Canal t) throws Exception {
		return canalRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		canalRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		canalRepository.deleteAll();
	}
	
	
}
