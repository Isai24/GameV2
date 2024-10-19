package com.example.GameStore.controller;

import com.example.GameStore.model.entity.Usuario;
import com.example.GameStore.model.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class UsuarioControlador {


    @Autowired
    private UsuarioServicio servicio;
/*
    @GetMapping({"/usuarios"})
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", servicio.listarTodosLosUsuarios());
        return "usuarios";
    }


    //para crear un objeto y mandar los atributos al archivo crear_persona.html
    @GetMapping({"/usuarios/nuevo", "/usuarios/crear"})
    public String mostrarFormularioDeRegistro(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "crear_usuario";
    }

    //para guardar el nuevo estudiante enviado desde el arvhico crear_estudiante.html
    @PostMapping("/usuarios")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {

        LocalDate fechaCreacion = LocalDate.now();
        // Convertir LocalDate a java.sql.Date
        usuario.setFechaInscripcion(java.sql.Date.valueOf(fechaCreacion));
        usuario.setEstado("1");
        usuario.setRol("Cliente");
        servicio.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }*/
    /*
    //buscar el estudiante seleccionado
    @GetMapping("/personas/editar/{idPersona}")
    public String mostrarFormularioDeEditar(@PathVariable Long idPersona, Model model) {
        model.addAttribute("persona", service.obtenerPersonaPorId(idPersona));
        return "editar_persona";
    }

    //
    @PostMapping("/personas/{idPersona}")
    public String actualizarPersona(@PathVariable Long idPersona, @ModelAttribute("persona") Persona persona, Model modelo) {
        Persona personaExistente = service.obtenerPersonaPorId(idPersona);
        personaExistente.setIdPersona(idPersona);
        personaExistente.setNombre(persona.getNombre());
        personaExistente.setApPaterno(persona.getApPaterno());
        personaExistente.setApMaterno(persona.getApMaterno());
        personaExistente.setTelefono(persona.getTelefono());
        personaExistente.setCorreo(persona.getCorreo());
        personaExistente.setDireccion(persona.getDireccion());
        personaExistente.setDni(persona.getDni());
        personaExistente.setDni(persona.getDni());
        //personaExistente.setFechaInscripcion(persona.getFechaInscripcion());//no se modifica la fecha
        personaExistente.setSexo(persona.getSexo());

        service.actualizarPersona(personaExistente);
        return "redirect:/personas";
    }
*//*
    @GetMapping("/usuarios/deshabilitar/{idUsuario}")
    public String deshabilitarUsuario(@PathVariable Long idUsuario) {
        Usuario usuarioExistente = servicio.obtenerUsuarioPorId(idUsuario);
        if (usuarioExistente.getEstado().equals("0")){
            usuarioExistente.setEstado("1");
        } else if (usuarioExistente.getEstado().equals("1")) {
            usuarioExistente.setEstado("0");
        }
        servicio.actualizarUsuario(usuarioExistente);
        return "redirect:/usuarios";
    }
    */


}
