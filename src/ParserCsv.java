import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ParserCsv {
    ArrayList<Student> students = new ArrayList();
    String[] typesOfTasks;
    String[] maxPoints;
    String[] listTopics;

    public ParserCsv() throws IOException {
        Path pathFile = Path.of("C:\\Users\\Roman\\.jdks\\ClassesForTable-20221103T141927Z-001\\src\\basicprogramming_2.csv");
        List<String> lines = Files.readAllLines(pathFile, StandardCharsets.UTF_8);
        List<String[]> dataFromFile = lines.stream().map((line) -> {
            return line.split(";", -1);
        }).toList();
        this.listTopics = (String[])dataFromFile.get(0);
        this.typesOfTasks = (String[])dataFromFile.get(1);
        this.maxPoints = (String[])dataFromFile.get(2);
        this.createStudents(dataFromFile.subList(3, dataFromFile.size()));
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    private void createStudents(List<String[]> studentLines) {
        Iterator var2 = studentLines.iterator();

        while(var2.hasNext()) {
            String[] line = (String[])var2.next();
            this.students.add(this.createCourse(new Student(line[0], line[1]), line));
        }

    }

    private Student createCourse(Student student, String[] inf) {
        float activities = Float.parseFloat(this.maxPoints[2]);
        float exercises = Float.parseFloat(this.maxPoints[3]);
        float practices = Float.parseFloat(this.maxPoints[4]);
        float seminarTasks = Float.parseFloat(this.maxPoints[5]);
        Course studentScoresCourse = new Course(activities, exercises, practices, seminarTasks);
        Topic topic = null;
        int count = 8;

        while(count < inf.length) {
            String[] titles = (String[])Arrays.copyOfRange(this.typesOfTasks, count, this.typesOfTasks.length);
            String[] md = (String[])Arrays.copyOfRange(inf, count, Arrays.asList(titles).indexOf("Сем") + count + 1);
            String[] hw = (String[])Arrays.copyOfRange(this.typesOfTasks, count, Arrays.asList(titles).indexOf("Сем") + count + 1);
            String[] mScore = (String[])Arrays.copyOfRange(this.maxPoints, count, Arrays.asList(titles).indexOf("Сем") + count + 1);
            String hMaxScore = find(hw, "ДЗ") != -1 ? this.maxPoints[find(hw, "ДЗ") + count] : "0";
            float exercisesMaxScore = Float.parseFloat(this.maxPoints[count + 1]);
            float homeworkMaxScore = Float.parseFloat(hMaxScore);
            float activityMaxScore = Float.parseFloat(this.maxPoints[count]);
            float activityScore = Float.parseFloat(this.maxPoints[count + md.length - 1]);
            float semMaxScore = Float.parseFloat(md[0]);
            float semScore = Float.parseFloat(md[md.length - 1]);
            topic = new Topic(this.listTopics[count], exercisesMaxScore, homeworkMaxScore, activityMaxScore, activityScore, semMaxScore, semScore);
            count = Arrays.asList(titles).indexOf("Сем") + count + 1;
            studentScoresCourse.addModule(this.addTasks(topic, md, mScore, hw));
        }

        student.addCourse(studentScoresCourse);
        return student;
    }

    private Topic addTasks(Topic topic, String[] scores, String[] mScores, String[] names) {
        for(int i = 0; i < scores.length; ++i) {
            float ms = Float.parseFloat(mScores[i]);
            float ps = Float.parseFloat(scores[i]);
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
}
