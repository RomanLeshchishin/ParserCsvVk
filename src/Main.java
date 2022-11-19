import java.io.IOException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        Students students = new Students();
        Student st = students.getStudent("Аль-хайти Абдулвасеа");
        System.out.println(st);
        System.out.println();
        System.out.println(st.getFinalScores());
        System.out.println();
        System.out.println(st.getResultModules());
        Topic module = st.getModule("Ошибки");
        System.out.println(module);
        System.out.println(module.getResult());
    }
}

