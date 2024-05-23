package com.jobportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "users_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userTypeId;
    private String usersTypeId;
    @OneToMany(targetEntity = Users.class, mappedBy ="usersTypeId", cascade = CascadeType.ALL)
    private List<Users> users;

}
