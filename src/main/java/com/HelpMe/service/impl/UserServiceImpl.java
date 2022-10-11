package com.HelpMe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.HelpMe.exception.ArgumentRequiredException;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.repository.IUserRepo;
import com.HelpMe.service.IUserService;
import com.HelpMe.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private IUserRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public List<User> getAll() {
		List<User> list = repo.findAll();
		return list;
	}         
	

	@Override
	public Page<User> getPaginated(int page, int size) {
		return repo.findAll(PageRequest.of(page, size));
	}

	@Override
	public Page<User> getPaginated(Pageable page) {
		return repo.findAll(page);
	}

	@Override
	public User getById(Integer idUser) throws ModelNotFoundException {

		return repo.findById(idUser).orElseThrow(() -> new ModelNotFoundException("User no encontrado"));

	}

	@Override
	public void save(User user) throws ConflictException {

		if (repo.existsByDocument(user.getDocument())) {
			throw new ConflictException("Documento ya existe");
		}
		if (repo.existsByEmail(user.getEmail())) {
			throw new ConflictException("Email ya existe");
		}
		if (repo.existsByUsername(user.getUsername())) {
			throw new ConflictException("UserName ya existe");
		}
		
		user.setClave(bcrypt.encode(user.getClave()));
		
		this.repo.save(user);

	}

	@Override
	public void update(User user) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {

		if (validarExistenciaPorId(user.getId())) {
			System.out.print("Entro if existe id");
			repo.save(user);

		} else {
			throw new ModelNotFoundException("Usuario no encontrado");
		}

	}

	@Override
	public void delete(int idUser) throws ModelNotFoundException {

		if (validarExistenciaPorId(idUser)) {
			System.out.print("Valido y id si existe");
			this.repo.deleteById(idUser);
		} else {
			throw new ModelNotFoundException("Usuario no encontrado");
		}
	}
	
	public void deleteByDocument(String document) throws ModelNotFoundException {

		if (repo.existsByDocument(document)) {
			System.out.print("Valido y id si existe");
			this.repo.deleteByDocument(document);
		} else {
			throw new ModelNotFoundException("Usuario no encontrado");
		}
	}

	private Boolean validarExistenciaPorId(int idUser) {

		return repo.existsById(idUser);
	}

	
	
	public User getByDocument(String document) throws ModelNotFoundException {
		
		if(!repo.existsByDocument(document)) {
			throw new ModelNotFoundException("Usuario no encontrado");
		}

		return repo.findByDocument(document);

	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.print("Entro logueo");		
		
	
		User usuario = repo.findOneByEmail(email);
		
		
		System.out.print("User:"+"hola"+usuario.getRol().getNombre());
		
		if(usuario == null)
			new UsernameNotFoundException("----Usuario no encontrado");
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
		
      
        UserDetails uds = new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getClave(), roles);
        return uds;
	}

}
