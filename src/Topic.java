import java.util.ArrayList;
import java.util.Iterator;

public class Topic {
    private final String topicName;
    private final float exercisesMaxScore;
    private final float homeworksMaxScore;
    private final float activityMaxScore;
    private final float activityScore;
    private final float SeminarTasksMaxScore;
    private final float SeminarTasksScore;
    private final ArrayList<Task> exercisePoints = new ArrayList<>();
    private final ArrayList<Task> practicePoints = new ArrayList<>();

    public Topic(String moduleName, float exercisesMaxScore, float homeworkMaxScore, float activityMaxScore, float semMaxScore, float activityScore, float semScore) {
        this.topicName = moduleName;
        this.exercisesMaxScore = exercisesMaxScore;
        this.homeworksMaxScore = homeworkMaxScore;
        this.activityMaxScore = activityMaxScore;
        this.activityScore = activityScore;
        this.SeminarTasksMaxScore = semMaxScore;
        this.SeminarTasksScore = semScore;
    }

    public String getModuleName() {
        return this.topicName;
    }

    public float getExercisesMaxScore() {
        return this.exercisesMaxScore;
    }

    public float getHomeworkMaxScore() {
        return this.homeworksMaxScore;
    }

    public float getActivityMaxScore() {
        return this.activityMaxScore;
    }

    public float getActivityScore() {
        return this.activityScore;
    }

    public float getHomeworkScore() {
        var score = 0f;
        for(var i: practicePoints)
            score += i.getPointsScored();
        return score;
    }

    public float getExercisesScore() {
        var score = 0f;
        for(var i: exercisePoints)
            score += i.getPointsScored();
        return score;
    }

    public float getSemScore() {
        return this.SeminarTasksScore;
    }

    public float getSemMaxScore() {
        return this.SeminarTasksMaxScore;
    }

    public ArrayList<Task> getExercises() {
        return this.exercisePoints;
    }

    public ArrayList<Task> getHomeworks() {
        return this.practicePoints;
    }

    public void addExercise(Task task) {
        this.exercisePoints.add(task);
    }

    public void addHomework(Task task) {
        this.practicePoints.add(task);
    }

    public String getResult() {
        var result = new StringBuilder();
        result.append("Модуль: ").append(this.getModuleName());
        for(var i: exercisePoints){
            var res = "\n " + i.getTaskName() + "  " + i.getPointsScored() + " из " + i.getMaxScore();
            result.append(res);
        }
        for(var i: practicePoints){
            var res = "\n " + i.getTaskName() + "  " + i.getPointsScored() + " из " + i.getMaxScore();
            result.append(res);
        }
        return result.toString();
    }

    public String toString() {
        return "Модуль: " + getModuleName() + "\n Активности: " + getActivityScore() + " из " + getActivityMaxScore() + "\n Упражнения: " + getExercisesScore() + " из " + getExercisesMaxScore() + "\n Домание работы: " + getHomeworkScore() + " из " + getHomeworkMaxScore() + "\n Сем: " + getActivityScore() + " из " + getActivityMaxScore() + "\n\n";
    }
}
