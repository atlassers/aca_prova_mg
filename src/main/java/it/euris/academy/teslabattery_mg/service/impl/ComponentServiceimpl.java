package it.euris.academy.teslabattery_mg.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.teslabattery_mg.data.dto.ComponentDto;
import it.euris.academy.teslabattery_mg.data.model.Component;
import it.euris.academy.teslabattery_mg.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_mg.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_mg.repository.ComponentRepository;
import it.euris.academy.teslabattery_mg.service.ComponentService;


@Service
public class ComponentServiceimpl implements ComponentService {

  @Autowired
  private ComponentRepository componentRepository;
  
  @Override
  public ComponentDto getById(Long id) {
    return componentRepository.findById(id).orElse(new Component()).toDto();
  }

  @Override
  public List<ComponentDto> getAll() {
    return componentRepository.findAll()
        .stream().map(curComponent -> curComponent.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public ComponentDto add(ComponentDto componentDto) {
    if (componentDto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return componentRepository.save(componentDto.toModel()).toDto();
  }

  @Override
  public ComponentDto update(ComponentDto componentDto) {
    if (componentDto.getId() != null) {
      throw new IdMustNotBeNullException();
    }
    return componentRepository.save(componentDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    componentRepository.deleteById(id);
    return componentRepository.findById(id).isEmpty();
  }

}
