package com.jobfy.models.repository;

import com.jobfy.models.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    boolean existsByCpf(String cpf);


    List<Colaborador> findByName(String nome);

    Colaborador findByCpf(String cpf);

    Colaborador findByTelefone(String telefone);

    List<Colaborador> findBycargaHoraria(Double cargaHoraria);

    List<Colaborador> findBySalario(Double salario);
    List<Colaborador> findByEscolaridade(String escolaridade);
    List<Colaborador> findByAreaInteresse(String areaInteresse);
    Colaborador findByEmail(String email);


}
