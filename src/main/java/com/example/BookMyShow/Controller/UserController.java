package com.example.BookMyShow.Controller;


import com.example.BookMyShow.Models.UserEntity;
import com.example.BookMyShow.RequestDto.UserRequestDto;
import com.example.BookMyShow.ResponseDto.UserBookedTicketResponseDto;
import com.example.BookMyShow.ResponseDto.UserEntityResponseDto;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody() UserRequestDto userRequestDto){

        userService.createUser(userRequestDto);

        return new ResponseEntity<>("User has been created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-user-by-id")
    public ResponseEntity<UserEntityResponseDto> getUserById(@RequestParam("id") int id){
        UserEntityResponseDto user= userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @GetMapping("/get-all-user-booked-ticket")
    public ResponseEntity<List<UserBookedTicketResponseDto>> getAllTicketBookedByUser(@RequestParam("userId") int userId){
        List<UserBookedTicketResponseDto> bookedTicketList= userService.getAllTicketBookedByUser(userId);
        return new ResponseEntity<>(bookedTicketList,HttpStatus.FOUND);
    }

    @GetMapping("/find-user-by-name")
    public ResponseEntity<UserEntityResponseDto> findUserByName(@RequestParam("name") String name){
        UserEntityResponseDto userEntity= userService.findUserByName(name);
        return new ResponseEntity<>(userEntity,HttpStatus.FOUND);
    }

    @GetMapping("/find-all-users")
    public ResponseEntity<List<UserEntityResponseDto>> findAllUsers(){

        List<UserEntityResponseDto> userEntityResponseDtoList= userService.findAllUsers();
        return new ResponseEntity<>(userEntityResponseDtoList, HttpStatus.FOUND);
    }

}