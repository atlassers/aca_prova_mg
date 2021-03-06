package it.euris.academy.teslabattery_mg.service;

import java.util.List;
import it.euris.academy.teslabattery_mg.data.dto.FormulaDto;

public interface FormulaService {
  public FormulaDto getById(Long id);

  public List<FormulaDto> getAll();

  public FormulaDto add(FormulaDto dto);

  public FormulaDto update(FormulaDto dto);

  public Boolean delete(Long id);
}
