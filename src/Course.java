import java.util.ArrayList;
import java.util.Iterator;

public class Course {
    private final ArrayList<Topic> topics = new ArrayList<>();
    private final float totalScoreActivities;
    private final float totalScoreExercises;
    private final float totalScorePractices;
    private final float totalScoreSeminarTasks;

    public Course(float activityMaxScore, float exercisesMaxScore, float practicesMaxScore, float seminarTasksMaxScore) {
        this.totalScoreActivities = activityMaxScore;
        this.totalScoreExercises = exercisesMaxScore;
        this.totalScorePractices = practicesMaxScore;
        this.totalScoreSeminarTasks = seminarTasksMaxScore;
    }

    public void addModule(Topic topic) {
        topics.add(topic);
    }

    public float getExercisesMaxScore() {
        return totalScoreExercises;
    }

    public float getHomeworkMaxScore() {
        return totalScorePractices;
    }

    public float getActivityMaxScore() {
        return totalScoreActivities;
    }

    public float getSemMaxScore() {
        return totalScoreSeminarTasks;
    }

    public ArrayList<Topic> getModules() {
        return topics;
    }

    public float getExercisesScore() {
        var score = 0f;
        for(var i: topics)
            score += i.getExercisesScore();
        return score;
    }

    public float getHomeworkScore() {
        var score = 0f;
        for(var i: topics)
            score += i.getHomeworkScore();
        return score;
    }

    public float getActivityScore() {
        var score = 0f;
        for(var i: topics)
            score += i.getActivityScore();
        return score;
    }

    public float getSemScore() {
        var score = 0f;
        for(var i: topics)
            score += i.getSemScore();
        return score;
    }
}
