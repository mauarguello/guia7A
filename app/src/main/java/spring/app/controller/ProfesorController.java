package spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.app.model.Profesor;
import spring.app.service.ProfesorService;


@Controller
@RequestMapping("/profesores")
public class ProfesorController {
     private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("profesores", profesorService.listar());
        return "profesores";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Profesor profesor) {
        profesorService.add(profesor);
        return "redirect:/profesores";
    }
      @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        Profesor p=profesorService.consultar(id);
        model.addAttribute("profesor", p);
        profesorService.actualizar(p);
        System.out.println("New Change");
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        profesorService.eliminar(id);
        return "redirect:/profesores";
    }
    
}
