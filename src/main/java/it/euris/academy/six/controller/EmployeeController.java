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
import it.euris.academy.six.data.dto.EmployeeDto;
import it.euris.academy.six.service.EmployeeService;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired
  EmployeeService employeeService;

  @GetMapping("/teslabattery")
  public List<EmployeeDto> getAll() {
      return employeeService.getAll();
  }

  @GetMapping("/teslabattery/{id}")
  public EmployeeDto getById(@PathVariable("id") Long id) {
      return employeeService.getById(id);
  }

  @DeleteMapping("/teslabattery/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return employeeService.delete(id);
  }

  @PostMapping("/teslabattery")
  public EmployeeDto insert(@RequestBody EmployeeDto dto) {
      return employeeService.add(dto);
  }

  @PutMapping("/teslabattery")
  public EmployeeDto update(@RequestBody EmployeeDto dto) {
      return employeeService.update(dto);
  }

}
