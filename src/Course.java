import java.util.ArrayList;
import java.util.Iterator;

public class Course {
    private final ArrayList<Topic> topics = new ArrayList();
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
        this.topics.add(topic);
    }

    public float getExercisesMaxScore() {
        return this.totalScoreExercises;
    }

    public float getHomeworkMaxScore() {
        return this.totalScorePractices;
    }

    public float getActivityMaxScore() {
        return this.totalScoreActivities;
    }

    public float getSemMaxScore() {
        return this.totalScoreSeminarTasks;
    }

    public ArrayList<Topic> getModules() {
        return this.topics;
    }

    public float getExercisesScore() {
        float score = 0.0F;

        Topic i;
        for(Iterator var2 = this.topics.iterator(); var2.hasNext(); score += i.getExercisesScore()) {
            i = (Topic)var2.next();
        }

        return score;
    }

    public float getHomeworkScore() {
        float score = 0.0F;

        Topic i;
        for(Iterator var2 = this.topics.iterator(); var2.hasNext(); score += i.getHomeworkScore()) {
            i = (Topic)var2.next();
        }

        return score;
    }

    public float getActivityScore() {
        float score = 0.0F;

        Topic i;
        for(Iterator var2 = this.topics.iterator(); var2.hasNext(); score += i.getActivityScore()) {
            i = (Topic)var2.next();
        }

        return score;
    }

    public float getSemScore() {
        float score = 0.0F;

        Topic i;
        for(Iterator var2 = this.topics.iterator(); var2.hasNext(); score += i.getSemScore()) {
            i = (Topic)var2.next();
        }

        return score;
    }
}
