package com.spring.jpa2.springjpa2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data // getters and setters for all data
@NoArgsConstructor // no argument constructor
@AllArgsConstructor // all arguments constructor
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "emailId",
                columnNames = "emailId"
        )
)
public class Student {

    @Id // primary key is studentId
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long studentId;
    private String firstName;
    private String lastName;

    @Column(
            nullable = false
    )
    private String emailId;

    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;



}
