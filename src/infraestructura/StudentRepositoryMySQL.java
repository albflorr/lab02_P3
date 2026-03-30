/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura;

import dominio.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryMySQL implements IStudentRepository {
    @Override
    public void save(Student student) {
        String sql = "INSERT INTO students (code, name, address, phone, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getCode());
            ps.setString(2, student.getName());
            ps.setString(3, student.getAddress());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DatabaseConnection.getInstance();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(
                    rs.getString("code"), rs.getString("name"),
                    rs.getString("address"), rs.getString("phone"), rs.getString("email")
                ));
            }
        } catch (SQLException e) {e.printStackTrace();}
        return list;
    }

    @Override
    public void delete(String code) {
    }

    @Override
    public void update(Student student) {
    }
}
