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
    public List<Colaborador> findAll(){
        return colaboradorRepository.findAll();
    }

    public Colaborador findById(Integer id) throws Exception{
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isEmpty()){
            throw new Exception("Colaborador com ID " + id + " não encontrado.");
        }
        return colaborador.get();
    }


    public Colaborador save(Colaborador colaborador) throws Exception{
        validateName(colaborador.getName());
        validateTelefone(colaborador.getTelefone(), colaborador.getId());
        validateEmail(colaborador.getEmail(), colaborador.getId());
        validateDataNascimento(colaborador.getDataNascimento());
        validateSenha(colaborador.getSenha());
        validateAreaInteresse(colaborador.getAreaInteresse());
        validateCpf(colaborador.getCpf(), colaborador.getId());
        validateEscolaridade(colaborador.getEscolaridade());

        return colaboradorRepository.save(colaborador);
    }

    private void validateName(String name) throws Exception {
        if (name == null || name.length() < 3) {
            throw new Exception("O nome do colaborador deve ter ao menos 3 caracteres");
        }
    }

    private void validateCpf(String cpf, long id) throws Exception {
        if (!CpfValidator.isValid(cpf)) {
            throw new Exception("CPF invalido");
        }
        Colaborador colaboradorExistenteCpf = colaboradorRepository.findByCpf(cpf);
        if (colaboradorExistenteCpf != null && colaboradorExistenteCpf.getId() != id) {
            throw new Exception("Este CPF já existe");
        }
    }

    private void validateTelefone(String telefone, Long id) throws Exception {
        Colaborador colaboradorExistenteTelefone = colaboradorRepository.findByTelefone(telefone);
        if (colaboradorExistenteTelefone != null && colaboradorExistenteTelefone.getId() != id) {
            throw new Exception("Este Telefone já existe");
        }
    }

    private void validateEscolaridade(String escolaridade ) throws Exception {
        if(escolaridade == null || escolaridade.trim().isEmpty()){
            throw new Exception("A escolaridade não pode ser vazia");
        }
    }


    private void validateEmail(String email, Long id) throws Exception {
        if (email == null || !email.contains("@")) {
            throw new Exception("O email deve ser válido");
        }

        Colaborador colaboradorExistenteEmail = colaboradorRepository.findByEmail(email);
        if (colaboradorExistenteEmail != null && colaboradorExistenteEmail.getId() != id) {
            throw new Exception("Este Email já existe");
        }
    }

    private void validateSenha(String senha) throws Exception {
        if (senha == null || senha.length() < 6 || !senha.matches(".*[A-Z].*") || !senha.matches(".*\\W.*")) {
            throw new Exception("A senha deve ter ao menos 6 caracteres e apresentar ao menos uma letra maiúscula" +
                    " e um caractere especial");
        }
    }

    private void validateAreaInteresse(String areaInteresse) throws Exception {
        if (areaInteresse == null) {
            throw new Exception("Qual área lhe interessa ?");
        }
    }
    private void validateDataNascimento(java.util.Date dataNascimentoDate) throws Exception {
        if (dataNascimentoDate == null) {
            throw new Exception("A data de nascimento não pode ser nula");
        }

        LocalDate dataNascimento = dataNascimentoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (dataNascimento.isAfter(LocalDate.now()) || Period.between(dataNascimento, LocalDate.now()).getYears() < 16) {
            throw new Exception("A data deve ser no passado, e a idade deve ser igual ou maior que 16 anos");
        }
    }






    public Colaborador delete(Integer id) throws Exception{
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isEmpty()){
            throw new Exception("Colaborador não encontrado");
        }
        colaboradorRepository.delete(colaborador.get());
        return colaborador.get();
    }



    public long cont() {
        return colaboradorRepository.count();
    }




    public Colaborador create(Colaborador colaborador) throws Exception{
        if (colaborador.getEscolaridade() == null) {
            throw new Exception("A escolaridade não pode ser nula");
        }
        if (colaboradorRepository.findByTelefone(colaborador.getTelefone()) != null){
            throw new Exception("Este Telefone já existe");
        }
        return save(colaborador);
    }

}

