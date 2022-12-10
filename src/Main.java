import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException, ClientException, ParseException, ApiException {
        var students = new Students();
        var course = new Course(32, 411, 2800, 32);
        var st = students.getStudent("Mrmogo");
        System.out.println(st.getFinalScores());
        //System.out.println(students.getStudents());
        /*System.out.println(course.getModules());
        System.out.println(st.getSurnameName());
        System.out.println();
        System.out.println(st.getFinalScores());
        System.out.println();
        System.out.println(st.getResultModules());
        Topic module = st.getModule("Ошибки");
        System.out.println(module);
        System.out.println(module.getResult());
        var vkUser = new VkApi();
        System.out.println(vkUser.findUserInfo("Белобородова"));*/
    }
}

