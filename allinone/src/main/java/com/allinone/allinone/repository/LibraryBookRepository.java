package com.allinone.allinone.repository;

import com.allinone.allinone.model.LibraryBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long> {
    List<LibraryBook> findByTitleContainingIgnoreCase(String q);
}
