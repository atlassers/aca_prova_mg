package it.euris.academy.teslabattery_mg.service;

import java.util.List;
import it.euris.academy.teslabattery_mg.data.dto.ComponentDto;

public interface ComponentService {
  public ComponentDto getById(Long id);

  public List<ComponentDto> getAll();

  public ComponentDto add(ComponentDto dto);

  public ComponentDto update(ComponentDto dto);

  public Boolean delete(Long id);
}
