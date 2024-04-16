package com.azure.demosql.controller;

import com.azure.demosql.model.Credentials;
import com.azure.demosql.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginRepo loginRepo;

    @PostMapping("/verifyUser")
    public ResponseEntity<Credentials> addCandidate(@RequestBody Credentials credentials) {
        Credentials dbCredentials = loginRepo.findById(credentials.getUsername()).get();
        if(dbCredentials.getUserType().equals("admin")){
            return  ResponseEntity.ok(dbCredentials);
        }else if(dbCredentials.getUserType().equals("user")){
            return ResponseEntity.ok(dbCredentials);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(dbCredentials);
        }
    }
}
