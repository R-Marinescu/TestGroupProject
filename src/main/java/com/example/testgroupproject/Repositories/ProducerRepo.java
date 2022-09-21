package com.example.testgroupproject.Repositories;

import com.example.testgroupproject.Models.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepo extends JpaRepository<Producer, Integer> {
    Producer findByProdUsername(String name);
}
