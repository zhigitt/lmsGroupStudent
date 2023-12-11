package sevice;

import models.Lesson;

public interface LessonService {
    void getStudentsByLessonName(String lessonName);
    void addLessonToGroup(String groupName, Lesson lesson);
    void getLessonByName(String lessonName);
    void getLessonsByGroupName(String groupName);

    void deleteLessonById(int lessonId);
}
