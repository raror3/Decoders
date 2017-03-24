/**
 * 
 */
package com.decoders.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.decoders.bean.SummaryPageBean;

/**
 * @author raror3
 *
 */
public interface JourneySummaryRepository extends MongoRepository<SummaryPageBean, String> {

	public List<SummaryPageBean> findByJourneyIdentifier(String journeyIdentifer);

}
