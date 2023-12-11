package sevice;

import models.Student;

public interface StudentService {
    void addStudent(String gropupName, Student student);

    void updateStudentByName(String studentName, String newName);

    void findStudentByName(String studentName);
    void getStudentsByGroupName(String groupName);

    void deleteStudentByEmail(String email);
}
