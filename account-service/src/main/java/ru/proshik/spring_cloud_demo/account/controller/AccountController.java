package ru.proshik.spring_cloud_demo.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.proshik.spring_cloud_demo.account.model.ResourceOut;

/**
 * Created by proshik on 04.10.16.
 */
@RestController
public class AccountController {

    @GetMapping("account")
    public ResponseEntity get() {
        return ResponseEntity.ok(new ResourceOut("anyKey", "value"));
    }
}
