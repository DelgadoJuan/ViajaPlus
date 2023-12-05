package com.viajaplus.ViajaPlus.Controller;

import com.viajaplus.ViajaPlus.DTO.PasajeDTO;
import com.viajaplus.ViajaPlus.DTO.ReservaServicioDTO;
import com.viajaplus.ViajaPlus.Service.PasajeService;
import com.viajaplus.ViajaPlus.Service.ReservaService;
import com.viajaplus.ViajaPlus.Service.ServicioService;
import com.viajaplus.ViajaPlus.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.viajaplus.ViajaPlus.Entity.ReservaEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/viajes")
public class PasajesController {

    private ServicioService servicioService;
    private UsuarioService usuarioService;
    private PasajeService pasajeService;
    private ReservaService reservaService;

    @Autowired
    public PasajesController(ServicioService servicioService, UsuarioService usuarioService, PasajeService pasajeService, ReservaService reservaService) {
        this.servicioService = servicioService;
        this.usuarioService = usuarioService;
        this.pasajeService = pasajeService;
        this.reservaService = reservaService;
    }

    @GetMapping()
    public String viajes(@RequestParam(name = "origen", required = false) String origen,
                         @RequestParam(name = "destino", required = false) String destino,
                         Model model) {
        if (origen == null || destino == null) {
            model.addAttribute("servicios", servicioService.listarTodos());
        } else {
            model.addAttribute("servicios", servicioService.filtrarPorItinerarioOrigenYDestino(origen, destino));
        }
        return "viajes";
    }

    @PostMapping()
    public String manejarAccion(@RequestParam("servicioId") Long servicioId,
                                @RequestParam("accion") String accion) {
        // servicioId: ID del servicio seleccionado
        // accion: "reservar" o "pagar"

        // Aquí puedes realizar las acciones correspondientes según el valor de 'accion'

        if (accion.equals("reservar")) {
            reservaService.reservar(new PasajeDTO(usuarioService.obtenerClientIdDelUsuarioLogueado(), servicioId));
            return "redirect:/viajes/reservas";
        } else if (accion.equals("pagar")) {
            pasajeService.comprarPasaje(new PasajeDTO(usuarioService.obtenerClientIdDelUsuarioLogueado(), servicioId));
            return "redirect:/viajes/mis-viajes";
        }
        return "redirect:/viajes";
    }

    @GetMapping("/reservas")
    public String misReservas(Model model) {
        List<ReservaEntity> reservas = reservaService.listarReservas(usuarioService.obtenerClientIdDelUsuarioLogueado());
        List<ReservaServicioDTO> reservasConServicios = reservas.stream()
                .map(reserva -> new ReservaServicioDTO(reserva.getId(), reserva.getServicio()))
                .toList();
        model.addAttribute("reservasConServicios", reservasConServicios);
        return "misreservas";
    }

    @PostMapping("/reservas")
    public String pagarReserva(@RequestParam("reservaId") Long reservaId) {
        reservaService.pagarReserva(reservaId);
        return "redirect:/viajes/mis-viajes";
    }

    @GetMapping("/mis-viajes")
    public String misViajes(Model model) {
        model.addAttribute("servicios", pasajeService.listarVentas(usuarioService.obtenerClientIdDelUsuarioLogueado()));
        return "misviajes";
    }

}
