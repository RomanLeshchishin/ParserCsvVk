import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

public class Students {
    private final ArrayList<Student> studentsWithGroups;
    private final ArrayList<String> groups;
    private final ArrayList<String> students;

    public Students() throws IOException, ClientException, ParseException, ApiException, InterruptedException {
        studentsWithGroups = new ParserCsv().getStudentsWithGroups();
        groups = new ParserCsv().getGroups();
        students = new ParserCsv().getStudents();
    }

    public ArrayList<Student> getStudentsWithGroups(){return studentsWithGroups;}
    public ArrayList<String> getGroups(){return groups;}
    public ArrayList<String> getStudents(){return students;}

    public Student getStudent(String surnameName) {
        for(var i: studentsWithGroups){
            if (Objects.equals(i.getSurnameName(), surnameName)){
                return i;
            }
        }
        return null;
    }
}
