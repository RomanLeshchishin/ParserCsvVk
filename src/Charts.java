import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.io.IOException;
import java.io.File;
import java.sql.*;
import java.text.ParseException;
import java.util.*;

public class Charts {
    private final ArrayList<String> namesScores;
    private final ArrayList<Integer> scoresPercent;
    private final ArrayList<Integer> scoresPercentLevelFirst;
    private final ArrayList<Integer> scoresPercentLevelSecond;

    private final ArrayList<String> namesGenders;
    private final ArrayList<Integer> genders;
    public static void main(String [] args) throws IOException, ClientException, ParseException, ApiException, InterruptedException {
        Charts connect = new Charts();
        if(connect.Open()) {
            connect.SelectScore();
            connect.SelectLevels();
            connect.SelectGender();
            connect.Close();
        }
    }

    public Charts() throws IOException, ClientException, ParseException, ApiException, InterruptedException {
        namesScores = new ArrayList<String>(Arrays.asList(new String[]{"0-40", "40-60", "60-80", "80-100"}));
        scoresPercent = new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 0, 0, 0}));
        scoresPercentLevelFirst = new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 0, 0, 0}));
        scoresPercentLevelSecond = new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 0, 0, 0}));
        namesGenders = new ArrayList<String>(Arrays.asList(new String[]{"М", "Ж"}));
        genders = new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 0}));
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

    ArrayList<Integer> SelectScore(){
        try {
            Statement statement = con.createStatement();
            String query = "SELECT totalScore FROM scores";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int totalScore = rs.getInt("totalScore");
                float percScore = (float) (totalScore) / 3211;
                if (percScore <= 0.4) {
                    scoresPercent.set(0, scoresPercent.get(0) + 1);
                }
                if (percScore> 0.4 && percScore <= 0.6) {
                    scoresPercent.set(1, scoresPercent.get(1) + 1);
                }
                if (percScore > 0.6 && percScore <= 0.8) {
                    scoresPercent.set(2, scoresPercent.get(2) + 1);
                }
                if (percScore > 0.8 && percScore <= 1) {
                    scoresPercent.set(3, scoresPercent.get(3) + 1);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return scoresPercent;
    }

    ArrayList<ArrayList<Integer>> SelectLevels(){
        var levelsScore = new ArrayList<ArrayList<Integer>>();
        try {
            Statement statement = con.createStatement();
            String query = "SELECT level, totalScore FROM students";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String level = rs.getString("level");
                int totalScore = rs.getInt("totalScore");
                float percScore = (float) (totalScore) / 3211;
                if(Objects.equals(level, "1")) {
                    if (percScore <= 0.4) {
                        scoresPercentLevelFirst.set(0, scoresPercentLevelFirst.get(0) + 1);
                    }
                    if (percScore > 0.4 && percScore <= 0.6) {
                        scoresPercentLevelFirst.set(1, scoresPercentLevelFirst.get(1) + 1);
                    }
                    if (percScore > 0.6 && percScore <= 0.8) {
                        scoresPercentLevelFirst.set(2, scoresPercentLevelFirst.get(2) + 1);
                    }
                    if (percScore > 0.8 && percScore <= 1) {
                        scoresPercentLevelFirst.set(3, scoresPercentLevelFirst.get(3) + 1);
                    }
                }
                else if (Objects.equals(level, "2")){
                    if (percScore <= 0.4) {
                        scoresPercentLevelSecond.set(0, scoresPercentLevelSecond.get(0) + 1);
                    }
                    if (percScore > 0.4 && percScore <= 0.6) {
                        scoresPercentLevelSecond.set(1, scoresPercentLevelSecond.get(1) + 1);
                    }
                    if (percScore > 0.6 && percScore <= 0.8) {
                        scoresPercentLevelSecond.set(2, scoresPercentLevelSecond.get(2) + 1);
                    }
                    if (percScore > 0.8 && percScore <= 1) {
                        scoresPercentLevelSecond.set(3, scoresPercentLevelSecond.get(3) + 1);
                    }
                }
                else{
                    continue;
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        levelsScore.add(scoresPercentLevelFirst);
        levelsScore.add(scoresPercentLevelSecond);
        return levelsScore;
    }

    ArrayList<Integer> SelectGender(){
        try {
            Statement statement = con.createStatement();
            String query = "SELECT gender FROM cityGender";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String gender = rs.getString("gender");
                if(Objects.equals(gender, "2")){
                    genders.set(0, genders.get(0) + 1);
                }
                else if (Objects.equals(gender, "1")) {
                    genders.set(1, genders.get(1) + 1);
                }
                else{
                    continue;
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(genders);
        return genders;
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

    public ArrayList<String> getNamesScores() {
        return namesScores;
    }

    public ArrayList<String> getNamesGenders() {
        return namesGenders;
    }
}
