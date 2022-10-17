package com.example.testgroupproject.Controllers;

import com.example.testgroupproject.Models.CustomerGuest;
import com.example.testgroupproject.Models.Producer;
import com.example.testgroupproject.Services.CountyService.CountyServiceInterface;
import com.example.testgroupproject.Services.CustomerService.CustomerServiceInterface;
import com.example.testgroupproject.Services.OrderService.OrderServiceInterface;
import com.example.testgroupproject.Services.ProducerService.ProducerServiceInterface;
import com.example.testgroupproject.Services.ProductService.ProdServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

//Main Page Controller
@Controller
public class HomeController {
    @Autowired
    ProdServiceInterface prodService;
    @Autowired
    OrderServiceInterface orderService;
    @Autowired
    CustomerServiceInterface customerService;
    @Autowired
    ProducerServiceInterface producerService;

    @Autowired
    CountyServiceInterface countyService;


    @RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToHome() {

        return("/home");
    }


    @RequestMapping(value = "/sendToProduct", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToProduct() {

        return ("Product/ProductForm");
    }



    @RequestMapping(value = "/sendToOrder", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToOrder() {

        return ("Order/OrderForm");
    }


    @RequestMapping(value = "/sendToRegister", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToProducer(){

        return ("register");
    }


    @RequestMapping(value = "/sendToOrderList", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToOrderList(ModelMap mm) {

        mm.addAttribute("orders", orderService.getAllOrders());

        return ("Order/OrderList");
    }


    @RequestMapping(value = "/sendToCustomerList", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToCustomerList(ModelMap mm) {

        mm.addAttribute("customers", customerService.getAllCustomers());
        return ("Customer/CustomerList");
    }


    @RequestMapping(value = "/sendToProducerList", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToProducerList(ModelMap mm) {

        mm.addAttribute("producers", producerService.getAllProducers());
        return "Producer/ProducerList";
    }


    @RequestMapping(value = "/sendToLogin", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToLogin(Model model) {
        CustomerGuest user = new CustomerGuest();
        Producer producer=new Producer();
        model.addAttribute("user", user);
        model.addAttribute("producer",producer);
        return "login";
    }


}




