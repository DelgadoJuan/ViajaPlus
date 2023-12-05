package com.viajaplus.ViajaPlus.Security;

import com.viajaplus.ViajaPlus.Entity.UsuarioEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private UsuarioEntity usuarioEntity;

    public UserPrincipal(UsuarioEntity usuarioEntity) {
        super();
        this.usuarioEntity = usuarioEntity;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuarioEntity.getRol().name());
        return List.of(authority);
    }

    @Override
    public String getPassword() {
        return this.usuarioEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.usuarioEntity.getDni();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
