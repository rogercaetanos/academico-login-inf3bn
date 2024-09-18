package com.itb.lip2.academicologininf3bn.controller;

import java.net.URI;

import java.util.List;

import com.itb.lip2.academicologininf3bn.model.Aluno;
import com.itb.lip2.academicologininf3bn.model.Funcionario;
import com.itb.lip2.academicologininf3bn.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

	/*
	Agora, para prover o login criaremos um save para cada tipo de usuário

	@PostMapping("/users")
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario) {
		
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/academico/api/v1/users").toString());
		// Retornando o código "201" (recurso criado com sucesso)
		
		return ResponseEntity.created(uri).body(usuarioService.save(usuario));	
	}
  */

	@PostMapping("/users/professor")
	public ResponseEntity<Usuario> saveProfessor(@RequestBody Professor professor) {

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/academico/api/v1/users/professor").toString());
		return ResponseEntity.created(uri).body(usuarioService.saveProfessor(professor));
	}
	@PostMapping("/users/aluno")
	public ResponseEntity<Usuario> saveAluno(@RequestBody Aluno aluno) {

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/academico/api/v1/users/aluno").toString());
		return ResponseEntity.created(uri).body(usuarioService.saveAluno(aluno));
	}
	@PostMapping("/users/funcionario")
	public ResponseEntity<Usuario> saveFuncionario(@RequestBody Funcionario funcionario) {

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/academico/api/v1/users/funcionario").toString());
		return ResponseEntity.created(uri).body(usuarioService.saveFuncionario(funcionario));
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<Usuario> findUserById(@PathVariable(value = "id") Long id ) {

		return ResponseEntity.ok().body(usuarioService.findById(id).get());
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody Usuario usuario, @PathVariable(value = "id") Long id) {
		try {
			return ResponseEntity.ok().body(usuarioService.update(id, usuario));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
