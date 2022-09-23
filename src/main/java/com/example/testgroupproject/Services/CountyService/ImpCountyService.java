package com.example.testgroupproject.Services.CountyService;

import com.example.testgroupproject.Models.County;
import com.example.testgroupproject.Repositories.CountyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpCountyService implements CountyServiceInterface {

    @Autowired
    CountyRepo countyRepo;


    @Override
    public County getCountyById(Integer id) {
        return countyRepo.findById(id).get();
    }

    @Override
    public void insertCounty(County c) {
        County saveCounty = countyRepo.save(c);
    }

}
