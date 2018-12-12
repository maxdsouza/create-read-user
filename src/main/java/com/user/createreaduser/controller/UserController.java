package com.user.createreaduser.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.createreaduser.dto.UserDTO;
import com.user.createreaduser.service.UserService;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView home(){
        return new ModelAndView("home");
    }
	
	@RequestMapping(method = RequestMethod.GET,value = "/list-users")
	public ModelAndView listUsers(Model model){
	    model.addAttribute("users", userService.findAll());
        return new ModelAndView("users");
    }
	
	@RequestMapping(method = RequestMethod.GET,value = "/register-user")
	public ModelAndView newUser(Model model){
		model.addAttribute("userdto", new UserDTO());
        return new ModelAndView("register");
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/register-user/save")
	public ModelAndView createUser(@ModelAttribute(value = "userdto") @Valid UserDTO userDTO, BindingResult errors){

		if (errors.hasErrors()) {
			return new ModelAndView("register");
		}
		userService.save(userDTO);
		return new ModelAndView("redirect:/list-users");
    }
}
