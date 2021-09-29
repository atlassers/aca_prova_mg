package it.euris.academy.teslabattery_mg.data.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import it.euris.academy.teslabattery_mg.UT.UT;
import it.euris.academy.teslabattery_mg.data.archetype.Model;
import it.euris.academy.teslabattery_mg.data.dto.ProductiveCycleDto;
import it.euris.academy.teslabattery_mg.data.enums.ProductionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "productive_cycle")
@SQLDelete(sql = "UPDATE productive_cycle pc SET pc.isDeleted=true WHERE id=?")
@Where(clause = "isDeleted=false")
@Entity
public class ProductiveCycle implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Instant startDate;
  private Instant endDate;
  private Instant statusDate;
  private ProductionStatus status;
  @Builder.Default
  private Boolean isDeleted = false;

  @JoinColumn(name = "assemblyLine_id", nullable = false)
  private AssemblyLine assemblyLineId;

  @ManyToOne
  @JoinColumn(name = "supervisor_id", nullable = false)
  private Employee supervisor;

  public ProductiveCycle(String productiveCycleId) {
    if (productiveCycleId != null) {
      this.id = Long.parseLong(productiveCycleId);
    }
  }
  

  @Override
  public ProductiveCycleDto toDto() {
    return ProductiveCycleDto.builder().id(id == null ? null : id.toString())
        .startDate(UT.fromInstant(startDate)).endDate(UT.fromInstant(endDate))
        .statusDate(UT.fromInstant(statusDate)).status(UT.getProductionStatus(status))
        .isDeleted(isDeleted).assemblyLineId(assemblyLineId.getId().toString()).build();
  }



}
