package it.euris.academy.teslabattery_mg.service;

import java.util.List;
import it.euris.academy.teslabattery_mg.data.dto.ComponentFormulaDto;

public interface ComponentFormulaService {
  public ComponentFormulaDto getByComponentAndFormula(Long idComponent,Long idFormula);

  public List<ComponentFormulaDto> getAll();

  public ComponentFormulaDto add(ComponentFormulaDto dto);

  public ComponentFormulaDto update(ComponentFormulaDto dto);

  public Boolean delete(Long idComponent,Long idFormula);
}
