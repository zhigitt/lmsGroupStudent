package sevice.impl;

import models.GenerateId;
import models.Group;
import models.Student;
import models.db.DataBase;
import sevice.StudentService;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentServiceImpl implements StudentService {
    DataBase dataBase;

    @Override
    public void getStudentsByGroupName(String groupName) {
        for (Group group : dataBase.groups) {
            if (group.getGoupName().equalsIgnoreCase(groupName)){
                System.out.println(group.getStudents());
                return;
            }
        }
        System.out.println("Мындай группа жок!");
    }

    public StudentServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void addStudent(String groupName, Student student) {
        for (Group group : dataBase.groups) {
            if (group.getGoupName().equalsIgnoreCase(groupName)){
                group.getStudents().add(student);
                student.setIdStudent(GenerateId.genarateIdStudent());
                System.out.println("Жаны студент кошулду");
                return;
            }
        }
        System.out.println("Мындай группа жок!");

    }

    @Override
    public void updateStudentByName(String studentName, String newName) {
        for (Group group : dataBase.groups) {
            for (Student student : group.getStudents()) {
                if (student.getName().equalsIgnoreCase(studentName)){
                    student.setName(newName);
                    return;
                }
            }
        }
        System.out.println("Мындай студент жок!");
    }

    @Override
    public void findStudentByName(String studentName) {
        for (Group group : dataBase.groups) {
            for (Student student : group.getStudents()) {
                if (student.getName().equalsIgnoreCase(studentName)){
                    System.out.println(student);
                    return;
                }
            }
        }
        System.out.println("Мындай студент жок!");
    }

    @Override
    public void deleteStudentByEmail(String email) {
        Iterator<Group> iterator = dataBase.groups.iterator();

        while (iterator.hasNext()){
            Group group = iterator.next();
            ArrayList<Student> students = group.getStudents();

            Iterator<Student> studentIterator = students.iterator();

            while (studentIterator.hasNext()){
                Student student = studentIterator.next();

                if (student.getEmail().equalsIgnoreCase(email)){
                    studentIterator.remove();
                    System.out.println("Студент очурулду!");
                }
            }
            System.out.println("Мындай студент жок");

        }

    }
}
