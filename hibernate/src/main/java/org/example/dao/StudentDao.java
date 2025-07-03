package org.example.dao;

import org.example.entity.Student;

import java.util.List;

public class StudentDao {
    GenericDao dao = new GenericDao("Vapasi");

    public boolean save (Student stud) {
        return dao.save(stud);
    }

    public Student findById (int id) {
        return dao.findById(Student.class, id);
    }

    public List<Student> findAll () {
        return dao.findAll("FROM Student");
    }

    public boolean delete (int id) {
        return dao.delete(Student.class, id);
    }
}
