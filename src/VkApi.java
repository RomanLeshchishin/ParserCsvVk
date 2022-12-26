import com.vk.api.sdk.client.Lang;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.base.City;
import com.vk.api.sdk.objects.docs.responses.SearchResponse;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.users.UserFull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VkApi {
    private static final VkApiClient CLIENT = new VkApiClient(new HttpTransportClient());
    private static final Integer appId = 51507205;
    private static final Path pathToken = Path.of("C:\\Users\\USER\\IdeaProjects\\ParserCsvVk\\.idea\\token.txt");
    private static final String token;
    private final VkApiClient vk;
    public VkApi() {
        TransportClient transportClient = new HttpTransportClient();
        vk = new VkApiClient(transportClient);
    }

    static {
        try {
            token = Files.readAllLines(pathToken).get(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private UserActor getUserActor(){return new UserActor(appId, token);}
    public ArrayList<ArrayList<String>> findUserCityGender(ArrayList<String> students) throws ClientException, ApiException, InterruptedException {
        var cities = new ArrayList<String>();
        var genders = new ArrayList<String>();
        var citiesGenders = new ArrayList<ArrayList<String>>();
        for(String student : students) {
            Thread.sleep(260);
            var city = "null";
            var gender = "null";
            var userActor = getUserActor();
            var resultInfo = CLIENT.users().search(userActor)
                    .count(1)
                    .q(student)
                    .fields(Fields.CITY, Fields.SEX)
                    .lang(Lang.RU)
                    .execute();
            if (resultInfo.getItems().size() != 0) {
                if(resultInfo.getItems().get(0).getCity() != null) {
                    city = resultInfo.getItems().get(0).getCity().getTitle();
                    cities.add(city);
                }
                else if (resultInfo.getItems().get(0).getCity() == null)
                    cities.add(city);
                if(resultInfo.getItems().get(0).getSex() != null) {
                    gender = resultInfo.getItems().get(0).getSex().getValue();
                    genders.add(gender);
                }
                else if (resultInfo.getItems().get(0).getSex() == null)
                    genders.add(gender);
            }
            else {
                cities.add(city);
                genders.add(gender);
            }
            Thread.sleep(260);
            System.out.println(student + ' ' + city + ' ' + gender);
        }
        citiesGenders.add(cities);
        citiesGenders.add(genders);
        return citiesGenders;
    }

    public List<UserFull> findUserInfo(String search) throws ClientException, ApiException, ParseException {
        var userActor = getUserActor();
        var resultInfo = CLIENT.users().search(userActor)
                .count(1)
                .groupId(215279260)
                .q(search)
                .fields(Fields.CITY, Fields.SEX)
                .execute();
        var userInfo = resultInfo.getItems();
        return userInfo;
    }

    public ArrayList<ArrayList<String>> requestCitiesGenders(ArrayList<String> students) throws InterruptedException {
        var cities = new ArrayList<String>();
        var genders = new ArrayList<String>();
        var citiesGenders = new ArrayList<ArrayList<String>>();
        var city = "null";
        var gender = "null";
        var userActor = getUserActor();
        for(String student : students){
            try {
                var resultInfo = CLIENT.users().search(userActor)
                        .count(1)
                        .groupId(22941070)
                        .q(student)
                        .fields(Fields.CITY, Fields.SEX)
                        .execute();
                if (resultInfo.getItems().size() != 0 && resultInfo.getItems().get(0).getCity() != null) {
                    city = resultInfo.getItems().get(0).getCity().getTitle();
                    cities.add(city);
                }
                if(resultInfo.getItems().size() != 0 && resultInfo.getItems().get(0).getSex() != null) {
                    gender = resultInfo.getItems().get(0).getSex().getValue();
                    genders.add(gender);
                }
                else if(resultInfo.getItems().size() == 0){
                    city = "null";
                    cities.add(city);
                    gender = "null";
                    genders.add(gender);
                }
                else if(resultInfo.getItems().get(0).getCity() == null){
                    city = "null";
                    cities.add(city);
                }
                else if(resultInfo.getItems().get(0).getSex() == null){
                    gender = "null";
                    genders.add(gender);
                }

                } catch (ClientException e) {
                city = "null";
                cities.add(city);
                gender = "null";
                genders.add(gender);
                throw new RuntimeException(e);
            } catch (ApiException e) {
                city = "null";
                cities.add(city);
                gender = "null";
                genders.add(gender);
                throw new RuntimeException(e);
            }
            Thread.sleep(260);
            System.out.println(student + ' ' + city + ' ' + gender);
        }
        citiesGenders.add(cities);
        citiesGenders.add(genders);
        return citiesGenders;
    }
}
