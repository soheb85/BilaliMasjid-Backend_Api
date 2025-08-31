package com.example.bilalimasjid.services;

import com.example.bilalimasjid.dto.Usersdto;
import com.example.bilalimasjid.dto.ApiResponse;
import com.example.bilalimasjid.entity.Users;
import com.example.bilalimasjid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public ApiResponse saveUser(Usersdto usersdto){
       try {
           Users users = new Users();
           users.setUsername(usersdto.getUsername());
           String encryptPassword = passwordEncoder.encode(usersdto.getPassword());
           users.setPassword(encryptPassword);
           users.setRole(usersdto.getRole());

           userRepository.save(users);

          return new ApiResponse(
                  "200",
                  "true",
                  "User saved Successfully",
                  usersdto
          );
       }catch (RuntimeException e){
           return new ApiResponse(
                   "404",
                   "false",
                   "Failed to saved User" + e.getMessage(),
                   null
           );
       }


    }

    public ApiResponse getData(Usersdto usersdto){

        ApiResponse response = new ApiResponse();

        try{
            Optional<Users> optionalUser = userRepository.findByUsername(usersdto.getUsername());

            if(optionalUser.isPresent()){
                Users users = optionalUser.get();
                boolean passwordMatch = passwordEncoder.matches(usersdto.getPassword(), users.getPassword());

                if(passwordMatch){
                    response.setCode("200");
                    response.setSuccess("true");
                    response.setMessage("Valid User");
                    response.setData(users);
                }else {
                    response.setCode("401");
                    response.setSuccess("false");
                    response.setMessage("Invalid Password");
                }
            }else{
                response.setCode("204");
                response.setSuccess("false");
                response.setMessage("Invalid User");
            }

        }catch(RuntimeException e){
            response.setCode("500");
            response.setSuccess("false");
            response.setMessage("Internal Server Error"+e.getMessage());

        }

        return response;

    }


}
