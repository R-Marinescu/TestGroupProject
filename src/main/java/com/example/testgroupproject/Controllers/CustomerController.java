package com.example.testgroupproject.Controllers;

import com.example.testgroupproject.Models.CustomerGuest;
import com.example.testgroupproject.Services.CustomerService.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    //Injecting Interface methods from Service via ImpCustomerService (@Autowired)
    @Autowired
    CustomerServiceInterface customerService;

    //
    @PostMapping("/insertCustomer")
    public String insertCustomer(@RequestParam("cusFname") String cusFname,
                                 @RequestParam("cusLname") String cusLname,
                                 @RequestParam("cusEmail") String cusEmail,
                                 @RequestParam("cusPhoneNr") String cusPhoneNr,
                                 @RequestParam("cusPostalC") String cusPostalC,
                                 @RequestParam("cusStreet") String cusStreet,
                                 @RequestParam("cusStreetNr") String cusStreetNr,
                                 @RequestParam("cusUsername") String cusUsername,
                                 @RequestParam("cusPassword") String cusPassword,
                                 ModelMap mm){

        //Invokes constructor and creates new obj, then calls Interface from Services and implements the method insertCustomer from impCustomerService
        CustomerGuest customer = new CustomerGuest(cusFname, cusLname, cusEmail, cusPhoneNr, cusPostalC, cusStreet, cusStreetNr, cusUsername, cusPassword);
        customerService.insertCustomer(customer);
        //Stores the value of the method getAllCustomers into "customers" and send it to the html page assigned to 'return'.
        mm.addAttribute("customer", customerService.getAllCustomers());
        return "register-success";
    }

    @GetMapping("/editCustomer/{id}")
    public String showUpdateCustomerForm(@PathVariable("id") Integer id, ModelMap mm) {

        //Calling method that fetches DB item by id
        CustomerGuest customer = customerService.getCustomerById(id);

        //Stores value on variable customer and binds it on variable "customer" for View
        mm.addAttribute("customer", customer);
        return "Customer/UpdateCustomer";
    }

    //Takes object id from the method "showUpdateCustomerForm" and updates it
    @PostMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable("id") Integer id,
                                 @ModelAttribute("customer") CustomerGuest customer, BindingResult result) {
        if (result.hasErrors()) {
            customer.setId(id);
            return "Customer/UpdateCustomer";
        }
        customerService.updateCustomer(customer);
        return "home";
    }

    //Delete obj "Product"
    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id, ModelMap mm) {
        CustomerGuest customer = customerService.getCustomerById(id);

        customerService.deleteCustomer(customer);
        return "home";
    }
}
