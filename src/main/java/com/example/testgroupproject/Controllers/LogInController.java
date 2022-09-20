package com.example.testgroupproject.Controllers;

import com.example.testgroupproject.Models.CustomerGuest;
import com.example.testgroupproject.Repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LogInController {
    @Autowired
    private CustomerRepo repo;

    @GetMapping("/login")
    public String login(Model model){
        CustomerGuest customer=new CustomerGuest();
        model.addAttribute("customer",customer);
        return "login";
    }

    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute("customer") CustomerGuest customer){
        String cus_username=customer.getCusUsername();
        CustomerGuest customer_data=repo.findByCusUsername(cus_username);
        if(customer.getCusPassword().equals(customer_data.getCusPassword())) {
            return "home";
        }else{
            return "error";
        }
    }


}
