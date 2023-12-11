import models.*;
import models.db.DataBase;
import sevice.AdminService;
import sevice.GroupService;
import sevice.LessonService;
import sevice.StudentService;
import sevice.impl.AdminServiceImpl;
import sevice.impl.GroupServiceImpl;
import sevice.impl.LessonServiceImpl;
import sevice.impl.StudentServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scStr = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);

        DataBase dataBase = new DataBase();
        GroupService groupService = new GroupServiceImpl(dataBase);
        StudentService studentService = new StudentServiceImpl(dataBase);
        LessonService lessonService = new LessonServiceImpl(dataBase);

        AdminService adminService = new AdminServiceImpl(dataBase);

        dataBase.admin.add(new Admin("Zhigit", "admin", "admin1234"));

        OuterLoop:
        while (true) {
            System.out.println("""
                    Катталган болсонуз 1
                    Парольду унутуп калсаныз 2
                    
                    (login: admin  password: admin1234)
                    """);
            System.out.print("Select: ");
            switch (scInt.nextInt()) {


                case 1 -> {
                    System.out.print("Login жазыыныз: ");
                    String scLogin = scStr.nextLine();

                    System.out.print("Password жазыыныз: ");
                    String scPass = scStr.nextLine();

                    boolean login = adminService.login(scLogin, scPass);

                    InnerLoop:
                    while (login == true) {
                        System.out.println("""
                                1. Жаны группа кошуу.
                                2. Группа издоо аты мн.
                                3. Группаны аты мн жанылоо.
                                4. Бардык группаларды чыгаруу.
                                5. Группага жаны студент кошуу.
                                6. Студентти жанылоо.
                                7. Аты аркылуу студент издоо.
                                8. Группанын аты мн бардык студенттерди чыгаруу.
                                9. Группага жаны сабак кошуу.
                                10. Студентти email аркылуу очуруу.
                                11. Сабак аркылуу бардык студенттерди чыгаруу.
                                12. Сабактын аты аркылуу чыгаруу.
                                13. Группанын аты мн бардык сабактарды чыгаруу.
                                14. Сабакты ID аркылуу очуруу.
                                15. Группаны аты аркылуу очуруу.
                                 0. Аккаунттан чыгуу.
                                """);

                        System.out.print("Select: ");
                        switch (scInt.nextInt()) {
                            case 1 -> {
                                Group group = new Group();

                                System.out.print("Группанын аты: ");
                                group.setGoupName(scStr.nextLine());

                                groupService.addGroup(group);
                            }
                            case 2 -> {
                                System.out.print("Группанын аты: ");
                                String groupName = scStr.nextLine();

                                groupService.findGroupByName(groupName);
                            }
                            case 3 -> {
                                System.out.print("Озгорто турчу группанын аты: ");
                                String groupName = scStr.nextLine();

                                System.out.print("Группанын жаны атын жазыныз: ");
                                String newName = scStr.nextLine();

                                groupService.updateGroupByName(groupName, newName);
                            }
                            case 4 -> {
                                groupService.getAllGroups();
                            }
                            case 5 -> {
                                Student student = new Student();

                                System.out.print("Группанын атын жазыныз: ");
                                String groupName = scStr.nextLine();

                                System.out.print("Аты: ");
                                student.setName(scStr.nextLine());

                                System.out.print("Фамилия: ");
                                student.setLastName(scStr.nextLine());

                                System.out.print("Email: ");
                                student.setEmail(scStr.nextLine());

                                System.out.println("1. felame    2. male");
                                System.out.println("Select: ");
                                int select = scInt.nextInt();
                                if (select == 1) {
                                    student.setGender(Gender.FEMALE);
                                } else if (select == 2) {
                                    student.setGender(Gender.MALE);
                                }

                                studentService.addStudent(groupName, student);
                            }
                            case 6 -> {
                                System.out.print("Студенттин атын жазыныз: ");
                                String name = scStr.nextLine();

                                System.out.print("Студенттин жаны атын жазыныз: ");
                                String newName = scStr.nextLine();

                                studentService.updateStudentByName(name, newName);
                            }
                            case 7 -> {
                                System.out.print("Студенттин атын жазыныз: ");
                                String name = scStr.nextLine();

                                studentService.findStudentByName(name);
                            }
                            case 8 -> {
                                System.out.print("Группанын атын жазыныз: ");
                                String groupName = scStr.nextLine();

                                studentService.getStudentsByGroupName(groupName);
                            }
                            case 9 -> {
                                Lesson lesson = new Lesson();

                                System.out.print("Группанын атын жазыныз: ");
                                String groupName = scStr.nextLine();

                                System.out.print("Сабактын атын жазыныз: ");
                                lesson.setLessonName(scStr.nextLine());

                                System.out.print("Описание: ");
                                lesson.setDescription(scStr.nextLine());

                                lessonService.addLessonToGroup(groupName, lesson);
                            }
                            case 10 -> {
                                System.out.print("Студенттин email: ");
                                String email = scStr.nextLine();

                                studentService.deleteStudentByEmail(email);
                            }
                            case 11 -> {
                                System.out.print("Сабактын аты: ");
                                String lessonName = scStr.nextLine();

                                lessonService.getStudentsByLessonName(lessonName);
                            }
                            case 12 -> {
                                System.out.print("Cабактын аты: ");
                                String lessonName = scStr.nextLine();

                                lessonService.getLessonByName(lessonName);
                            }
                            case 13 -> {
                                System.out.print("Группанын аты: ");
                                String groupName = scStr.nextLine();

                                lessonService.getLessonsByGroupName(groupName);
                            }
                            case 14 -> {
                                System.out.print("Сабактыг ID: ");
                                int lessonId = scInt.nextInt();

                                lessonService.deleteLessonById(lessonId);
                            }
                            case 15 -> {
                                System.out.print("Очуро турчу группанын аты: ");
                                String groupName = scStr.nextLine();

                                groupService.deleteGroupByName(groupName);
                            }
                            case 0 -> {
                                break InnerLoop;
                            }
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Login жазыныз: ");
                    String scLogin = scStr.nextLine();

                    adminService.forgotPassword(scLogin);
                }
            }
        }
    }
}