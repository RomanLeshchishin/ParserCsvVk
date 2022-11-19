import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Students {
    private final ArrayList<Student> students = (new ParserCSV()).getStudents();

    public Students() throws IOException {
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public Student getStudent(String surnameName) {
        Iterator var2 = this.students.iterator();

        Student i;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            i = (Student)var2.next();
        } while(!Objects.equals(i.getSurnameName(), surnameName));

        return i;
    }
}
