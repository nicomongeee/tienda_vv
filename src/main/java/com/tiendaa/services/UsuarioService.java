package com.tiendaa.services;

import com.tiendaa.dao.UsuarioDao;
import com.tiendaa.domain.Rol;
import com.tiendaa.domain.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService") //para que la clase se considere un servicio
public class UsuarioService implements UserDetailsService {

    //@Autowired provoca que si el objeto ya esta en memoria se usa ese
    //Si no esta en memoria se crea el objeto
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        var roles = new ArrayList<GrantedAuthority>();

        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));

        }

        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }

}
