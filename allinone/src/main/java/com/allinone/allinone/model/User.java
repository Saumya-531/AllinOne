package com.allinone.allinone.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="full_name", nullable=false)
    private String fullName;

    @Column(unique = true, nullable=false)
    private String email;

    @JsonIgnore
    @Column(nullable=false)
    private String password;

    private String bio;
    private String avatarUrl;
    private String department;
    private Integer semester;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "uploadedBy", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Note> uploadedNotes = new ArrayList<>();

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CounselingSession> studentSessions = new ArrayList<>();

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CounselingSession> teacherSessions = new ArrayList<>();
}
