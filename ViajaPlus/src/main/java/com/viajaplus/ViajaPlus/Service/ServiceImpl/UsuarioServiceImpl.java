package com.viajaplus.ViajaPlus.Service.ServiceImpl;

import com.viajaplus.ViajaPlus.DTO.UsuarioDTO;
import com.viajaplus.ViajaPlus.Entity.ClienteEntity;
import com.viajaplus.ViajaPlus.Repository.ClienteRepository;
import com.viajaplus.ViajaPlus.Security.UserPrincipal;
import com.viajaplus.ViajaPlus.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private ClienteRepository clienteRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(ClienteRepository clienteRepository, PasswordEncoder passwordEncoder) {
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void crearUsuario(UsuarioDTO usuarioDTO) {
        try {
            clienteRepository.save(new ClienteEntity(usuarioDTO.getDni(), passwordEncoder.encode(usuarioDTO.getPassword()),
                    usuarioDTO.getNombre(), usuarioDTO.getEmail(), usuarioDTO.getTelefono(), usuarioDTO.getFechaNacimiento()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String obtenerClientIdDelUsuarioLogueado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal userPrincipal) {
            return userPrincipal.getUsuarioEntity().getDni(); // Ajusta según la estructura de tu UserPrincipal
        }

        // Si no puedes obtener el clientId, puedes devolver null o manejarlo de alguna otra manera
        return null;
    }
}
