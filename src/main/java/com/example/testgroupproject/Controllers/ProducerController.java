package com.example.testgroupproject.Controllers;

import com.example.testgroupproject.Models.CustomerGuest;
import com.example.testgroupproject.Models.Producer;
import com.example.testgroupproject.Repositories.ProducerRepo;
import com.example.testgroupproject.Services.ProducerService.ProducerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProducerController {

    @Autowired
    ProducerServiceInterface producerService;

    @Autowired
    private ProducerRepo repo;

    @PostMapping("/insertProducer")
    public String insertProducer(@RequestParam("prodFname") String prodFname,
                                 @RequestParam("prodLname") String prodLname,
                                 @RequestParam("prodAddress") String prodAddress,
                                 @RequestParam("prodArea") String prodArea,
                                 @RequestParam("prodEmail") String prodEmail,
                                 @RequestParam("prodIban") String prodIban,
                                 @RequestParam("prodBusTitle") String prodBusTitle,
                                 @RequestParam("prodUsername") String prodUsername,
                                 @RequestParam("prodPassword") String prodPassword,
                                 ModelMap mm){
        //Invokes constructor and creates new obj, then calls Interface from Services and implements the method insertProducer from impProducerService
        Producer producer = new Producer(prodFname, prodLname, prodAddress, prodArea, prodEmail, prodIban, prodBusTitle, prodUsername, prodPassword);
        producerService.insertProducer(producer);

        //Stores the value of the method getAllProducers into "producers" and send it to the html page assigned to 'return'.
        mm.addAttribute("producer", producerService.getAllProducers());
        return "register-success";
    }

    @PostMapping("/addProducer")
    public String processRegister(Producer producer) {

        repo.save(producer);

        return "register-success";
    }

    @GetMapping("/editProducer/{id}")
    public String showUpdateProducerForm(@PathVariable("id") Integer id, ModelMap mm) {

        //Calling method that fetches DB item by id
        Producer producer = producerService.getProducerById(id);

        //Stores value on variable product and binds it on variable "product" for View
        mm.addAttribute("producer", producer);
        return "Producer/UpdateProducer";
    }

    @PostMapping("/updateProducer/{id}")
    public String updateProducer(@PathVariable("id") Integer id,
                                @ModelAttribute("producer") Producer producer, BindingResult result) {
        if (result.hasErrors()) {
            producer.setId(id);
            return "Producer/UpdateProducer";
        }
        producerService.updateProducer(producer);
        return "home";
    }

    @GetMapping("/deleteProducer/{id}")
    public String deleteProducer(@PathVariable("id") Integer id, ModelMap mm) {
        Producer producer = producerService.getProducerById(id);

        producerService.deleteProducer(producer);
        return "home";
    }
}
