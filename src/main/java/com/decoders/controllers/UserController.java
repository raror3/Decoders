/**
 * 
 */
package com.decoders.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raror3
 *
 */
@RestController
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(path="/login", method = { RequestMethod.POST })
    public String loginUser(@RequestParam(value="userName", required=true, defaultValue="decoder") String userName, 
    		@RequestParam(value="password", required=true, defaultValue="password") String password, 
    		@RequestParam(value="salt", required=true, defaultValue="salt") String salt,
    		Model model) {
		
        return "welcomeDecoders";
    }
}
