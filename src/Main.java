import com.vk.api.sdk.client.Lang;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.docs.responses.SearchResponse;
import com.vk.api.sdk.objects.users.Fields;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException, ClientException, ParseException, ApiException, InterruptedException {
        var students = new Students();
        var studentsList = students.getStudents();
        ArrayList<String> studentsListTest = new ArrayList<String>(Arrays.asList(new String[]{"Зеленкина Даша", }));
        //System.out.println(studentsList.size());
        //var course = new Course(32, 411, 2800, 32);
        //var st = students.getStudent("Каратаев Роман");
        //System.out.println(st.getFinalScores());
        //System.out.println(students.getStudents());
        /*System.out.println(course.getModules());
        System.out.println(st.getSurnameName());
        System.out.println();
        System.out.println(st.getFinalScores());
        System.out.println();
        System.out.println(st.getResultModules());
        Topic module = st.getModule("Ошибки");
        System.out.println(module);
        System.out.println(module.getResult());*/
        var vkUser = new VkApi();
        System.out.println(vkUser.findUserCityGender(studentsListTest));
        System.out.println(vkUser.findUserInfo("Денежкин Дмитрий"));
        //System.out.println(vkUser.findUserInfo("Чернильцев Андрей"));
        //System.out.println(vkUser.findUserInfo("Карасев Михаил"));
    }
}

