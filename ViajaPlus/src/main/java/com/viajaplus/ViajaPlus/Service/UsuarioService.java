package com.viajaplus.ViajaPlus.Service;

import com.viajaplus.ViajaPlus.DTO.UsuarioDTO;

public interface UsuarioService {
    public void crearUsuario(UsuarioDTO usuarioDTO);
    String obtenerClientIdDelUsuarioLogueado();
}
