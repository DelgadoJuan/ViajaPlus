package com.viajaplus.ViajaPlus.Controller;

import com.viajaplus.ViajaPlus.DTO.TransporteDTO;
import com.viajaplus.ViajaPlus.Service.TransporteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/transporte")
public class TransporteController {

    private TransporteService transporteService;

    @Autowired
    public TransporteController(TransporteService transporteService) {
        this.transporteService = transporteService;
    }

    @GetMapping()
    public String transportes(Model model) {
        model.addAttribute("transportes", transporteService.listarTransportes());
        return "transporte";
    }

    @GetMapping("/formulario")
    public String formulario() {
        return "crearTransporte";
    }

    @PostMapping("/formulario/crear")
    public String crearTransporte(@ModelAttribute @Valid TransporteDTO transporteDTO) {
        transporteService.crearTransporte(transporteDTO);
        return "redirect:/admin/transporte";
    }

    @GetMapping("/modificar/{idTransporte}")
    public String modificarTransporte(@PathVariable("idTransporte") Long idTransporte, Model model) {
        model.addAttribute("transporteDTO", transporteService.obtenerPorId(idTransporte));
        return "modificarTransporte";
    }

    @PostMapping("/modificar/{idTransporte}")
    public String modificarTransporte(@PathVariable("idTransporte") Long idTransporte, @ModelAttribute TransporteDTO transporteDTO) {
        transporteService.modificarTransporte(idTransporte, transporteDTO);
        return "redirect:/admin/transporte";
    }

    @GetMapping("/eliminar/{idTransporte}")
    public String eliminarTransporte(@PathVariable("idTransporte") Long idTransporte) {
        transporteService.eliminarTransporte(idTransporte);
        return "redirect:/admin/transporte";
    }
}
