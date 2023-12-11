package models;

public class GenerateId {
    private static int idGroup = 0;
    private static int idStudent = 0;
    private static int idLesson = 0;

    public static int generateIdGroup(){
        return (++idGroup);
    }
    public static int genarateIdStudent(){
        return (++idStudent);
    }

    public static int generateIdLesson(){
        return (++idLesson);
    }

}
