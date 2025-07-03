package org.example.dao;

import org.example.entity.Customer;
import org.example.entity.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestStudentDao {
    private static StudentDao dao;

    @BeforeAll
    public static void init () {
        dao = new StudentDao();
    }

//    @Test
//    public void testSave() {
//        Student c1 = new Student(1, "Jacob", "CSE", 70);
//        assertTrue(dao.save(c1));
//    }

    @Test
    public void testFindById () {
        Student stud = dao.findById(1);
        assertNotNull(stud);
        System.out.println(stud);
    }

    @Test
    public void testFindAll () {
        List<Student> stud = dao.findAll();
        assertFalse(stud.isEmpty());
    }

    @Test
    public void testDelete () {
        boolean stud = dao.delete(1);
        List<Student> s1 = dao.findAll();
        assertTrue(s1.isEmpty());
    }
}
