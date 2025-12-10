package com.biblioteca.repository;

import com.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de Libro
 */
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}