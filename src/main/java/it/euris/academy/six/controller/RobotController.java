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
import it.euris.academy.six.data.dto.RobotDto;
import it.euris.academy.six.service.RobotService;
@RestController
@RequestMapping("/robots")
public class RobotController {
  @Autowired
  RobotService robotService;

  @GetMapping("/teslabattery")
  public List<RobotDto> getAll() {
      return robotService.getAll();
  }

  @GetMapping("/teslabattery/{id}")
  public RobotDto getById(@PathVariable("id") Long id) {
      return robotService.getById(id);
  }

  @DeleteMapping("/teslabattery/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return robotService.delete(id);
  }

  @PostMapping("/teslabattery")
  public RobotDto insert(@RequestBody RobotDto dto) {
      return robotService.add(dto);
  }

  @PutMapping("/teslabattery")
  public RobotDto update(@RequestBody RobotDto dto) {
      return robotService.update(dto);
  }

}
