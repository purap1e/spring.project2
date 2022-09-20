package com.example.spring.project2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "requests")
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @ManyToOne(fetch = EAGER)
    private Courses courseName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "comment")
    private String comment;

    @Column(name = "handled")
    private boolean handled;

    @ManyToMany(fetch = EAGER)
    private List<Categories> category;
}
