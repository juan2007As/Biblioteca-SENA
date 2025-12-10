package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import com.biblioteca.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador para gestionar libros (CRUD completo)
 */
@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Listar todos los libros
    @GetMapping
    public String listarLibros(Model model) {
        model.addAttribute("libros", libroService.listarTodos());
        model.addAttribute("titulo", "Gestión de Libros - Biblioteca SENA");
        return "libros/listar";
    }

    // Formulario para nuevo libro
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("titulo", "Agregar Nuevo Libro");
        return "libros/formulario";
    }

    // Guardar libro (nuevo o editado)
    @PostMapping("/guardar")
    public String guardarLibro(@Valid @ModelAttribute Libro libro,
                               BindingResult result,
                               RedirectAttributes flash,
                               Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", libro.getId() == null ? "Agregar Libro" : "Editar Libro");
            return "libros/formulario";
        }

        libroService.guardar(libro);
        flash.addFlashAttribute("success", "Libro guardado con éxito");
        return "redirect:/libros";
    }

    // Editar libro
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model, RedirectAttributes flash) {
        try {
            Libro libro = libroService.buscarPorId(id);
            model.addAttribute("libro", libro);
            model.addAttribute("titulo", "Editar Libro");
            return "libros/formulario";
        } catch (RuntimeException e) {
            flash.addFlashAttribute("error", "Libro no encontrado");
            return "redirect:/libros";
        }
    }

    // Eliminar libro
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id, RedirectAttributes flash) {
        libroService.eliminar(id);
        flash.addFlashAttribute("success", "Libro eliminado correctamente");
        return "redirect:/libros";
    }
}