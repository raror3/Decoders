package com.decoders.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.decoders.SummaryPageRepository;
import com.decoders.bean.SummaryPageList;
import com.decoders.constants.Configurations;

/**
 * @author raror3
 *
 */
@RestController	
public class JourneyController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	SummaryPageRepository summaryPageRepository;
	
	@Autowired
	Configurations configObj;
	
	@RequestMapping(path="/journeySummaryById", method = { RequestMethod.GET})
    public List<SummaryPageList> journeySummaryById(@RequestParam(value="journey") String journey, Model model) {
		return summaryPageRepository.findByJourneyId(journey);
    }
	
	@RequestMapping(path="/journeySummaryByDate", method = { RequestMethod.GET})
    public List<SummaryPageList> journeySummaryByDate(@RequestParam(value="journeyDate") String journeyDate, Model model) {
		return summaryPageRepository.findByJourneyDate(journeyDate);
    }
}
