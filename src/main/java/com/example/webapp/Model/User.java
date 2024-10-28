package com.example.webapp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull

    private Date birthDate;
    @NotNull
    private String permitNumber;
    @NotNull
    private Boolean isValid;



    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", permitNumber='" + permitNumber + '\'' +
                '}';
    }
}
