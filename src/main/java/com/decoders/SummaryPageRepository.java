package com.decoders;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.decoders.bean.SummaryPageList;



public interface SummaryPageRepository extends MongoRepository<SummaryPageList, String> {
	
	public List<SummaryPageList> findByJourneyIdAndJourneyDate(String journeyId, String journeyDate);
	public List<SummaryPageList> findByJourneyId(String journeyId);
	public List<SummaryPageList> findByJourneyDate(String JourneyDate);
}