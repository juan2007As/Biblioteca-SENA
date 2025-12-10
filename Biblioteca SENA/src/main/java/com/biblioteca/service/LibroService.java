package com.biblioteca.service;

import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que contiene la lógica de negocio para libros
 */
@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro buscarPorId(Long id) {
        return libroRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Libro no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }
}