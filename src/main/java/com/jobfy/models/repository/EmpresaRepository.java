package com.jobfy.models.repository;

import com.jobfy.models.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    List<Empresa> findByName(String name);
    Empresa findByCnpj(String cnpj);
    Empresa findByEmail(String email);
    List<Empresa> findByVagas(Double vagas);

    List<Empresa> findBySetorAtividade(String setorAtividade);


}
