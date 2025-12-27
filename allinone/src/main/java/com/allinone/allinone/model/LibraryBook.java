package com.allinone.allinone.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "library_books")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LibraryBook {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private String edition;
    private String publisher;
    private Integer copiesTotal = 1;
    private Integer copiesAvailable = 1;
    private String location;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
