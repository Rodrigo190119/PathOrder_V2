package pe.com.pathOrder.pathOrder2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.pathOrder.pathOrder2.model.Regimen;

@Repository
public interface RegimenRepository extends JpaRepository<Regimen, Integer>{

}
