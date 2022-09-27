package com.example.testgroupproject.Repositories;

import com.example.testgroupproject.Models.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountyRepo extends JpaRepository<County, Integer> {

}
