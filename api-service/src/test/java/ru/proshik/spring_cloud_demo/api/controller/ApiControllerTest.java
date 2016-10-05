package ru.proshik.spring_cloud_demo.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ru.proshik.spring_cloud_demo.api.client.AccountClient;
import ru.proshik.spring_cloud_demo.api.model.ResourceOut;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by proshik on 05.10.16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiControllerTest {

    @Autowired
    private TestRestTemplate template;
    @MockBean
    private AccountClient accountClient;

    @Test
    public void api() {
        when(accountClient.get()).thenReturn(new ResourceOut("key", "value"));

        ResponseEntity<ResourceOut> response = template.getForEntity("/api", ResourceOut.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new ResourceOut("key", "value"), response.getBody());
    }

}
