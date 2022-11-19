public class Scores {
    public float totalScoreExercises;
    public float totalScorePractices;
    public float totalScoreActivities;
    public float totalScoreSeminarTasks;

    public Scores(float activities, float exercises, float practices, float seminarTasks) {
        this.totalScoreExercises = exercises;
        this.totalScorePractices = practices;
        this.totalScoreActivities = activities;
        this.totalScoreSeminarTasks = seminarTasks;
    }
}
