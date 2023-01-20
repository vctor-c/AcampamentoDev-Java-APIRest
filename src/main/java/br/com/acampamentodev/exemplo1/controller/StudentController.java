package br.com.acampamentodev.exemplo1.controller;

import br.com.acampamentodev.exemplo1.entities.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private List<Student> StudentList = new ArrayList<>();

    private Student selectStudent(int matricula) {
        Student selectedStudent = null;
        for (Student student : StudentList) {
            if (student.getMatricula() == matricula) {
                selectedStudent = student;
            }
        }
        return selectedStudent;
    }

    @GetMapping
    public List<Student> getAll() {
        return StudentList;
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Student> getStudent(@PathVariable int matricula) {
        Student selectedStudent = selectStudent(matricula);

        if (selectedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(selectedStudent);
    }

    @PostMapping
    public ResponseEntity<Student> inserir(@RequestBody Student student) {
        StudentList.add(student);
        return ResponseEntity.created(null).body(student);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Student> update(@RequestBody Student studentsNewData, @PathVariable int matricula) {
        Student selectedStudent = selectStudent(matricula);

        if (selectedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(studentsNewData, selectedStudent);

        return ResponseEntity.ok().body(selectedStudent);
    }


    @PatchMapping("/{matricula}/atualizarnome")
    public ResponseEntity<Student> updatenome(@RequestParam("nome") String nome, @PathVariable int matricula) {
        Student selectedStudent = selectStudent(matricula);

        if (selectedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        selectedStudent.setNome(nome);

        return ResponseEntity.ok().body(selectedStudent);
    }

    @PatchMapping("/{matricula}/atualizarsobrenome")
    public ResponseEntity<Student> updatesobrenome(@RequestParam("sobrenome") String sobrenome, @PathVariable int matricula) {
        Student selectedStudent = selectStudent(matricula);

        if (selectedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        selectedStudent.setSobrenome(sobrenome);

        return ResponseEntity.ok().body(selectedStudent);
    }

    @PatchMapping("/{matricula}/atualizarcpf")
    public ResponseEntity<Student> updatecpf(@RequestParam("cpf") String cpf, @PathVariable int matricula) {
        Student selectedStudent = selectStudent(matricula);

        if (selectedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        selectedStudent.setCpf(cpf);

        return ResponseEntity.ok().body(selectedStudent);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int matricula) {

        Student selectedStudent = selectStudent(matricula);

        if (selectedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        StudentList.remove(selectedStudent);

        return ResponseEntity.ok().body(selectedStudent);
    }

}
