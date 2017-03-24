/**
 * 
 */
package com.decoders.constants;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * This class consists of all constants related to HTTP response codes.
 * @author raror3
 */
@Component
@PropertySource("classpath:userConstants.properties")
@ConfigurationProperties(prefix="org.site.lifeline.userConstants")
public class UserConstants {

	private List<String> userList;

	/**
	 * @return the userList
	 */
	public List<String> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<String> userList) {
		this.userList = userList;
	}


}