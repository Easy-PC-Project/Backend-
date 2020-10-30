package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Motherboard;
import com.SE2.EasyPC.dataAccess.repository.MotherboardRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Business logic layer for Motherboard, recives calls from MotherboardController and calls MotherboardRepository
@Service
public class MotherboardService {
    
    @Autowired
    MotherboardRepository motherboardRepository; 
    public List<Motherboard> getAllMotherboards() { // returns a list with all Motherboards in the database
        try{
            return motherboardRepository.findAll();
        }catch( Exception e ){

            throw e;
        }
    }

    public Motherboard getMotherboardById( Long i ) { // returns the Motherboard with the requested ID or an exception if it does not exist
        try{
            return motherboardRepository.findById(i).orElseThrow(() -> new ResourceNotFoundException("Motherboard", "id", i));
        }catch( Exception e ){

            throw e;
        }
    }

    public Motherboard createMotherboard(Motherboard motherboard) { // creates a new Motherboard in the database
        try{
            return motherboardRepository.save(motherboard);
        }catch( Exception e ){

            throw e;
        }
    }

    public void deleteMotherboard( Long id ) { // deletes the Motherboard with the requested ID or an exception if it does not exist
        try{
            Motherboard motherboard = motherboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Motherboard", "id", id));
            motherboardRepository.delete(motherboard);
        }catch( Exception e ){

            throw e;
        }
    }

}
