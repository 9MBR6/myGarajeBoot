package es.dtgz.myGarajeBoot.repository;

import es.dtgz.myGarajeBoot.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<Moto, Long> {
}