public class Task {
    private final String taskName;
    private final float maxScore;
    private final float pointsScored;

    public Task(String taskName, float maxScore, float pointsScored) {
        this.taskName = taskName;
        this.maxScore = maxScore;
        this.pointsScored = pointsScored;
    }

    public String getTaskName() {
        return taskName;
    }

    public float getMaxScore() {
        return maxScore;
    }

    public float getPointsScored() {
        return pointsScored;
    }
}
