package com.evaluacion.truper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.evaluacion.truper.model.Usuario;
import com.evaluacion.truper.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByUsuario_nombre(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return User.withUsername(username)
				.password(user.getUsuario_contrasena())
				.roles(user.getRol().getRol_nombre())
				.build();
	}
}
