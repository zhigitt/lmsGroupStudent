package sevice.impl;

import models.GenerateId;
import models.Group;
import models.Lesson;
import models.db.DataBase;
import sevice.LessonService;

import java.util.ArrayList;
import java.util.Iterator;

public class LessonServiceImpl implements LessonService {

    DataBase dataBase;

    public LessonServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override

    public void addLessonToGroup(String groupName, Lesson lesson) {
        for (Group group : dataBase.groups) {
            if (group.getGoupName().equalsIgnoreCase(groupName)) {
                lesson.setIdLesson(GenerateId.generateIdLesson());
                group.getLessons().add(lesson);
                System.out.println("Сабак кошулду!");
                return;
            }
        }
        System.out.println("Мындай группа жок!");
    }

    @Override
    public void getLessonsByGroupName(String groupName) {
        for (Group group : dataBase.groups) {
            if (group.getGoupName().equalsIgnoreCase(groupName)) {
                System.out.println(group.getLessons());
                return;
            }
        }
        System.out.println("Мындай группа жок!");
    }

    @Override
    public void getStudentsByLessonName(String lessonName) {
        for (Group group : dataBase.groups) {
            for (Lesson lesson : group.getLessons()) {
                if (lesson.getLessonName().equalsIgnoreCase(lessonName)) {
                    System.out.println(group.getLessons());
                    System.out.println(group.getStudents());
                    return;
                }
            }
        }
    }

    @Override
    public void getLessonByName(String lessonName) {
        for (Group group : dataBase.groups) {
            for (Lesson lesson : group.getLessons()) {
                if (lesson.getLessonName().equalsIgnoreCase(lessonName)) {
                    System.out.println(lesson);
                    return;
                }
            }
        }
        System.out.println("Мындай сабак жок!");
    }

    @Override
    public void deleteLessonById(int lessonId) {
        Iterator<Group> groupIterator = dataBase.groups.iterator();

        while (groupIterator.hasNext()) {
            Group group = groupIterator.next();
            ArrayList<Lesson> lessons = group.getLessons();

            Iterator<Lesson> lessonIterator = lessons.iterator();

            while (lessonIterator.hasNext()) {
                Lesson lesson = lessonIterator.next();

                if (lesson.getIdLesson() == lessonId) {
                    lessonIterator.remove();
                    System.out.println("Сабак очурулду!");
                    return;
                }
            }
        }
        System.out.println("Мындай сабак жок!");
    }
}

