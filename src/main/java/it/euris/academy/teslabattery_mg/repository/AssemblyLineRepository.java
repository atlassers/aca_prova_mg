package it.euris.academy.teslabattery_mg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.teslabattery_mg.data.model.AssemblyLine;


public interface AssemblyLineRepository extends JpaRepository<AssemblyLine, Long> {

}
