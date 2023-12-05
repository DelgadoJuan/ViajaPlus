package com.viajaplus.ViajaPlus.Controller;

import com.viajaplus.ViajaPlus.Service.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/estadisticas")
public class EstadisticasController {

    private EstadisticaService estadisticaService;

    @Autowired
    public EstadisticasController(EstadisticaService estadisticaService) {
        this.estadisticaService = estadisticaService;
    }

    @GetMapping
    public String estadisticas(@RequestParam(name = "opcion", defaultValue = "itinerario") String opcion, Model model) {
        if (opcion.equals("itinerario")) {
            model.addAttribute("itinerarioMap", estadisticaService.estadisticaItinerario());
        } else if(opcion.equals("categoria")) {
            model.addAttribute("categoriaMap", estadisticaService.obtenerEstadisticasPasajesPorCategoriaUnidadesOrdenDescendente());
        } else {
            model.addAttribute("fechaMap", estadisticaService.obtenerEstadisticasPasajesPorFechaOrdenDescendente());
        }
        model.addAttribute("opcion", opcion);
        return "estadisticas";
    }

}
