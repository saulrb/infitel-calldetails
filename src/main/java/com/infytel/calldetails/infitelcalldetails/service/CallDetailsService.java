package com.infytel.calldetails.infitelcalldetails.service;

import com.infytel.calldetails.infitelcalldetails.dto.CallDetailsDTO;

import java.util.List;

public interface CallDetailsService {

    List<CallDetailsDTO> getCustomerCallDetails(long phoneNo);
}
