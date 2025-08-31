package com.example.bilalimasjid.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {

    private String code;
    private String success;
    private String message;
    private Object data;


    public ApiResponse(String code, String success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }
}
