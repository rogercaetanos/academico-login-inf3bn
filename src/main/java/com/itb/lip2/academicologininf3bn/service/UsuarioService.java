package com.itb.lip2.academicologininf3bn.service;

import java.util.List;
import java.util.Optional;

import com.itb.lip2.academicologininf3bn.model.*;

public interface UsuarioService {
	
	Usuario save(Usuario usuario);
	Usuario saveProfessor(Professor professor);
	Usuario saveAluno (Aluno aluno);
	Usuario saveFuncionario(Funcionario funcionario);

	List<Usuario> findAll();

	Optional<Usuario> findById(Long id);

	Usuario update(Long id, Usuario usuario) throws Exception;

	Papel savePapel(Papel papel);
	void addPapelToUsuario(Usuario usuario, String papelNome);

	Usuario findByEmail(String email);



}
