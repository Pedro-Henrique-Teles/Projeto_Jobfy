package com.jobfy.models.entity;

import com.jobfy.validator.ValidCPF;
import com.jobfy.validator.ValidPassword;
import jakarta.persistence.*;

import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "DB_COLABORADOR")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "O Nome do colaborador não pode estar em branco")
    @NotNull(message = "O Nome do colaborador não pode ser nulo")
    @Size(min = 3, message = "O nome do usuario deve possuir ao menos 3 caracteres")
    private String name;


    @Column(unique = true)
    @NotBlank(message = "O Telefone do colaborador não pode estar em branco")
    @NotNull(message = "O Telefone não pode ser nulo")
    private String telefone;

    @NotNull(message = "A Carga Horaria não pode ser nula")
    private double cargaHoraria;

    @NotNull(message = "O Salario não pode ser nulo")
    private double salario;

    @NotBlank(message = "A Escolaridade do colaborador não pode estar em branco")
    @NotNull(message = "O campo escolaridade não pode ser nulo")
    private String escolaridade;


    @NotNull(message = "O Email não pode ser nulo")
    @Email(message = "O email do colaborador deve ser válido")
    @Column(unique = true)
    private String email;

    @NotNull(message = "A senha não pode ser nula")
    @ValidPassword
    private String senha;

    @NotBlank(message = "A Área de Interesse  não pode estar em branco")
    @NotNull(message = "A Área de Interesse não pode estar nula")
    private String areaInteresse;

    @NotNull(message = "A Data de Nascimento não pode ser nula")
    @Past(message = "A Data de Nascimento deve ser no passado")
    private Date dataNascimento;

    @NotNull(message = "O CPF não pode ser nulo")
    @Column(unique = true)
    @ValidCPF(message = "O CPF do colaborador deve ser um CPF válido")
    private String cpf;

    @ManyToOne
    private Empresa empresa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAreaInteresse() {
        return areaInteresse;
    }

    public void setAreaInteresse(String areaInteresse) {
        this.areaInteresse = areaInteresse;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
