package com.example.prog4.repository.entity;


import com.example.prog4.repository.entity.enums.Csp;
import com.example.prog4.repository.entity.enums.Sex;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.time.LocalDate;
import java.util.List;

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
            name = "have_position",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    private List<Position> positions;
    @OneToMany
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private List<Phone> phones;
    private String endToEndId;
}
