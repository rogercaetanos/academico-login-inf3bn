package com.itb.lip2.academicologininf3bn.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import com.itb.lip2.academicologininf3bn.model.Usuario;
import com.itb.lip2.academicologininf3bn.repository.UsuarioRepository;

import javax.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario save(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	// Método genérico para atualizar "algumas informações" do usuário (aceita qualquer tipo de usuário)

	@Override
	@Transactional
	public Usuario update(Long id, Usuario usuario) throws Exception {
		return usuarioRepository.findById(id).map(user ->{
			user.setNome(usuario.getNome());
			user.setEmail(usuario.getEmail());
			user.setTipoUsuario(usuario.getTipoUsuario());
			user.setCodStatusUsuario(usuario.isCodStatusUsuario());
			return usuarioRepository.save(user);
		}).orElseThrow(()-> new ExpressionException("Usuário não encontrado!"));
	}
}
