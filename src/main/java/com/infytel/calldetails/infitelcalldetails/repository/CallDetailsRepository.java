package com.infytel.calldetails.infitelcalldetails.repository;

import com.infytel.calldetails.infitelcalldetails.entity.CallDetails;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CallDetailsRepository extends PagingAndSortingRepository<CallDetails, Long> {
    List<CallDetails> findByCalledBy(long calledBy);
}
