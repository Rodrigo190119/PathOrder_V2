package pe.com.pathOrder.pathOrder2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.pathOrder.pathOrder2.model.Dam;

@Repository
public interface DamRepository  extends JpaRepository<Dam, Integer>{

}
