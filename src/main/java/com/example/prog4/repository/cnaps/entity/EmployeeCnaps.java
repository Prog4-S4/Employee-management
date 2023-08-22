package com.example.prog4.repository.cnaps.entity;


import com.example.prog4.repository.employee.entity.enums.Csp;
import com.example.prog4.repository.employee.entity.enums.Sex;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnTransformer;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "\"employee_cnaps\"", schema = "db2")
public class EmployeeCnaps {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String cin;
  private String cnaps;
  private String image;
  private String address;
  private String lastName;
  private String firstName;
  private String personalEmail;
  private String professionalEmail;
  private String registrationNumber;

  private LocalDate birthDate;
  private LocalDate entranceDate;
  private LocalDate departureDate;

  private Integer childrenNumber;

  @Enumerated(EnumType.STRING)
  @ColumnTransformer(read = "CAST(sex AS varchar)", write = "CAST(? AS sex)")
  private Sex sex;
  @Enumerated(EnumType.STRING)
  @ColumnTransformer(read = "CAST(csp AS varchar)", write = "CAST(? AS csp)")
  private Csp csp;

  @ManyToMany
  @JoinTable(
      name = "cnaps_have_position",
      joinColumns = @JoinColumn(name = "employee_id"),
      inverseJoinColumns = @JoinColumn(name = "position_id")
  )
  private List<CnapsEmployeePosition> positions;
  @OneToMany
  @JoinColumn(name = "employee_id", referencedColumnName = "id")
  private List<CnapsEmployeePhone> phones;
  private String endToEndId;
}
