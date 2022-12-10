import java.io.IOException;
import java.io.File;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;
import java.sql.DriverManager;
public class ConnectionDb {
    private final ArrayList<String> groups;
    private final ArrayList<String> surnameNames;
    private final ArrayList<Student> studentsWithGroups;
    private final Map<String, ArrayList<String>> dictGroups;
    private final ArrayList<String> students;
    public static void main(String [] args) throws IOException {
        ConnectionDb connect = new ConnectionDb();
        if(connect.Open()) {
            connect.Insert();
            connect.Close();
        }
    }

    public ConnectionDb() throws IOException {
        groups = new ParserCsv().getGroups();
        surnameNames = new ParserCsv().getStudents();
        studentsWithGroups = new ParserCsv().getStudentsWithGroups();
        dictGroups = new HashMap<String, ArrayList<String>>();
        students = new ArrayList<String>();
    }
    Connection con;

     boolean Open() {
        try {
            con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\USER\\sqlite\\users3.db");
            System.out.println("Connected");
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    void Insert(){
        try {
            /*List<String> uniqueGroups = new ArrayList<String>();
            for(var group: groups){
                if (!uniqueGroups.contains(group))
                    uniqueGroups.add(group);
            }
            String queryCourses = "INSERT INTO courses (id, nameCourse) " +
                    "VALUES ('" + 1 + "', '" + "Основы программирования" + "')";
            Statement statementCourses = con.createStatement();
            statementCourses.executeUpdate(queryCourses);
            for(int i = 0; i < uniqueGroups.size(); i++) {
                String queryGroups = "INSERT INTO groups (id, idCourse, nameGroup) " +
                        "VALUES ('" + (i + 1) + "', '" + 1 + "','" + uniqueGroups.get(i) + "')";
                Statement statement = con.createStatement();
                statement.executeUpdate(queryGroups);
            }
            for(int i = 0; i < studentsWithGroups.size(); i++) {
                String queryStudents = "INSERT INTO students (id, idGroup, idCourse, surnameName) " +
                        "VALUES ('" + (i + 1) + "','" + studentsWithGroups.get(i).getGroupId() + "', '" + 1 + "','" + studentsWithGroups.get(i).getSurnameName() + "')";
                Statement statement = con.createStatement();
                statement.executeUpdate(queryStudents);
            }*/
            for(int i = 0; i < studentsWithGroups.size(); i++) {
                var exerScore =  studentsWithGroups.get(i).getExercisesScore();
                var homeScore = studentsWithGroups.get(i).getHomeworkScore();
                var activScore = studentsWithGroups.get(i).getActivityScore();
                var semScore = studentsWithGroups.get(i).getSemScore();
                var totalScore = exerScore + homeScore + activScore + semScore;
                String queryStudents = "INSERT INTO scores (idStudent, exerciseScore, homeworkScore, activityScore, semScore, totalScore) " +
                        "VALUES ('" + (i + 1) + "','" + exerScore + "', '" + homeScore + "','" + activScore + "','" + semScore + "','" + totalScore + "')";
                Statement statement = con.createStatement();
                statement.executeUpdate(queryStudents);
            }
            System.out.println("Rows added");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    void Close(){
        try {
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

