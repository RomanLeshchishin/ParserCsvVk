import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.users.UserFull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class VkApi {
    private static final VkApiClient CLIENT = new VkApiClient(new HttpTransportClient());
    private static final Integer appId = 51469495;
    private static final Path pathToken = Path.of("C:\\Users\\USER\\IdeaProjects\\ParserCsvVk\\.idea\\token.txt");
    private static final String token;

    static {
        try {
            token = Files.readAllLines(pathToken).get(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private UserActor getUserActor(){return new UserActor(appId, token);}
    public List<UserFull> findUserInfo(String search) throws ClientException, ApiException, ParseException {
        var userActor = getUserActor();
        var resultInfo = CLIENT.users().search(userActor)
                .count(1)
                .groupId(22941070)
                .q(search)
                .fields(Fields.CITY, Fields.SEX, Fields.BDATE, Fields.TIMEZONE)
                .execute();
        var userInfo = resultInfo.getItems();
        return userInfo;
    }

}
