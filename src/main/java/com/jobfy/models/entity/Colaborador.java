package com.jobfy.models.entity;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DB_COLABORADOR")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "O Nome do colaborador não pode ser nulo")
    @Size(min = 3, message = "O nome do usuario deve possuir ao menos 3 caracteres")
    private String name;


    @NotNull(message = "O Telefone não pode ser nulo")
    private String telefone;

    @NotNull(message = "A Carga Horaria não pode ser nula")
    private double cargaHoraria;

    @NotNull(message = "O Salario não pode ser nulo")
    private double salario;

    @NotNull(message = "O campo escolaridade não pode ser nulo")
    private double escolaridade;


    @NotNull(message = "O Email não pode ser nulo")
    @Email(message = "O email do colaborador deve ser válido")
    @Column
    private double email;






}
