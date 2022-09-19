package com.example.testgroupproject.Controllers;

import com.example.testgroupproject.Models.Producer;
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

    @PostMapping("/insertProducer")
    public String insertProducer(@RequestParam("ProName") String ProName,
                                 @RequestParam("ProLName") String ProLName,
                                 @RequestParam("address") String address,
                                 @RequestParam("county") String county,
                                 @RequestParam("email") String email,
                                 @RequestParam("iban") String iban,
                                 @RequestParam("business") String business,
                                 ModelMap mm){
        //Invokes constructor and creates new obj, then calls Interface from Services and implements the method insertProducer from impProducerService
        Producer producer = new Producer(ProName, ProLName, address, county, email, iban, business);
        producerService.insertProducer(producer);

        //Stores the value of the method getAllProducers into "producers" and send it to the html page assigned to 'return'.
        mm.addAttribute("producers", producerService.getAllProducers());
        return "Producer/ProducerList";
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
