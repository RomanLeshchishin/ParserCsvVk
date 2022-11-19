import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.objects.users.Fields;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class VkApi {
    VkApiClient vkClient = new VkApiClient(new HttpTransportClient());
    private final Integer APP_ID = 51469495;

}
