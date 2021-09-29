package it.euris.academy.teslabattery_mg.data.dto;

import it.euris.academy.teslabattery_mg.UT.UT;
import it.euris.academy.teslabattery_mg.data.archetype.Dto;
import it.euris.academy.teslabattery_mg.data.model.ComponentFormula;
import it.euris.academy.teslabattery_mg.data.model.key.ComponentFormulaKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComponentFormulaDto implements Dto {

  private ComponentFormulaKey idKey;
  private String component;
  private String formula;
  private String quantity;
  private String unitMeasure;

  @Override
  public ComponentFormula toModel() {

    return ComponentFormula.builder()
        .idKey(new ComponentFormulaKey(UT.toLong(component), UT.toLong(formula)))
        .quantity(UT.toDouble(quantity)).unitMeasure(UT.getUnitMeasure(unitMeasure)).build();
  }

}
