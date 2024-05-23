package com.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Table(name = "users")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(unique=true)
    private  String email;

    @NotEmpty
    private  String password;

    private boolean isActive;

    @DateTimeFormat(pattern ="dd-MM-yyyy")
    private Date registrationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usersTypeId", referencedColumnName = "usersTypeId")
    private UsersType usersTypeId;



}