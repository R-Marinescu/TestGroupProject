package com.example.testgroupproject.Services.ProducerService;

import com.example.testgroupproject.Models.Producer;
import com.example.testgroupproject.Repositories.ProducerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpProducerService implements ProducerServiceInterface {

    @Autowired
    ProducerRepo producerRepo;

    @Override
    public void insertProducer(Producer p) {
        Producer savedProducer = producerRepo.save(p);
    }

    @Override
    public List<Producer> getAllProducers() {
        return producerRepo.findAll();
    }

    @Override
    public Producer getProducerById(Integer id) {
        return producerRepo.findById(id).get();
    }

    @Override
    public void deleteProducer(Producer p) {
        producerRepo.delete(p);
    }

    @Override
    public void updateProducer(Producer p) {
        producerRepo.save(p);
    }

    @Override
    public Producer findByProdUsername(String username) {
        return producerRepo.findByProdUsername(username);
    }
}
