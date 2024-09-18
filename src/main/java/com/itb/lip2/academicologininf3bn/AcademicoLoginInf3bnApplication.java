package com.itb.lip2.academicologininf3bn;

import com.itb.lip2.academicologininf3bn.model.Papel;
import com.itb.lip2.academicologininf3bn.repository.PapelRepository;
import com.itb.lip2.academicologininf3bn.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AcademicoLoginInf3bnApplication {

	public static void main(String[] args) {

		SpringApplication.run(AcademicoLoginInf3bnApplication.class, args);
	}

	// Podemos realizar ações no momento em que subimos a aplicação, vamos cadastrar os papeis
	@Bean
	CommandLineRunner run(UsuarioService usuarioService, PapelRepository papelRepository) {
		return args -> {
		    	if(papelRepository.findAll().size() == 0) {
					usuarioService.savePapel(new Papel(null, "ROLE_PROFESSOR"));
					usuarioService.savePapel(new Papel(null, "ROLE_ALUNO"));
					usuarioService.savePapel(new Papel(null, "ROLE_FUNCIONARIO"));
					usuarioService.savePapel(new Papel(null, "ROLE_ADMIN"));
				}else {
					System.out.println("Papeis já criados no banco de dados!");
				}
		};
	}

}
