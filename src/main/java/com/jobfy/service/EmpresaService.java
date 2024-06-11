package com.jobfy.service;

import com.jobfy.models.entity.Empresa;
import com.jobfy.models.repository.EmpresaRepository;
import com.jobfy.validador.CnpjValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> findAll(){
        return empresaRepository.findAll();
    }
    public Empresa findById(Integer id) throws Exception {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isEmpty()){
            throw new Exception("Empresa com ID " + id + " não encontrada.");
        }
        return empresa.get();
    }


    public Empresa save(Empresa empresa) throws Exception{
        validateName(empresa.getName());
        validateCnpj(empresa.getCnpj(), empresa.getId());
        validateSetorAtividade(empresa.getSetorAtividade());
        validateEmail(empresa.getEmail(), empresa.getId());
        validateVagas(empresa.getVagas());
        return empresaRepository.save(empresa);
    }

    private void validateName(String name) throws Exception{
        if (name == null || name.length() < 3) {
            throw new Exception("O nome da empresa deve ter ao menos 3 caracteres");
        }
    }

    private void validateCnpj(String cnpj, long id) throws Exception{
        if (!CnpjValidator.isValid(cnpj)) {
            throw new Exception("CNPJ invalido");
        }
        Empresa empresaExistenteCnpj = empresaRepository.findByCnpj(cnpj);
        if (empresaExistenteCnpj != null && empresaExistenteCnpj.getId() != id){
            throw new Exception("Este CNPJ já existe");
        }
    }
    private void validateSetorAtividade(String setorAtividade) throws Exception{
        if (setorAtividade == null || setorAtividade.trim().isEmpty()){
            throw new Exception("O Setor de Atividade não pode ser vazio");
        }
    }
    private void validateEmail(String email, long id) throws Exception {
        if (email == null || !email.contains("@")) {
            throw new Exception("O email deve ser valido");
        }
        Empresa empresaExistenteEmail = empresaRepository.findByEmail(email);
        if (empresaExistenteEmail != null && empresaExistenteEmail.getId() != id){
            throw new Exception("Este Email já existe");
        }

    }
    private void validateVagas(double vagas) throws Exception {
        if (vagas > 1000.0){
            throw new Exception("O número de vagas deve ser menor que mil");
        }
    }

    public Empresa delete(Integer id) throws Exception {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isEmpty()){
            throw new Exception("Empresa não encontrada");
        }
        empresaRepository.delete(empresa.get());
        return empresa.get();
    }


    public long cont() {
        return empresaRepository.count();
    }


    public Empresa create(Empresa empresa) throws Exception{
        if (empresa.getSetorAtividade() == null) {
            throw new Exception("A Area de Interesse não pode ser nula");
        }
        return save(empresa);
    }


}
