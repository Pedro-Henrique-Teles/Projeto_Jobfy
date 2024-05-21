package com.jobfy.models.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "DB_EMPRESA")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "empresa")
    @JsonIgnore
    private List<Colaborador> colaboradores;

    @NotNull(message = "O Nome não pode ser nulo")
    @NotBlank(message = "O Nome não pode estar em branco")
    @Size(min = 3, message = "O Nome do usuario deve possuir ao menos 3 caracteres")
    private String name;

    @NotNull(message = "O CNPJ não pode ser nulo")
    @Column(unique = true)
    @CNPJ
    private String cnpj;

    @Email (message = "O email do colaborador deve ser válido")
    @NotNull(message = "O Email não pode ser nulo")
    @Column(unique = true)
    private String email;

    @NotNull(message = "O Campo Setor de Atividade não pode ser nulo")
    @NotBlank(message = "O Campo Setor de Atividade não pode estar em branco")
    private String setorAtividade;

    @Min(0)
    @Max(1000)
    private int vagas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSetorAtividade() {
        return setorAtividade;
    }

    public void setSetorAtividade(String setorAtividade) {
        this.setorAtividade = setorAtividade;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
}
