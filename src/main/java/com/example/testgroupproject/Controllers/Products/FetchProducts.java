package com.example.testgroupproject.Controllers.Products;

import com.example.testgroupproject.Models.Product;
import com.example.testgroupproject.Services.ProductService.ProdServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class FetchProducts {

    @Autowired
    ProdServiceInterface prodService;


//    ----- Controllers that show products by county -------
        @RequestMapping(value = "/SendToAchaeaProducts", method = { RequestMethod.GET, RequestMethod.POST })
        public String redirectAchaeaProducts(ModelMap mm){

        mm.addAttribute("products", prodService.getProductsByCounty(3));
        return"/Product/ByCountyAndType/AchaeaProducts";
    }


    @GetMapping("/showAitolokarnaniaProducts")
    public String showAitolokarnaniaProducts(){

        return"/Product/ByCountyAndType/AitolokarnaniaProducts";
    }

    @GetMapping("/showAtticaProducts")
    public String showAtticaProducts(){

        return"/Product/ByCountyAndType/AtticaProducts";
    }

    @GetMapping("/showKarditsaProducts")
    public String showKarditsaProducts(){

        return"/Product/ByCountyAndType/KarditsaProducts";
    }

    @GetMapping("/showThesaliaProducts")
    public String showThesaliaProducts(){

        return"/Product/ByCountyAndType/ThesaliaProducts";
    }

    @GetMapping("/showThesalonikiProducts")
    public String showThesalonikiProducts(){

        return"/Product/ByCountyAndType/ThesalonikiProducts";
    }

    //  ----- End Of Controllers that show products by county -------
}
