package com.example.SpringWithMysql.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringWithMysql.model.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Long>{
}
