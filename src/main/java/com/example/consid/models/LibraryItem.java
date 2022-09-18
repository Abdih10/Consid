package com.example.consid.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "LibraryItem")
@Entity
public class LibraryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne(optional = false)
    private Category category;

    @Column(length = 50, nullable = false)
    private String Title;

    @Column(length = 50, nullable = false)
    private String Author;

    @Column(length = 50, nullable = false)
    private Integer Pages;

    @Column(length = 50, nullable = false)
    private Integer RunTimeMinutes;

    @Column(length = 50, nullable = false)
    private long IsBorrowable;

    @Column(length = 50, nullable = false)
    private String Borrower;

    @Column(length = 50, nullable = false)
    private LocalDate BorrowDate;

    @Column(length = 50, nullable = false)
    private String Type;
}

