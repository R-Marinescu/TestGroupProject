package com.example.testgroupproject.Controllers;

import com.example.testgroupproject.Models.CustomerGuest;
import com.example.testgroupproject.Models.Producer;
import com.example.testgroupproject.Repositories.CustomerRepo;
import com.example.testgroupproject.Repositories.ProducerRepo;
import com.example.testgroupproject.Services.CustomerService.CustomerServiceInterface;
import com.example.testgroupproject.Services.ProducerService.ProducerServiceInterface;
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

    @Autowired
    ProducerServiceInterface producerService;

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

    @PostMapping("/loginProducer")
    public String loginUser(@ModelAttribute("producer") Producer producer, Model m){

        Integer producerId = producer.getId();
        Optional<Producer> producerData = Optional.ofNullable(producerService.findByProdUsername(producer.getProdUsername()));



        if(!producerData.isEmpty() && producer.getProdPassword().equals(producerData.get().getProdPassword())) {
            return "home";
        }else{
            return "login";
        }

    }
}
