package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.HDD;
import com.SE2.EasyPC.service.HDDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//permit cross origin requests
@CrossOrigin
@RestController
@RequestMapping("/api")
public class HDDController {
    
    private static final Logger logger = LogManager.getLogger();
    
    //declares corresponding service
    @Autowired
    HDDService hddService;

    //get http request for all hdds
    @GetMapping("/hdds")
    public List<HDD> getAllHDDs(HttpServletRequest request) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //return the corresponding service logical function
        return hddService.getAllHDDs();
    }

    //get http request for hdd by specific ID
    @GetMapping("/hdd/{id}")
    public HDD getHDDById(@PathVariable(value = "id") Long hddId, HttpServletRequest request) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //return the corresponding service logical function
        return hddService.getHDDById(hddId);
    }

    //Post http request for hdd
    @PostMapping("/hdd")
    //request body with object to post
    public HDD createHDD(@Valid @RequestBody HDD hdd, HttpServletRequest request) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //return the corresponding service logical function
        return hddService.createHDD(hdd);
    }

    //Delete http request for hdd by ID
    @DeleteMapping("/hdd/{id}")
    public ResponseEntity<?> deleteHDD(@PathVariable(value = "id") Long hddId, HttpServletRequest request) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //call the corresponding service logical function
        hddService.deleteHDD(hddId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

}
