package com.jobportal.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Job_seeker_profile")
public class JobSeekerProfile {

    @Id
    private int  userAccountId;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;

    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String workAuthorazation;
    private String employmentType;
    private String resume;
    @Column(nullable = true, length = 64)
    private String profilePhoto;

    @OneToMany(targetEntity = Skills.class, mappedBy = "jobSeekerProfile", cascade = CascadeType.ALL)
    private List<Skills> skills;

    public JobSeekerProfile(Users users) {
        this.userId = users;
    }
}
