package com.infytel.calldetails.infitelcalldetails.controller;

import com.infytel.calldetails.infitelcalldetails.dto.CallDetailsDTO;
import com.infytel.calldetails.infitelcalldetails.service.CallDetailsServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customers/")
public class CustomerDetilasController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    CallDetailsServiceImp callDetailsServiceImp;

    @Autowired
    public CustomerDetilasController(CallDetailsServiceImp callDetailsServiceImp){
        this.callDetailsServiceImp = callDetailsServiceImp;
    }

    @GetMapping(value = "{phoneNo}/calldetails", produces = MediaType.APPLICATION_JSON_VALUE )
    public List<CallDetailsDTO> getCustomerCallDetails(@PathVariable long phoneNo) {
        logger.info("Calldetails request for customer {}", phoneNo);
        return callDetailsServiceImp.getCustomerCallDetails(phoneNo);
    }
}
