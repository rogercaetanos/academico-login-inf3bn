package com.itb.lip2.academicologininf3bn.service;


import com.itb.lip2.academicologininf3bn.model.Aluno;
import com.itb.lip2.academicologininf3bn.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno update(Long id, Aluno aluno) throws Exception {

        return alunoRepository.findById(id).map(al->{
            al.setNome(aluno.getNome());
            al.setRm(aluno.getRm());
            al.setEmail(aluno.getEmail());
            al.setCodStatusUsuario(aluno.isCodStatusUsuario());
            al.setTipoUsuario(aluno.getTipoUsuario());
            return alunoRepository.save(al);
        }).orElseThrow(()-> new Exception("Aluno não encontrado!"));
    }
}
