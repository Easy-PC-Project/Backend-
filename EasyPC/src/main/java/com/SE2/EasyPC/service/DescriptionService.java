package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Description;
import com.SE2.EasyPC.dataAccess.repository.DescriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for Description, recives calls from DescriptionController and calls DescriptionRepository
@Service
public class DescriptionService {
    
    private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    DescriptionRepository descriptionRepository;

    public List<Description> getAllDescriptions() { // returns a list with all Descriptions in the database
        try{
            return descriptionRepository.findAll();
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
        
    }

    public Description findByPartName( String partName ){ // return Decription from part_name
        return descriptionRepository.findByPartName( partName );
    }

}
