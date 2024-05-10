package com.jobfy.service;

import com.jobfy.models.entity.Colaborador;
import com.jobfy.models.repository.ColaboradorRepository;
import com.jobfy.validador.CpfValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository){
        this.colaboradorRepository = colaboradorRepository;
    }
    /*--------------------------Método FindAll|--------------------------*/
    public List<Colaborador> findAll(){
        return colaboradorRepository.findAll();
    }
//    --------------------------------------------------------------------

    /*--------------------------Método FindAll|--------------------------*/
    public Colaborador findById(Integer id) throws Exception{
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (!colaborador.isPresent()){
            throw new Exception("Colaborador não encontrado");
        }
        return colaborador.get();
    }
    //------------------------------------------------------------------------

    /*-----------------------------Método Post-----------------------------*/
    public Colaborador save(Colaborador colaborador) throws Exception{
        if (colaborador.getName() == null || colaborador.getName().length()<3){
            throw new Exception("O nome do colaborador deve ter ao menos 3 caracteres");
        }
        if (colaborador.getTelefone() == null || colaborador.getTelefone().length()<11){
            throw new Exception("O telefone do colaborador deve ter ao menos 11 dígitos contando seu (DDD)");
        }
        if (colaboradorRepository.findByTelefone(colaborador.getTelefone()) != null){
            throw new Exception("Este Telefone já existe");
        }
        if (colaborador.getEscolaridade() == null) {
            throw new Exception("A escolaridade não pode ser nula");
        }
        java.util.Date dataNascimentoDate = colaborador.getDataNascimento();
        if (dataNascimentoDate == null) {
            throw new Exception("A data de nascimento não pode ser nula");
        }
        LocalDate dataNascimento = dataNascimentoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (dataNascimento.isAfter(LocalDate.now()) || Period.between(dataNascimento, LocalDate.now()).getYears() < 16) {
            throw new Exception("A data deve ser no passado, e a idade deve ser igual ou maior que 16 anos");
        }
        String senha = colaborador.getSenha();
        if (senha == null || senha.length() < 6 || !senha.matches(".*[A-Z].*") || !senha.matches(".*\\W.*")){
            throw new Exception("A senha deve ter ao menos 6 caracteres e apresentar ao menos uma letra maiúscula" +
                    " e um caractere especial");
        }
        if (colaborador.getAreaInteresse() == null){
            throw new Exception("Você deve possui um interesse");
        }
        if (colaborador.getAreaInteresse() == null){
            throw new Exception("Qual área lhe interessa ?");
        }
        if (!CpfValidator.isValid(colaborador.getCpf())){
            throw new Exception("CPF invalido");
        }



        return colaboradorRepository.save(colaborador);
    }
//-----------------------------------------------------------------------------------------------------------------------








    /*-----------------------------Método Delete-----------------------------*/
    public Colaborador delete(Integer id) throws Exception{
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (!colaborador.isPresent()){
            throw new Exception("Aluno não encontrado");
        }
        colaboradorRepository.delete(colaborador.get());
        return colaborador.get();
    }
//-----------------------------------------------------------------------------------------------------------------------


}

