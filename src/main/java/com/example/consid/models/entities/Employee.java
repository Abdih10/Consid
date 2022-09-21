package com.example.consid.models.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, nullable = false)
    private String id;

    @Column(length = 50, nullable = false)
    private String FirstName;

    @Column(length = 50, nullable = false)
    private String LastName;

    @Column(length = 50, nullable = false)
    private BigDecimal Salary;

    @Column(length = 50, nullable = false)
    private long IsCEO;

    @Column(length = 50, nullable = false)
    private long IsManager;

    @Column(length = 50, nullable = false)
    private Integer ManagerId;
}
