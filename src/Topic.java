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
    private final ArrayList<Task> exercisePoints = new ArrayList();
    private final ArrayList<Task> practicePoints = new ArrayList();

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
        float score = 0.0F;

        Task i;
        for(Iterator var2 = this.practicePoints.iterator(); var2.hasNext(); score += i.getPointsScored()) {
            i = (Task)var2.next();
        }

        return score;
    }

    public float getExercisesScore() {
        float score = 0.0F;

        Task i;
        for(Iterator var2 = this.exercisePoints.iterator(); var2.hasNext(); score += i.getPointsScored()) {
            i = (Task)var2.next();
        }

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
        StringBuilder result = new StringBuilder();
        result.append("Модуль: ").append(this.getModuleName());
        Iterator var2 = this.exercisePoints.iterator();

        String var10000;
        Task i;
        String res;
        while(var2.hasNext()) {
            i = (Task)var2.next();
            var10000 = i.getTaskName();
            res = "\n " + var10000 + "  " + i.getPointsScored() + " из " + i.getMaxScore();
            result.append(res);
        }

        var2 = this.practicePoints.iterator();

        while(var2.hasNext()) {
            i = (Task)var2.next();
            var10000 = i.getTaskName();
            res = "\n " + var10000 + "  " + i.getPointsScored() + " из " + i.getMaxScore();
            result.append(res);
        }

        return result.toString();
    }

    public String toString() {
        String var10000 = this.getModuleName();
        return "Модуль: " + var10000 + "\n Активности: " + this.getActivityScore() + " из " + this.getActivityMaxScore() + "\n Упражнения: " + this.getExercisesScore() + " из " + this.getExercisesMaxScore() + "\n Домание работы: " + this.getHomeworkScore() + " из " + this.getHomeworkMaxScore() + "\n Сем: " + this.getActivityScore() + " из " + this.getActivityMaxScore() + "\n\n";
    }
}
