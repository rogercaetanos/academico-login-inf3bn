package com.itb.lip2.academicologininf3bn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Usuario>getUsers() {
		
		return usuarioService.findAll();	
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario) {
		
		return ResponseEntity.ok().body(usuarioService.save(usuario));
	}
		
}
