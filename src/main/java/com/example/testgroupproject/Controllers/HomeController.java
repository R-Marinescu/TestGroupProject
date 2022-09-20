package com.example.testgroupproject.Controllers;

import com.example.testgroupproject.Models.CustomerGuest;
import com.example.testgroupproject.Services.CustomerService.CustomerServiceInterface;
import com.example.testgroupproject.Services.OrderService.OrderServiceInterface;
import com.example.testgroupproject.Services.ProducerService.ProducerServiceInterface;
import com.example.testgroupproject.Services.ProductService.ProdServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @GetMapping("/")
    public String showHome() {

        return("home");
    }

    @PostMapping("/")
    public String redirectToHome() {

        return("/home");
    }

    @RequestMapping(value = "/sendToIndex", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToIndex() {
        return("/Home/index");
    }

    @RequestMapping(value = "/sendToProduct", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToProduct() {

        return ("Product/ProductForm");
    }


    @RequestMapping(value = "/sendToCustomer", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToCustomer() {

        return ("Customer/CustomerForm");
    }


    @RequestMapping(value = "/sendToOrder", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToOrder() {

        return ("Order/OrderForm");
    }


    @RequestMapping(value = "/sendToProducer", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToProducer(){

        return ("Producer/ProducerForm");
    }


    @RequestMapping(value = "/sendToProductList", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToProductList(ModelMap mm){

        mm.addAttribute("products", prodService.getAllProducts());

        return ("Product/ProductList");
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

        model.addAttribute("user", user);

        return "login";
    }
}
