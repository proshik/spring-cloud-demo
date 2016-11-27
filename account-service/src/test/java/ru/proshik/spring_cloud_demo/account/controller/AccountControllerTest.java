package ru.proshik.spring_cloud_demo.account.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ru.proshik.spring_cloud_demo.account.model.ResourceOut;

import static org.junit.Assert.assertEquals;

/**
 * Created by proshik on 05.10.16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Ignore
    @Test
    public void getAccount() {
        ResponseEntity<ResourceOut> response = template.getForEntity("/v1/account", ResourceOut.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new ResourceOut("anyKey", "value"), response.getBody());
    }

}
