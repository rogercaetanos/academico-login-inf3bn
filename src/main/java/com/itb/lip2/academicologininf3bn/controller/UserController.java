package com.itb.lip2.academicologininf3bn.controller;

import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itb.lip2.academicologininf3bn.model.Usuario;
import com.itb.lip2.academicologininf3bn.service.UsuarioService;

// Obs: Controllers
// @Controller      -  Especificamente para sistema WEB
// @RestController  -  Especificamente para API


@RestController
@RequestMapping("/academico/api/v1")
public class UserController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/users")
	public ResponseEntity<List<Usuario>>getUsers() {
		
		// Necessário para retornar o código corretamente "200" ( sucesso na consulta)
		
		return ResponseEntity.ok().body(usuarioService.findAll());	
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario) {
		
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/academico/api/v1/users").toString());
		
		// Retornando o código "201" (recurso criado com sucesso)
		
		return ResponseEntity.created(uri).body(usuarioService.save(usuario));	
	}
		
}