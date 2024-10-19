package com.example.GameStore.controller;

import com.example.GameStore.model.entity.Promocion;
import com.example.GameStore.model.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;

@Controller
public class PromocionController {

    @Autowired
    private PromocionService service;

    @GetMapping({"/promociones"})
    public String listarPromocion(Model model) {
        model.addAttribute("promociones", service.listarTodasLasPromociones());
        return "promociones";
    }/*
    @GetMapping({"/promocion/nuevo", "/promocion/crear"})
    public String mostrarFormularioDePromociones(Model modelo) {
        Promocion promocion = new Promocion();
        modelo.addAttribute("promocion", promocion);
        return "crear_promocion";
    }
    @PostMapping("/promocion")
    public String guardarPromocion(@ModelAttribute("promocion") Promocion promocion) {

        Date fechaInc = new Date(System.currentTimeMillis());
        Date fechaFin = new Date(System.currentTimeMillis());
        promocion.setFechaInc(fechaInc);
        promocion.setFechaFin(fechaFin);
        service.guardarPromocion(promocion);
        return "redirect:/promociones";
    }
    @GetMapping("/promocion/editar/{idPromocion}")
    public String mostrarFormularioDePromocion(@PathVariable Long idPromocion, Model model) {
        model.addAttribute("promocion", service.obtenerPromocionPorId(idPromocion));
        return "editar_promocion";
    }
    @PostMapping("/promocion/{idPromocion}")
    public String actualizarPromocion(@PathVariable Long idPromocion, @ModelAttribute("promocion") Promocion promocion, Model modelo) {
        Promocion promocionExistente = service.obtenerPromocionPorId(idPromocion);
        promocionExistente.setIdPromocion(idPromocion);
        promocionExistente.setNombreProm(promocion.getNombreProm());
        promocionExistente.setDescripcion(promocion.getDescripcion());
        promocionExistente.setFechaInc(promocion.getFechaInc());
        promocionExistente.setFechaFin(promocion.getFechaFin());
        promocionExistente.setProcentajeDesc(promocion.getProcentajeDesc());

        service.actualizarPromocion(promocionExistente);
        return "redirect:/promociones";
    }
    @GetMapping("/promocion/eliminar/{id}")
    public String eliminarPromocion(@PathVariable Long id) {
        service.eliminarPromocion(id);
        return "redirect:/promociones";
    }*/
}
