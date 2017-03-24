/**
 * 
 */
package com.decoders.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.decoders.bean.UserLoginRequestBean;

/**
 * @author raror3
 *
 */
@RestController
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(path="/login", method = { RequestMethod.POST })
    public String loginUser(@RequestBody UserLoginRequestBean userLoginRequestJson, Model model) {
		//userHelper.validateUser(userLoginRequestJson);
        return "welcomeDecoders";
    }

}
