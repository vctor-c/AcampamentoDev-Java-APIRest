package br.com.acampamentodev.SpringAPIRest.service;

import br.com.acampamentodev.SpringAPIRest.entities.Student;
import br.com.acampamentodev.SpringAPIRest.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    private Student selectStudent(int matricula) {

        return studentRepository.findBymatricula(matricula);
    }


    public Student getStudent(int matricula) {
        Student selectedStudent = selectStudent(matricula);
        return selectedStudent;
    }

    public Student insert(Student student) {
        studentRepository.insert(student);
        return student;
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }


    public Student update(Student studentsNewData, int matricula) {
        Student selectedStudent = selectStudent(matricula);

            BeanUtils.copyProperties(studentsNewData, selectedStudent);
            studentRepository.save(selectedStudent);

        return selectedStudent;
    }

}
