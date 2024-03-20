package com.itb.lip2.academicologininf3bn.model;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id   // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-Incremento
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String tipoUsuario;
	private boolean codStatusUsuario;
	
	// FetchType.EAGER -> Traz todas as classes relacionadas
	// FetchType.Lazy  -> Não traz as classes relacionadas
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL) // M:N
	@JoinTable(
			  name="usuarios_papeis",
			  joinColumns = @JoinColumn(name="usuario_id", referencedColumnName = "id"),           // FK
			  inverseJoinColumns = @JoinColumn(name="papel_id", referencedColumnName = "id")       // FK
			)
	private Collection<Papel> papeis;  // Coleção de papeis
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public boolean isCodStatusUsuario() {
		return codStatusUsuario;
	}
	public void setCodStatusUsuario(boolean codStatusUsuario) {
		this.codStatusUsuario = codStatusUsuario;
	}
	
	
	public Collection<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(Collection<Papel> papeis) {
		this.papeis = papeis;
	}
	
	// Evitar que o mesmo objeto seja adicionado em coleções mais de uma vez 
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	// Grava o objeto na coleção de forma que a pesquisa seja mais eficiente
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
