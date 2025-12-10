package com.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * Entidad que representa un libro en el sistema de biblioteca
 */
@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 2, max = 200, message = "El título debe tener entre 2 y 200 caracteres")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotBlank(message = "La ISBN es obligatoria")
    @Pattern(regexp = "(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$|[0-9]{10}|[0-9]{13})[0-9X -]*", message = "ISBN inválido. Use 10 o 13 dígitos")
    private String isbn;

    @Min(value = 1500, message = "El año debe ser mayor a 1500")
    @Max(value = 2025, message = "El año no puede ser futuro")
    private int anioPublicacion;

    @NotNull(message = "Indique si está disponible")
    private Boolean disponible = true;

    // Constructores
    public Libro() {}

    public Libro(String titulo, String autor, String isbn, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
}