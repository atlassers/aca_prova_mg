package it.euris.academy.teslabattery_mg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.teslabattery_mg.data.model.Component;


public interface ComponentRepository extends JpaRepository<Component, Long> {

}
