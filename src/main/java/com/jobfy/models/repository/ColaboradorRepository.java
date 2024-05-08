package com.jobfy.models.repository;

import com.jobfy.models.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface    ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
    List<Colaborador> findByName(String nome);

    Colaborador findByCpf(String cpf);

    Colaborador findByTelefone(String telefone);

    List<Colaborador> findBycargaHoraria(Double cargaHoraria);

    List<Colaborador> findBySalario(Double salario);
    List<Colaborador> findByEscolaridade(String escolaridade);
    List<Colaborador> findByAreaInteresse(String areaInteresse);

}
