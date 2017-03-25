/**
 * 
 */
package org.jarvis4ops.schedulers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.decoders.constants.Configurations;

/**
 * @author raror3
 *
 */
@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	@Autowired
	private Configurations configObj;
    /**
     * This method schedules and invokes API to validate previous day rockstars from JIRA and post an update on Slack.
     * Scheduled method to execute at:
     * 0th second, 45th minute of 10th hour on
     * everyday of week
     * in IST Time-zone 
     */
    @Scheduled(cron="0 5,10,15,20,25,30,35,40,45,50,55 * * * *", zone="IST")
	public void getPrevDayRockstarsJiraSch() {
    	RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<String, String>(1);
        headerMap.add("Content-Type", "application/json");
        headerMap.add("salt", "abcdefghijklmnopqrst");
        String apiUrl = configObj.getSchedulerHostUrl() + "/pingDoveStoreFinderApi";
        String response = restTemplate.getForObject(apiUrl, String.class);
        log.info(apiUrl + " API has been invoked via Scheduler with response: " + response);
        
    }

}
