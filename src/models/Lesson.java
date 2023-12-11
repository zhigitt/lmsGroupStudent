package models;

public class Lesson {
    private int idLesson;
    private String lessonName;
    private String description;

    public Lesson() {
    }

    public Lesson(int idLesson, String lessonName, String description) {
        this.idLesson = idLesson;
        this.lessonName = lessonName;
        this.description = description;
    }


    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "idLesson=" + idLesson +
                ", lessonName='" + lessonName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
