package com.allinone.allinone.repository;

import com.allinone.allinone.model.CounselingSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CounselingSessionRepository extends JpaRepository<CounselingSession, Long> {
    List<CounselingSession> findByTeacherIdAndScheduledStartAfter(Long teacherId, LocalDateTime after);
    List<CounselingSession> findByStudentId(Long studentId);
}