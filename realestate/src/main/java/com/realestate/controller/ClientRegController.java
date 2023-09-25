package com.realestate.controller;

import com.realestate.payload.ClientRegDto;
import com.realestate.service.ClientRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientreg")
public class ClientRegController {


    private ClientRegService clientRegService;

    public ClientRegController(ClientRegService clientRegService) {
        this.clientRegService = clientRegService;
    }

    //http://localhost:8080/api/clientreg/create
    @PostMapping("/create")
    public ResponseEntity<String> createClientReg(@RequestBody ClientRegDto clientRegDto) {


        // Save the entity to the database
        clientRegService.saveUser(clientRegDto);

        // Create a response with status 201 (Created) and a success message

        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }

}

