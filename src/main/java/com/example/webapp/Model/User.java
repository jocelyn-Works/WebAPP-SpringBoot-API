package com.example.webapp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank(message = "First Name is Required")
    @Size(min=2, max=30)
    @Column(name="first_name", nullable = false)
    private String firstName;

    @NotNull
    @NotBlank(message = "Last Name is Required")
    @Size(min=2, max=30)
    @Column(name="last_name", nullable = false)
    private String lastName;

    @NotNull
    @NotBlank(message = "Birth Date is Required")
    @Column(name="birth_date", nullable = false)
    private Date birthDate;

    @NotNull
    @NotBlank(message = "Permit Number is Required")
    @Column(name="permit_number", nullable = false)
    private String permitNumber;

    @NotNull
    @Column(name="is_valid", nullable = false)
    private Boolean isValid;




}
