package it.euris.academy.six.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.academy.six.data.dto.ComponentFormulaDto;
import it.euris.academy.six.service.ComponentFormulaService;
@RestController
@RequestMapping("/components-formulas")
public class ComponentFormulaController {
  @Autowired
  ComponentFormulaService componentFormulaService;

  @GetMapping("/teslabattery")
  public List<ComponentFormulaDto> getAll() {
      return componentFormulaService.getAll();
  }

  @GetMapping("/teslabattery/{componentId}/{formulaId}")
  public ComponentFormulaDto getById(@PathVariable("componentId") Long componentId,@PathVariable("formulaId") Long formulaId) {
      return componentFormulaService.getByComponentAndFormula(componentId,formulaId);
  }

  @DeleteMapping("/teslabattery/{componentId}/{formulaId}")
  public Boolean delete(@PathVariable("componentId") Long componentId,@PathVariable("formulaId") Long formulaId) {
      return componentFormulaService.delete(componentId,formulaId);
  }

  @PostMapping("/teslabattery")
  public ComponentFormulaDto insert(@RequestBody ComponentFormulaDto dto) {
      return componentFormulaService.add(dto);
  }

  @PutMapping("/teslabattery")
  public ComponentFormulaDto update(@RequestBody ComponentFormulaDto dto) {
      return componentFormulaService.update(dto);
  }

}
