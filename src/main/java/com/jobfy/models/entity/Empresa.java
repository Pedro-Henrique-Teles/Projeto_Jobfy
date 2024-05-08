package com.jobfy.models.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DB_EMPRESA")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O Nome não pode ser nulo")
    @NotBlank(message = "O Nome não pode estar em branco")
    @Size(min = 3, message = "O Nome do usuario deve possuir ao menos 3 caracteres")
    private String name;





}
