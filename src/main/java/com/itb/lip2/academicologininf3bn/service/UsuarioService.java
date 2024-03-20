package com.itb.lip2.academicologininf3bn.service;

import java.util.List;

import com.itb.lip2.academicologininf3bn.model.Usuario;

public interface UsuarioService {
	
	Usuario save(Usuario usuario);
	List<Usuario> findAll();

}
