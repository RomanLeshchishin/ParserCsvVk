import java.util.ArrayList;
import java.util.Objects;

public class Student extends Person {
    private Course course;
    private final String group;

    public Student(String surnameName, String group) {
        super(surnameName);
        this.group = group;
    }

    public void addCourse(Course course) {
        this.course = course;
    }

    public String getFinalScores() {
        return "Итог\n Активности: " + course.getActivityScore() + " из " + this.course.getActivityMaxScore() + "\n Упражнения: " + this.course.getExercisesScore() + " из " + this.course.getExercisesMaxScore() + "\n Домашние работы: " + this.course.getHomeworkScore() + " из " + this.course.getHomeworkMaxScore() + "\n Сем: " + this.course.getSemScore() + " из " + this.course.getSemMaxScore();
    }

    public String getResultModules() {
        var modules = course.getModules();
        var result = new StringBuilder();
        for(var i: modules)
            result.append(i);
        return result.toString();
    }

    public ArrayList<Topic> getModules() {
        return course.getModules();
    }

    public Topic getModule(String moduleName) {
        var modules = course.getModules();
        for(var i: modules){
            if(Objects.equals(moduleName, i.getModuleName()))
                return i;
        }
        return null;
    }

    public String toString() {
        return super.getSurnameName() + "\nГруппа: " + group;
    }
}
