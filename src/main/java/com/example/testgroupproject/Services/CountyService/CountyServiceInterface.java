package com.example.testgroupproject.Services.CountyService;

import com.example.testgroupproject.Models.CartItem;
import com.example.testgroupproject.Models.County;
import com.example.testgroupproject.Models.CustomerGuest;

import java.util.List;
import java.util.Set;

public interface CountyServiceInterface {

    County getCountyById(Integer id);

    List<County> getAllCounties();

    void insertCounty(County c);


}
