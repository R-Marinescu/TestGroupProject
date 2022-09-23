package com.example.testgroupproject.Services.CountyService;

import com.example.testgroupproject.Models.County;
import com.example.testgroupproject.Models.CustomerGuest;

public interface CountyServiceInterface {

    County getCountyById(Integer id);

    void insertCounty(County c);
}
