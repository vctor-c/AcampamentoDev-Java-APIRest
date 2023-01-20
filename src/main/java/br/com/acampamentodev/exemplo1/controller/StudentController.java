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
    private List<Student>StudentList = new ArrayList<>();
    @GetMapping
    public List<Student> getAll(){
        return StudentList;
    }
    @GetMapping ("/{matricula}")
    public Student getStudent(@PathVariable int matricula){
        for (Student student : StudentList){
            if (student.getMatricula() == matricula){
                return student;
            }

        }
       return StudentList.get(matricula);
    }

    @PostMapping
    public ResponseEntity<Student> inserir(@RequestBody Student student){
        StudentList.add(student);
        return ResponseEntity.created(null).body(student);
    }

    @PutMapping("/{matricula}")
    public void update(@RequestBody Student studentsNewData, @PathVariable int matricula){
        for (Student student : StudentList){
            if (student.getMatricula() == matricula){
                BeanUtils.copyProperties(studentsNewData, student);
            }

        }
    }

    @PatchMapping("/{matricula}/atualizarnome")
    public void updatenome(@RequestParam("nome") String nome, @PathVariable int matricula){
        for (Student student : StudentList){
            if (student.getMatricula() == matricula){
                student.setNome(nome);
            }

        }
    }

    @PatchMapping("/{matricula}/atualizarsobrenome")
    public void updatesobrenome(@RequestParam("sobrenome") String sobrenome, @PathVariable int matricula){
        for (Student student : StudentList){
            if (student.getMatricula() == matricula){
                student.setSobrenome(sobrenome);
            }

        }
    }
    @PatchMapping("/{matricula}/atualizarcpf")
    public void updatecpf(@RequestParam("cpf") String cpf, @PathVariable int matricula){
        for (Student student : StudentList){
            if (student.getMatricula() == matricula){
                student.setCpf(cpf);
            }

        }
    }

    @DeleteMapping("/{matricula}")
    public void deleteStudent(@PathVariable int matricula){
        for (Student student : StudentList){
            if (student.getMatricula() == matricula){
                StudentList.remove(student);
            }

        }
    }

}
