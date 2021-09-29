package it.euris.academy.teslabattery_mg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.teslabattery_mg.data.model.ProductiveCycle;

public interface ProductiveCycleRepository extends JpaRepository<ProductiveCycle, Long> {

}
