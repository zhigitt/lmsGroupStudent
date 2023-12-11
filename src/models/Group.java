package models;

import java.util.ArrayList;

public class Group {
    private int idGroup;
    private String groupName;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Lesson> lessons = new ArrayList<>();

    public Group() {
    }

    public Group(int idGroup, String goupName, ArrayList<Student> students, ArrayList<Lesson> lessons) {
        this.idGroup = idGroup;
        this.groupName = goupName;
        this.students = students;
        this.lessons = lessons;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getGoupName() {
        return groupName;
    }

    public void setGoupName(String goupName) {
        this.groupName = goupName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Group{" +
                "idGroup=" + idGroup +
                ", goupName='" + groupName + '\'' +
                ", students=" + students +
                ", lessons=" + lessons +
                '}';
    }
}
