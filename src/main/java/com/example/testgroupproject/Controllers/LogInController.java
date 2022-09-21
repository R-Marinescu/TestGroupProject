package com.example.testgroupproject.Controllers;

import com.example.testgroupproject.Models.CustomerGuest;
import com.example.testgroupproject.Repositories.CustomerRepo;
import com.example.testgroupproject.Services.CustomerService.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class LogInController {
    @Autowired
    CustomerServiceInterface customerService;


    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute("user") CustomerGuest user, Model m){

        Integer userId = user.getId();
        Optional<CustomerGuest> userData = Optional.ofNullable(customerService.findByCusUsername(user.getCusUsername()));



        if(!userData.isEmpty() && user.getCusPassword().equals(userData.get().getCusPassword())) {
            return "home";
        }else{
            return "login";
        }

    }
}
