package br.com.acampamentodev.SpringAPIRest.repository;

import br.com.acampamentodev.SpringAPIRest.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {


    Student findBymatricula(int matricula);
}
