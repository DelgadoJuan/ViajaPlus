package com.viajaplus.ViajaPlus.Controller;

import com.viajaplus.ViajaPlus.DTO.ServicioDTO;
import com.viajaplus.ViajaPlus.Entity.ServicioEntity;
import com.viajaplus.ViajaPlus.Service.ItinerarioService;
import com.viajaplus.ViajaPlus.Service.ServicioService;
import com.viajaplus.ViajaPlus.Service.TransporteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/servicio")
public class ServicioController {
    private ServicioService servicioService;
    private ItinerarioService itinerarioService;
    private TransporteService transporteService;

    @Autowired
    public ServicioController(ServicioService servicioService, ItinerarioService itinerarioService, TransporteService transporteService) {
        this.servicioService = servicioService;
        this.itinerarioService = itinerarioService;
        this.transporteService = transporteService;
    }

    @GetMapping()
    public String servicios(Model model) {
        model.addAttribute("servicios",servicioService.listarTodos());
        return "servicio";
    }

    @GetMapping("/formulario")
    public String crearServicio(Model model) {
        model.addAttribute("itinerarios", itinerarioService.listarItinerarios());
        model.addAttribute("transportes", transporteService.listarTransportes());
        return "crearServicio";
    }

    @GetMapping("/modificar/{idServicio}")
    public String mostrarFormularioModificar(@PathVariable("idServicio") Long idServicio, Model model) {
        ServicioEntity servicio = servicioService.obtenerServicioPorId(idServicio);
        model.addAttribute("itinerarios", itinerarioService.listarItinerarios());
        model.addAttribute("transportes", transporteService.listarTransportes());

        model.addAttribute("servicioDTO", new ServicioDTO(
                servicio.getItinerario().getId(),
                servicio.getTransporte().getId(),
                servicio.getPartida(),
                servicio.getLlegada(),
                servicio.getCosto()
        ));
        return "modificarServicio";
    }

    @PostMapping("/modificar/{idServicio}")
    public String crearServicio(@PathVariable("idServicio") Long idServicio, @ModelAttribute ServicioDTO servicioDTO) {
        servicioService.modificarServicio(idServicio, servicioDTO);
        return "redirect:/admin/servicio";
    }

    @PostMapping("/formulario/crear")
    public String crearServicio(@ModelAttribute @Valid ServicioDTO servicioDTO) {
        servicioService.crearServicio(servicioDTO);
        return "redirect:/admin/servicio";
    }

    @GetMapping("/eliminar/{idServicio}")
    public String eliminarServicio(@PathVariable("idServicio") Long idServicio) {
        servicioService.eliminarServicio(idServicio);
        return "redirect:/admin/servicio";
    }
}
