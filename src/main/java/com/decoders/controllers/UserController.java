/**
 * 
 */
package com.decoders.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.decoders.UserProfileRepository;
import com.decoders.bean.UserLoginRequestBean;
import com.decoders.bean.UserLoginResponseBean;
import com.decoders.bean.UserProfileBean;
import com.decoders.constants.Configurations;
import com.google.gson.Gson;

/**
 * @author raror3
 *
 */
@RestController
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	Configurations configObj;
	
	@RequestMapping(path="/login", method = { RequestMethod.POST })
    public String loginUser(@RequestBody UserLoginRequestBean userLoginRequestJson, Model model) {
		UserLoginResponseBean loginResponseBean = validateUser(userLoginRequestJson);
        return new Gson().toJson(loginResponseBean);
    }

	private UserLoginResponseBean validateUser(UserLoginRequestBean userLoginRequestJson) {
		UserLoginResponseBean loginResponseBean = new UserLoginResponseBean();
		if (null != userLoginRequestJson) {
			if (configObj.getSalt().equals(userLoginRequestJson.getSalt())) {
				UserProfileBean userProfileBean = userProfileRepository.findByUserEmail(userLoginRequestJson.getUserEmail());
				if (null != userProfileBean) {
					log.info("Logged-in user's first name: " + userProfileBean.getFirstName());
					loginResponseBean.setFirstName(userProfileBean.getFirstName());
					loginResponseBean.setLastName(userProfileBean.getLastName());
					loginResponseBean.setStatus(userProfileBean.getStatus());
					loginResponseBean.setSessionId(userProfileBean.getSessionId());
					return loginResponseBean;
				}
			}
		}
		loginResponseBean.setStatus("inactive");
		return loginResponseBean;
	}

}
