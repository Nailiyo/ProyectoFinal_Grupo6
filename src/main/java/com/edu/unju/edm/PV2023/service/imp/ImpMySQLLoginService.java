package com.edu.unju.edm.PV2023.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.edu.unju.edm.PV2023.model.Docente;
import com.edu.unju.edm.PV2023.repository.DocenteRepository;

@Service
public class ImpMySQLLoginService implements UserDetailsService{


	@Autowired
	DocenteRepository docenteRepository;

	@Override
	public UserDetails loadUserByUsername(String idDocente) throws UsernameNotFoundException{
		
	
		Docente docenteEncontrado = docenteRepository.findById(Integer.parseInt(idDocente)).orElseThrow(()->new UsernameNotFoundException("Usuario re Invalido"));
				
		List <GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(docenteEncontrado.getTipo());
		tipos.add(grantedAuthority);
		
		UserDetails docenteEnSesion = new User(idDocente, docenteEncontrado.getContraseñaDocente(), tipos);
		return docenteEnSesion;
		
				
	}

	

	

}
