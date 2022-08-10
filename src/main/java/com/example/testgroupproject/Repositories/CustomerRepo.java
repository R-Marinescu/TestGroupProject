package com.example.testgroupproject.Repositories;


import com.example.testgroupproject.Models.CustomerGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerGuest, Integer> {

}
