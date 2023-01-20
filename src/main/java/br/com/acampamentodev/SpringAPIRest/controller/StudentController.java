package br.com.acampamentodev.SpringAPIRest.controller;

import br.com.acampamentodev.SpringAPIRest.entities.Student;
import br.com.acampamentodev.SpringAPIRest.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    @Autowired
    StudentService alunoService;
    @GetMapping
    public List<Student> getAll() {
        return alunoService.getAll();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Student> getStudent(@PathVariable int matricula) {
        Student selectedStudent = alunoService.getStudent(matricula);

        if (selectedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(selectedStudent);
    }

    @PostMapping
    public ResponseEntity<Student> inserir(@RequestBody Student student) {
        alunoService.insert(student);
        return ResponseEntity.created(null).body(student);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Student> update(@RequestBody Student studentsNewData, @PathVariable int matricula) {
        Student selectedStudent = alunoService.getStudent(matricula);

        if (selectedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        alunoService.update(studentsNewData, matricula);
        return ResponseEntity.ok().body(selectedStudent);
    }


    @PatchMapping("/{matricula}/atualizarnome")
    public ResponseEntity<Student> updatenome(@RequestParam("nome") String nome, @PathVariable int matricula) {
        Student selectedStudent = alunoService.getStudent(matricula);

        if (selectedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        selectedStudent.setNome(nome);

        alunoService.update(selectedStudent, matricula);
        return ResponseEntity.ok().body(selectedStudent);
    }

    @PatchMapping("/{matricula}/atualizarsobrenome")
    public ResponseEntity<Student> updatesobrenome(@RequestParam("sobrenome") String sobrenome, @PathVariable int matricula) {
        Student selectedStudent = alunoService.getStudent(matricula);

        if (selectedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        selectedStudent.setSobrenome(sobrenome);
        alunoService.update(selectedStudent, matricula);
        return ResponseEntity.ok().body(selectedStudent);
    }

    @PatchMapping("/{matricula}/atualizarcpf")
    public ResponseEntity<Student> updatecpf(@RequestParam("cpf") String cpf, @PathVariable int matricula) {
        Student selectedStudent = alunoService.getStudent(matricula);

        if (selectedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        selectedStudent.setCpf(cpf);
        alunoService.update(selectedStudent, matricula);
        return ResponseEntity.ok().body(selectedStudent);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int matricula) {

        Student selectedStudent = alunoService.getStudent(matricula);

        if (selectedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        alunoService.deleteStudent(selectedStudent);

        return ResponseEntity.ok().body(null);
    }
}
