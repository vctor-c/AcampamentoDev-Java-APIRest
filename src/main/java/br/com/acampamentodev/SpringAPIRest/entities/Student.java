package br.com.acampamentodev.SpringAPIRest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int matricula;
    private String nome;
    private String sobrenome;
    private String cpf;

}
