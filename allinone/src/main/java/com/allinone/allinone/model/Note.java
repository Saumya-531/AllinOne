package com.allinone.allinone.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Note {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private String title;

    @Column(length = 2000)
    private String description;

    private String filePath;
    private String originalFilename;
    private String mimeType;
    private Long fileSizeBytes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploaded_by")
    private User uploadedBy;

    @Enumerated(EnumType.STRING)
    private Visibility visibility = Visibility.INSTITUTE;

    @Enumerated(EnumType.STRING)
    private Status status = Status.APPROVED;

    private Integer downloadsCount = 0;

    private BigDecimal avgRating;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Feedback> feedback = new ArrayList<>();

    public enum Visibility { PUBLIC, INSTITUTE, PRIVATE }
    public enum Status { PENDING, APPROVED, REJECTED }
}
