package com.example.testgroupproject.Controllers.Products;

import com.example.testgroupproject.Models.Product;
import com.example.testgroupproject.Services.ProductService.ProdServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductControllerCRUD {

    //Injecting Interface methods from Service via ImpProductService (@Autowired)
    @Autowired
    ProdServiceInterface prodService;

    // Url Mapping and Requesting the parameters from the View
    @PostMapping("/insertProduct")
    public String insertProduct(@RequestParam("productName") String productName,
                                @RequestParam("productPrice") Double productPrice,
                                @RequestParam("message") String message,
                                @RequestParam("discount") Double discount,
                                ModelMap mm){

        //Invokes constructor and creates new obj, then calls Interface from Services and implements the method insertProduct from impProductService
        Product product = new Product(productName, productPrice, message, discount);
        prodService.insertProduct(product);

        //Stores the value of the method getAllProducts into "products" and send it to the html page assigned to 'return'.
        mm.addAttribute("products", prodService.getAllProducts());
        return "Product/ProductList";
    }

    //Binding controller with view on id
    @GetMapping("/editProduct/{id}")
    public String showUpdatedProductForm(@PathVariable("id") Integer id, ModelMap mm) {

        //Calling method that fetches DB item by id
        Product product = prodService.getProductById(id);

        //Stores value on variable product and binds it on variable "product" for View
        mm.addAttribute("product", product);
        return "Product/UpdateProduct";
    }

//    @GetMapping("/getProduct/{id}")
//    public String getProduct(@PathVariable("id") Integer id, ModelMap mm) {
//
//        //Calling method that fetches DB item by id
//        Product product = prodService.getProductById(id);
//
//        //Stores value on variable product and binds it on variable "product" for View
//        mm.addAttribute("product", product);
//        return "Product/UpdateProduct";
//    }

    //Takes object id from the method "showUpdatedProductForm" and updates it
    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") Integer id,
                                @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            product.setId(id);
            return "Product/UpdateProduct";
        }
        prodService.updateProduct(product);
        return "home";
    }

    //Delete obj "Product"
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, ModelMap mm) {
        Product product = prodService.getProductById(id);

        prodService.deleteProduct(product);
        return "home";
    }

}
