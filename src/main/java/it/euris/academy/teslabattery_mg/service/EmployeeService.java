package it.euris.academy.teslabattery_mg.service;

import java.util.List;
import it.euris.academy.teslabattery_mg.data.dto.EmployeeDto;

public interface EmployeeService {
  public EmployeeDto getById(Long id);

  public List<EmployeeDto> getAll();

  public EmployeeDto add(EmployeeDto dto);

  public EmployeeDto update(EmployeeDto dto);

  public Boolean delete(Long id);
}
