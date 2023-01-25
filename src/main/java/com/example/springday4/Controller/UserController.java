package com.example.springday4.Controller;

import com.example.springday4.ApiResponse;
import com.example.springday4.Pogo.User;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    ArrayList<User> users = new ArrayList<>();

    @GetMapping("/Display")
    public ArrayList<User> getUsers(){
        return users;
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors error){ // كلاس جاهز يعرض لي وش الخطأ اللي صار
       if( error.hasErrors()){
            String message=error.getFieldError().getDefaultMessage();
           return  ResponseEntity.status(400).body(new ApiResponse(message));

       }
        users.add(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));
    }

    @PutMapping("/udpate/{index}")
    public ResponseEntity updateUser(@PathVariable int index , @Valid @RequestBody User user,Errors error){
        if( error.hasErrors()){
            String message=error.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(400).body(new ApiResponse(message));
        }
        users.set(index,user);
        return ResponseEntity.status(200).body(new ApiResponse("User updated"));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteUser(@PathVariable int index , @RequestBody User user, Errors error){
        if( error.hasErrors()){
            String message=error.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(400).body(new ApiResponse(message));
        }
        users.set(index,user);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted"));
    }


}
