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
    private int id;

    @NotNull
    @NotBlank(message = "First Name is Required")
    @Size(min=2, max=30)
    private String firstName;

    @NotNull
    @NotBlank(message = "Last Name is Required")
    @Size(min=2, max=30)
    private String lastName;

    @NotNull
    @NotBlank(message = "Birth Date is Required")
    private Date birthDate;

    @NotNull
    @NotBlank(message = "Permit Number is Required")
    private String permitNumber;

    @NotNull
    private Boolean isValid;




}
