package com.allinone.allinone.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "counseling_sessions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CounselingSession {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private User teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    private LocalDateTime scheduledStart;
    private LocalDateTime scheduledEnd;

    @Enumerated(EnumType.STRING)
    private Status status = Status.REQUESTED;

    private String meetingLink;
    private String reason;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public enum Status { REQUESTED, APPROVED, REJECTED, COMPLETED, CANCELLED }
}
