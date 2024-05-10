package com.jobfy.service;

import com.jobfy.models.entity.Colaborador;
import com.jobfy.models.repository.ColaboradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository){
        this.colaboradorRepository = colaboradorRepository;
    }
    public List<Colaborador> findAll(){
        return colaboradorRepository.findAll();
    }
    public Colaborador findById(Integer id) throws Exception{
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (!colaborador.isPresent()){
            throw new Exception("Colaborador não encontrado");
        }
        return colaborador.get();
    }
    public Colaborador save(Colaborador colaborador) throws Exception{
        if (colaborador.getName() == null || colaborador.getName().length()<3){
            throw new Exception("O nome do colaborador deve ter ao menos 3 caracteres");
        }
        return colaboradorRepository.save(colaborador);
    }


}
