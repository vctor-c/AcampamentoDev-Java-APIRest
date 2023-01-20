package br.com.acampamentodev.SpringAPIRest.service;

import br.com.acampamentodev.SpringAPIRest.entities.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> StudentList = new ArrayList<>();

    public List<Student> getAll() {
        return StudentList;
    }

    private Student selectStudent(int matricula) {
        Student selectedStudent = null;
        for (Student student : StudentList) {
            if (student.getMatricula() == matricula) {
                selectedStudent = student;
            }
        }
        return selectedStudent;
    }


    public Student getStudent(int matricula) {
        Student selectedStudent = selectStudent(matricula);
        return selectedStudent;
    }

    public Student insert(Student student) {
        StudentList.add(student);
        return student;
    }

    public void deleteStudent(Student student) {
            StudentList.remove(student);
    }




    public Student update(Student studentsNewData, int matricula) {
        Student selectedStudent = selectStudent(matricula);

        if (selectedStudent != null) {
            BeanUtils.copyProperties(studentsNewData, selectedStudent);
        }

        return selectedStudent;
    }

}
