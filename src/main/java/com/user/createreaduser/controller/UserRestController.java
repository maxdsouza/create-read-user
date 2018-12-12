package com.user.createreaduser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.user.createreaduser.dto.UserDTO;
import com.user.createreaduser.service.UserService;

@RestController
public class UserRestController {

	@Autowired
    private UserService userService;
	
    @GetMapping(value = "/users")
    @ResponseStatus(code = HttpStatus.OK)
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping(value = "/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void save(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
    }
}
