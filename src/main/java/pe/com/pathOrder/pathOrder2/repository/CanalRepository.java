package pe.com.pathOrder.pathOrder2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.pathOrder.pathOrder2.model.Canal;

@Repository
public interface CanalRepository extends JpaRepository<Canal, Integer>{
	
}
