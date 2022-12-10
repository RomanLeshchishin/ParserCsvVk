import java.util.ArrayList;
import java.util.Objects;

public class Student extends Person {
    private final Integer groupId;
    private Course course;
    private final String group;

    public Student(Integer groupId, String surnameName, String group) {
        super(surnameName);
        this.groupId = groupId;
        this.group = group;
    }

    public void addCourse(Course course) {
        this.course = course;
    }

    public String getFinalScores() {
        return "Итог\n Активности: " + course.getActivityScore() + " из " + this.course.getActivityMaxScore() + "\n Упражнения: " + this.course.getExercisesScore() + " из " + this.course.getExercisesMaxScore() + "\n Домашние работы: " + this.course.getHomeworkScore() + " из " + this.course.getHomeworkMaxScore() + "\n Сем: " + this.course.getSemScore() + " из " + this.course.getSemMaxScore();
    }

    public Float getActivityScore(){
        return course.getActivityScore();
    }

    public Float getExercisesScore(){
        return course.getExercisesScore();
    }

    public Float getHomeworkScore(){
        return course.getHomeworkScore();
    }

    public Float getSemScore(){
        return course.getSemScore();
    }

    public String getResultModules() {
        var modules = course.getModules();
        var result = new StringBuilder();
        for(var i: modules)
            result.append(i);
        return result.toString();
    }

    public String getGroup(){
        return group;
    }
    public Integer getGroupId(){return groupId;}
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
        return super.getSurnameName() + " " + groupId + " " + group;
    }
}
