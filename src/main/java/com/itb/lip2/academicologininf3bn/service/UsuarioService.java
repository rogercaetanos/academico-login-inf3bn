package com.itb.lip2.academicologininf3bn.service;

import java.util.List;
import java.util.Optional;

import com.itb.lip2.academicologininf3bn.model.Papel;
import com.itb.lip2.academicologininf3bn.model.Usuario;

public interface UsuarioService {
	
	Usuario save(Usuario usuario);
	List<Usuario> findAll();

	Optional<Usuario> findById(Long id);

	Usuario update(Long id, Usuario usuario) throws Exception;

	Papel savePapel(Papel papel);
	void addPapelToUsuario(String email, String papelNome);

	Usuario findByEmail(String email);



}
