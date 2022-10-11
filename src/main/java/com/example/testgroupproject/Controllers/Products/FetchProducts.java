package com.example.testgroupproject.Controllers.Products;

import com.example.testgroupproject.Services.CountyService.CountyServiceInterface;
import com.example.testgroupproject.Services.ProductService.ProdServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class FetchProducts {

    @Autowired
    ProdServiceInterface prodService;

    @Autowired
    CountyServiceInterface countyService;


//    ----- Products Controllers -------


//    Shows Shop By County fetches all counties
    @RequestMapping(value = "/sendToShopByCounty", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToShopByCounty(ModelMap mm) {

        mm.addAttribute("counties", countyService.getAllCounties());
        return("/Product/productsByCounty");
    }

//Shows products by county
    @GetMapping("/showCountyProducts/{id}")
    public String showProducts(@PathVariable("id") Integer id, ModelMap mm){

        mm.addAttribute("products", prodService.getProductsByCounty(id));
        return "/Product/countyProducts";
    }

//    Show ALL products
    @RequestMapping(value = "/sendToProductList", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectToProductList(ModelMap mm){


        mm.addAttribute("products", prodService.getAllProducts());
        return ("Product/ProductList");
    }


    //  ----- End Of Controllers that show products by county -------
}
