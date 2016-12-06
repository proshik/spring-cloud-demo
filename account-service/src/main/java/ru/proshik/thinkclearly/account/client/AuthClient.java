package ru.proshik.thinkclearly.account.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.proshik.thinkclearly.account.client.dto.UserCreateRequest;

/**
 * Created by proshik on 27.11.16.
 */
@Component
@FeignClient(value = "auth-service")
public interface AuthClient {


    @RequestMapping(method = RequestMethod.POST,
            value = "/uaa/users",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void createUser(UserCreateRequest userRequest);
}
