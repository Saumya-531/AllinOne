package com.allinone.allinone.repository;

import com.allinone.allinone.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Page<Note> findBySubjectId(Long subjectId, Pageable pageable);
    Page<Note> findByUploadedById(Long userId, Pageable pageable);
}
