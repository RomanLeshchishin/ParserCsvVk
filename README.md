Получение токена

1. Перешёл на страницу https://dev.vk.com/sdk/java и создал своё vk api "api for java".
![image](https://user-images.githubusercontent.com/114608473/202859144-ad65ac29-a62b-4f50-8e0b-02125d44c450.png)
2. Скопировал ссылку для создания токена https://oauth.vk.com/authorize?client_id=1&display=page&redirect_uri=http://example.com/callback&scope=friends&response_type=token&v=5.131&state=123456 со страницы https://dev.vk.com/api/access-token/implicit-flow-user.

3. В ссылке после "client_id=" ввёл id своего приложения, добавил в "redirect_uri" страницу по умолчанию и в "scope" указал права, которые будут у токена.

4. Скопировал получившуюся ссылку в браузер, выполнил запрос и получил токен.
