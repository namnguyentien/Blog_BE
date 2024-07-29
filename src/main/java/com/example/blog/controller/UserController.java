package com.example.blog.controller;


import com.example.blog.entity.User;
import com.example.blog.payload.request.UpdateUserProfileReq;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/currentUser")
    public ResponseEntity<?> currentUser(@RequestParam(name = "username")String username){
        
        User user = userService.findUserByUserName(username);

        return ResponseEntity.ok(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable long id, @RequestBody UpdateUserProfileReq req){
        User user = userService.updateProfile(id, req);
        return ResponseEntity.ok(user);
    }

}
