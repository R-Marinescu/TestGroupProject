package com.example.testgroupproject.Services.CountyService;

import com.example.testgroupproject.Models.County;
import com.example.testgroupproject.Models.CustomerGuest;

import java.util.List;

public interface CountyServiceInterface {

    County getCountyById(Integer id);

    List<County> getAllCounties();

    void insertCounty(County c);
}
