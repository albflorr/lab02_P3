/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package infraestructura;

import dominio.Student;
import java.util.List;

public interface IStudentRepository {
    void save(Student student);
    List<Student> findAll();
    void delete(String code);
    void update(Student student);
}
