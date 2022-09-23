package com.example.testgroupproject.Controllers.Products;

import com.example.testgroupproject.Models.County;
import com.example.testgroupproject.Repositories.CountyRepo;
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
    CountyRepo countyRepo;




//    ----- Controllers that show products by county -------
    @GetMapping("/showAtticaProducts")
    public String showAtticaProducts(ModelMap mm){

        mm.addAttribute("products", prodService.getProductsByCounty(1));
        return"/Product/ByCountyAndType/AtticaProducts";
    }


    @GetMapping("/showThesalonikiProducts")
    public String showThesalonikiProducts(ModelMap mm){

        mm.addAttribute("products", prodService.getProductsByCounty(2));
        return"/Product/ByCountyAndType/ThesalonikiProducts";
    }

    @RequestMapping(value = "/SendToAchaeaProducts", method = { RequestMethod.GET, RequestMethod.POST })
    public String redirectAchaeaProducts(ModelMap mm){

        mm.addAttribute("products", prodService.getProductsByCounty(3));
        return"/Product/ByCountyAndType/AchaeaProducts";
    }

    @GetMapping("/showAitolokarnaniaProducts")
    public String showAitolokarnaniaProducts(ModelMap mm){

        mm.addAttribute("products", prodService.getProductsByCounty(4));
        return"/Product/ByCountyAndType/AitolokarnaniaProducts";
    }


    @GetMapping("/showKarditsaProducts")
    public String showKarditsaProducts(ModelMap mm){

        mm.addAttribute("products", prodService.getProductsByCounty(5));
        return"/Product/ByCountyAndType/KarditsaProducts";
    }

    @GetMapping("/showThesaliaProducts")
    public String showThesaliaProducts(ModelMap mm){

        mm.addAttribute("products", prodService.getProductsByCounty(6));
        return"/Product/ByCountyAndType/ThesaliaProducts";
    }


    //  ----- End Of Controllers that show products by county -------
}
