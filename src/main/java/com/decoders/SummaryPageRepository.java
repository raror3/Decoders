package com.decoders;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.decoders.bean.DetailPageList;
import com.decoders.bean.SummaryPageList;



public interface SummaryPageRepository extends MongoRepository<SummaryPageList, String> {
	
}