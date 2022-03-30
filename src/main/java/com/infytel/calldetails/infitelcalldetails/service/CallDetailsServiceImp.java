package com.infytel.calldetails.infitelcalldetails.service;

import com.infytel.calldetails.infitelcalldetails.dto.CallDetailsDTO;
import com.infytel.calldetails.infitelcalldetails.entity.CallDetails;
import com.infytel.calldetails.infitelcalldetails.repository.CallDetailsRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CallDetailsServiceImp implements CallDetailsService{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private ModelMapper modelMapper;

    private CallDetailsRepository repository;

    @Autowired
    public CallDetailsServiceImp(CallDetailsRepository repository, ModelMapper modelMapper){
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CallDetailsDTO> getCustomerCallDetails(long phoneNo) {

        logger.info("Calldetails request for customer {}", phoneNo);

        List<CallDetails> callDetailsList = repository.findByCalledBy(phoneNo);
        List<CallDetailsDTO> callDetailsDTOS = new ArrayList<>();

        callDetailsList.forEach( callDetails -> {
            callDetailsDTOS.add(convertToDto(callDetails));
        });
        logger.info("Calldetails for customer : {}", callDetailsList);
        return callDetailsDTOS;
    }

    protected CallDetailsDTO convertToDto(CallDetails callDetails){
        return modelMapper.map(callDetails,CallDetailsDTO.class);
    }
}
