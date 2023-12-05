package com.viajaplus.ViajaPlus.Service.ServiceImpl;

import com.viajaplus.ViajaPlus.Entity.UsuarioEntity;
import com.viajaplus.ViajaPlus.Repository.UsuarioRepository;
import com.viajaplus.ViajaPlus.Security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        UsuarioEntity usuarioEntity = usuarioRepository.findByDni(dni)
                .orElseThrow(() -> new UsernameNotFoundException("No existe un usuario con ese DNI"));;
        return new UserPrincipal(usuarioEntity);
    }
}
