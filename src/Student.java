import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Student extends Person {
    private Course course;
    private final String group;

    public Student(String group, String surnameName) {
        super(surnameName);
        this.group = group;
    }

    public void addCourse(Course course) {
        this.course = course;
    }

    public String getFinalScores() {
        float var10000 = this.course.getActivityScore();
        return "Итог\n Активности: " + var10000 + " из " + this.course.getActivityMaxScore() + "\n Упражнения: " + this.course.getExercisesScore() + " из " + this.course.getExercisesMaxScore() + "\n Домашние работы: " + this.course.getHomeworkScore() + " из " + this.course.getHomeworkMaxScore() + "\n Сем: " + this.course.getSemScore() + " из " + this.course.getSemMaxScore();
    }

    public String getResultModules() {
        ArrayList<Topic> modules = this.course.getModules();
        StringBuilder result = new StringBuilder();
        Iterator var3 = modules.iterator();

        while(var3.hasNext()) {
            Topic i = (Topic)var3.next();
            result.append(i);
        }

        return result.toString();
    }

    public ArrayList<Topic> getModules() {
        return this.course.getModules();
    }

    public Topic getModule(String moduleName) {
        ArrayList<Topic> modules = this.course.getModules();
        Iterator var3 = modules.iterator();

        Topic i;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            i = (Topic)var3.next();
        } while(!Objects.equals(moduleName, i.getModuleName()));

        return i;
    }

    public String toString() {
        String var10000 = super.getSurnameName();
        return var10000 + "\nГруппа: " + this.group;
    }
}
