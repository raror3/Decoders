/**
 * 
 */
package com.decoders;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.decoders.bean.UserProfileBean;

/**
 * @author raror3
 *
 */
public interface UserProfileRepository extends MongoRepository<UserProfileBean, String> {

	public UserProfileBean findByUserEmail(String userEmail);

}
