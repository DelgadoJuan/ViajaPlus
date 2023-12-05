package com.viajaplus.ViajaPlus.Controller;

import com.viajaplus.ViajaPlus.DTO.ItinerarioDTO;
import com.viajaplus.ViajaPlus.Entity.ItinerarioEntity;
import com.viajaplus.ViajaPlus.Service.ItinerarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/itinerario")
public class ItinerarioController {

    private ItinerarioService itinerarioService;

    @Autowired
    public ItinerarioController(ItinerarioService itinerarioService) {
        this.itinerarioService = itinerarioService;
    }

    @GetMapping()
    public String mostrarItinerarios(Model model) {
        model.addAttribute("itinerarios", itinerarioService.listarItinerarios());
        return "itinerario";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario() {
        return "crearItinerario";
    }

    @PostMapping("/formulario/crear")
    public String crearItinerario(@ModelAttribute @Valid ItinerarioDTO itinerarioDTO) {
        itinerarioService.crearItinerario(itinerarioDTO);
        return "redirect:/admin/itinerario";
    }

    @GetMapping("/modificar/{idItinerario}")
    public String mostrarFormularioModificar(@PathVariable("idItinerario") Long idItinerario, Model model) {
        ItinerarioEntity itinerario = itinerarioService.obtenerItinerarioPorId(idItinerario);
        model.addAttribute("itinerarioDTO", new ItinerarioDTO(itinerario.getOrigen(), itinerario.getDestino(),
                itinerario.getSalida().toString().substring(0,5), itinerario.getLlegada().toString().substring(0, 5)));
        return "modificarItinerario";
    }

    @PostMapping("/modificar/{idItinerario}")
    public String crearServicio(@PathVariable("idItinerario") Long idItinerario, @ModelAttribute ItinerarioDTO itinerarioDTO) {
        itinerarioService.modificarItinerario(idItinerario, itinerarioDTO);
        return "redirect:/admin/itinerario";
    }

    @GetMapping("/eliminar/{idItinerario}")
    public String eliminarItinerario(@PathVariable("idItinerario") Long idItinerario) {
        itinerarioService.eliminarItinerario(idItinerario);
        return "redirect:/admin/itinerario";
    }

}
