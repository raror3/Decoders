/**
 * 
 */
package com.decoders.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author raror3
 *
 */
@Controller
public class IndexController {
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/")
    public String welcomeDecoders(@RequestParam(value="name", required=false, defaultValue="decoders") String name, Model model) {
        model.addAttribute("name", name);
        log.info("Hello Name as: " + name);
        return "welcomeDecoders";
    }
}
