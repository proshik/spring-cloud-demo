package ru.proshik.spring_cloud_demo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.proshik.spring_cloud_demo.api.client.AccountClient;

/**
 * Created by proshik on 04.10.16.
 */
@RestController
public class ApiController {

    @Autowired
    private AccountClient accountClient;

    @GetMapping("api")
    public ResponseEntity api() {
        return ResponseEntity.ok(accountClient.get());
    }
}
