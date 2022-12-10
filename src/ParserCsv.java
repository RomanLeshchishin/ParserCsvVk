import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ParserCsv {
    ArrayList<Student> studentsWithGroups = new ArrayList<Student>();
    ArrayList<String> groups = new  ArrayList<String>();
    ArrayList<String> students = new  ArrayList<String>();
    String[] typesOfTasks;
    String[] maxPoints;
    String[] listTopics;

    public ParserCsv() throws IOException {
        var pathFile = Path.of("C:\\Users\\USER\\IdeaProjects\\ParserCsvVk\\basicprogramming_2.csv");
        var lines = Files.readAllLines(pathFile, StandardCharsets.UTF_8);
        var dataFromFile = lines.stream().map(line ->line.split(";", -1)).toList();
        listTopics = dataFromFile.get(0);
        typesOfTasks = dataFromFile.get(1);
        maxPoints = dataFromFile.get(2);
        createStudents(dataFromFile);
    }


    private void createStudents(List<String[]> studentLines) {
        var countGroup = 1;
        for(int i = 4; i < studentLines.size(); i++){
            if (Objects.equals(studentLines.get(i)[1], studentLines.get(i-1)[1]))
                studentsWithGroups.add(createCourse(new Student(countGroup, studentLines.get(i - 1)[0], studentLines.get(i - 1)[1]), studentLines.get(i - 1)));
            else {
                studentsWithGroups.add(createCourse(new Student(countGroup, studentLines.get(i - 1)[0], studentLines.get(i - 1)[1]), studentLines.get(i - 1)));
                countGroup += 1;
            }
            groups.add(studentLines.get(i - 1)[1]);
            students.add(studentLines.get(i - 1)[0]);
        }
        studentsWithGroups.add(createCourse(new Student(countGroup, studentLines.get(studentLines.size() - 1)[0], studentLines.get(studentLines.size() - 1)[1]), studentLines.get(studentLines.size() - 1)));
        groups.add(studentLines.get(studentLines.size() - 1)[1]);
        students.add(studentLines.get(studentLines.size() - 1)[0]);

    }

    private Student createCourse(Student student, String[] inf) {
        var activities = Float.parseFloat(this.maxPoints[2]);
        var exercises = Float.parseFloat(this.maxPoints[3]);
        var practices = Float.parseFloat(this.maxPoints[4]);
        var seminarTasks = Float.parseFloat(this.maxPoints[5]);
        var studentScoresCourse = new Course(activities, exercises, practices, seminarTasks);
        Topic topic = null;
        int count = 8;

        while(count < inf.length) {
            var titles = (String[])Arrays.copyOfRange(this.typesOfTasks, count, this.typesOfTasks.length);
            var md = (String[])Arrays.copyOfRange(inf, count, Arrays.asList(titles).indexOf("Сем") + count + 1);
            var hw = (String[])Arrays.copyOfRange(this.typesOfTasks, count, Arrays.asList(titles).indexOf("Сем") + count + 1);
            var mScore = (String[])Arrays.copyOfRange(this.maxPoints, count, Arrays.asList(titles).indexOf("Сем") + count + 1);
            var hMaxScore = find(hw, "ДЗ") != -1 ? this.maxPoints[find(hw, "ДЗ") + count] : "0";
            var exercisesMaxScore = Float.parseFloat(this.maxPoints[count + 1]);
            var homeworkMaxScore = Float.parseFloat(hMaxScore);
            var activityMaxScore = Float.parseFloat(this.maxPoints[count]);
            var activityScore = Float.parseFloat(this.maxPoints[count + md.length - 1]);
            var semMaxScore = Float.parseFloat(md[0]);
            var semScore = Float.parseFloat(md[md.length - 1]);
            topic = new Topic(listTopics[count], exercisesMaxScore, homeworkMaxScore, activityMaxScore, activityScore, semMaxScore, semScore);
            count = Arrays.asList(titles).indexOf("Сем") + count + 1;
            studentScoresCourse.addModule(addTasks(topic, md, mScore, hw));
        }

        student.addCourse(studentScoresCourse);
        return student;
    }

    private Topic addTasks(Topic topic, String[] scores, String[] mScores, String[] names) {
        for(var i = 0; i < scores.length; ++i) {
            var ms = Float.parseFloat(mScores[i]);
            var ps = Float.parseFloat(scores[i]);
            if (names[i].startsWith("Упр:")) {
                topic.addExercise(new Task(names[i], ms, ps));
            } else if (names[i].startsWith("ДЗ:")) {
                topic.addHomework(new Task(names[i], ms, ps));
            }
        }

        return topic;
    }

    private static int find(String[] a, String elem) {
        for(int i = 0; i < a.length; ++i) {
            if (Objects.equals(a[i], elem)) {
                return i;
            }
        }

        return -1;
    }
    public ArrayList<Student> getStudentsWithGroups() {
        return studentsWithGroups;
    }
    public ArrayList<String> getGroups(){return groups;}
    public ArrayList<String> getStudents(){return students;}
}
