package com.revature.AmazonSpringApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String profileName;
    private String imageLink;
    private String description;
    private String preference;
    @OneToOne
    @JoinColumn(name = "userId")
    private User userId;

}
