import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException, ClientException, ParseException, ApiException {
        var students = new Students();
        var st = students.getStudent("Белобородова Полина");
        System.out.println(st);
        System.out.println();
        System.out.println(st.getFinalScores());
        System.out.println();
        System.out.println(st.getResultModules());
        Topic module = st.getModule("Ошибки");
        System.out.println(module);
        System.out.println(module.getResult());
        var vkUser = new VkApi();
        System.out.println(vkUser.findUserInfo("Белобородова"));
    }
}

