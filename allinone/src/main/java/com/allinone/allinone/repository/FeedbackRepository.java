package com.allinone.allinone.repository;

import com.allinone.allinone.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByNoteIdOrderByCreatedAtAsc(Long noteId);
}
