package br.com.acampamentodev.SpringAPIRest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {
    private int matricula;
    private String nome;
    private String sobrenome;
    private String cpf;

}
