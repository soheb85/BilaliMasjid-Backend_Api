package com.example.bilalimasjid.mapper;

import com.example.bilalimasjid.dto.Usersdto;
import com.example.bilalimasjid.entity.Users;

public class UserstoUsersdtoMapper {


    public static Usersdto convertDto(Users users){
        return new Usersdto(
                users.getUsername(),
                users.getPassword(),
                users.getRole());
    }

    public static Users convertUser(Usersdto usersdto){
        return new Users(
                usersdto.getUsername(),
                usersdto.getPassword(),
                usersdto.getRole());
    }
}

