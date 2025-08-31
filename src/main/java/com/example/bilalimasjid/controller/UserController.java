package com.example.bilalimasjid.controller;


import com.example.bilalimasjid.dto.Usersdto;
import com.example.bilalimasjid.dto.ApiResponse;
import com.example.bilalimasjid.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save(@RequestBody Usersdto usersdto){
        ApiResponse apiResponse = userService.saveUser(usersdto);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getUser")
    public ResponseEntity<ApiResponse> get(@RequestBody Usersdto usersdto){
        ApiResponse apiResponse = userService.getData(usersdto);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
