/**
 * 
 */
package com.decoders.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.decoders.bean.ApiExecutionDetailBean;

/**
 * @author raror3
 *
 */
public interface ApiExecutionDetailRepository extends MongoRepository<ApiExecutionDetailBean, String> {

	public List<ApiExecutionDetailBean> findByApiNameAndExecutionDate(String apiName, Date executionDate, Sort sort);
	public List<ApiExecutionDetailBean> findByApiName(String apiName);
	public List<ApiExecutionDetailBean> findByExecutionDate(Date executionDate);

}
