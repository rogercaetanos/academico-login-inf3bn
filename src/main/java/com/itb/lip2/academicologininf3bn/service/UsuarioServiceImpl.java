package com.itb.lip2.academicologininf3bn.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.itb.lip2.academicologininf3bn.model.*;
import com.itb.lip2.academicologininf3bn.repository.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.itb.lip2.academicologininf3bn.repository.UsuarioRepository;

import javax.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PapelRepository papelRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Não foi encontrado o usuário no banco de dados");

		}else {
			System.out.println("Usuário encontrado: " + username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		usuario.getPapeis().forEach(papel ->{
			       authorities.add(new SimpleGrantedAuthority(papel.getNomePapel()));
		});
		return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getSenha(), authorities);
	}

	@Override
	public Usuario save(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario saveProfessor(Professor professor) {
		professor.setCodStatusUsuario(true);
		professor.setSenha(passwordEncoder.encode(professor.getSenha()));
		professor.setPapeis(new ArrayList<>());
		addPapelToUsuario(professor, "ROLE_PROFESSOR");
		return usuarioRepository.save(professor);
	}

	@Override
	public Usuario saveAluno(Aluno aluno) {
		aluno.setCodStatusUsuario(true);
		aluno.setSenha(passwordEncoder.encode(aluno.getSenha()));
		aluno.setPapeis(new ArrayList<>());
		addPapelToUsuario(aluno, "ROLE_ALUNO");
		return usuarioRepository.save(aluno);
	}

	@Override
	public Usuario saveFuncionario(Funcionario funcionario) {
		funcionario.setCodStatusUsuario(true);
		funcionario.setSenha(passwordEncoder.encode(funcionario.getSenha()));
		funcionario.setPapeis(new ArrayList<>());
		addPapelToUsuario(funcionario, "ROLE_FUNCIONARIO");
		return usuarioRepository.save(funcionario);
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

	@Override
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}


	@Override
	public Papel savePapel(Papel papel) {
		return papelRepository.save(papel);
	}

	@Override
	public void addPapelToUsuario(Usuario usuario, String papelNome) {
		Papel papel = papelRepository.findByNomePapel(papelNome);
		usuario.getPapeis().add(papel);

	}



}
