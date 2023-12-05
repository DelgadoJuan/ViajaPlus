package com.viajaplus.ViajaPlus.Controller;

import com.viajaplus.ViajaPlus.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.viajaplus.ViajaPlus.DTO.UsuarioDTO;

@Controller
public class InicioController {

    private UsuarioService usuarioService;

    @Autowired
    public InicioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/signup")
    public String registro() {
        return "signup";
    }

    @PostMapping("/signup")
    public String crearUsuario(@ModelAttribute UsuarioDTO usuarioDto) {
        usuarioService.crearUsuario(usuarioDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
