package it.euris.academy.teslabattery_mg.data.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import it.euris.academy.teslabattery_mg.data.archetype.Model;
import it.euris.academy.teslabattery_mg.data.dto.AssemblyLineDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "assembly_line")
@Entity
public class AssemblyLine implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "maxLength")
  private Double maxLength;

  @OneToMany(mappedBy = "assemblyLine")
  @Builder.Default
  private List<Robot> robots = new ArrayList<Robot>();


  public AssemblyLine(String id) {
    if (id != null) {
      this.id = Long.parseLong(id);
    }
  }

  @Override
  public AssemblyLineDto toDto() {
    return AssemblyLineDto.builder().id(id == null ? null : id.toString()).name(name)
        .maxLength(maxLength.toString()).build();
  }
}
