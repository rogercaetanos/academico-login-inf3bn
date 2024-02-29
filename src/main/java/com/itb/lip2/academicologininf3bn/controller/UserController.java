package com.itb.lip2.academicologininf3bn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itb.lip2.academicologininf3bn.model.Usuario;

// Obs: Controllers
// @Controller      -  Especificamente para sistema WEB
// @RestController  -  Especificamente para API


@RestController
@RequestMapping("/academico/api/v1")
public class UserController {

	@GetMapping("/users")
	public List<Usuario>getUsers() {
		
		List <Usuario>usuarios = new ArrayList<Usuario>() ;
		
		Usuario u1 = new Usuario();
		u1.setId(1l);
		u1.setNome("Rogério");
		u1.setEmail("rogerio@gmail.com");
		
		Usuario u2 = new Usuario();
		u2.setId(2l);
		u2.setNome("Júlia");
		u2.setEmail("julia@gmail.com");
		
		usuarios.add(u1);
		usuarios.add(u2);
		
		
		return usuarios;	
	}
		
}
