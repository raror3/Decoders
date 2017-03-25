/**
 * 
 */
package com.decoders.controllers;

import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.decoders.UserProfileRepository;
import com.decoders.bean.ApiDetailBean;
import com.decoders.bean.ApiExecutionDetailBean;
import com.decoders.constants.Configurations;
import com.decoders.repository.ApiExecutionDetailRepository;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author raror3
 *
 */
@RestController
public class ApiMonitoringController {
	private static final Logger log = LoggerFactory.getLogger(ApiMonitoringController.class);

	@Autowired
	UserProfileRepository userProfileRepository;

	@Autowired
	ApiExecutionDetailRepository apiExecutionDetailRepository;

	@Autowired
	Configurations configObj;

	@HystrixCommand(fallbackMethod = "reliable")
	@RequestMapping(path="/pingDoveStoreFinderApi", method = { RequestMethod.GET })
    public String loginUser(@RequestHeader(value = "salt", required = false) String salt, Model model) {
		if (configObj.getApiSalt().equals(salt)) {

			Gson gson = new Gson();
			String resultString = null;
			try {
				HttpHeaders headers = new HttpHeaders();
				headers.set("Accept", "application/json");
			    headers.set("Content-Type", "application/json");
			    
				//HttpEntity<String> entity = new HttpEntity<String>(headers);
	
				RestTemplate restTemplate = new RestTemplate();
			    URI uri = URI.create("http://www.dove.com/americas/bin/ts/public/StoreLocator/GetStoreLocatorResult?callback=jQuery21407620385287549736_1490385158955&prodId=1111134776&zip=98001&radius=100&numStores=999&aggType=upc&_=1490385158957");
			    long beforeTime = System.currentTimeMillis();
			    ResponseEntity<String> response = restTemplate.exchange(configObj.getApiUrl(), HttpMethod.GET, new HttpEntity<Object>(headers),String.class);
			    long afterTime = System.currentTimeMillis();
			    long timeTaken = afterTime-beforeTime;
			    log.info("BeforeTime: " + beforeTime + " & afterTime: " + afterTime + " &timeTaken: " + timeTaken);
			    resultString = response.getBody();
			    headers = response.getHeaders();
			    log.info("ResultString :" + resultString + " & headers: " + headers);
			    String resultJsonStr = resultString.substring(resultString.indexOf("(")+1, resultString.length()-2);
			    //JSONObject jsonObj = new JSONObject(result);
			    ApiDetailBean apiDetailBean = gson.fromJson(resultJsonStr, ApiDetailBean.class);
			    ApiExecutionDetailBean apiExecutionDetailBean = new ApiExecutionDetailBean();
			    apiExecutionDetailBean.setResponseCode(Integer.valueOf(apiDetailBean.getResponseHeader().getStatus()));
			    apiExecutionDetailBean.setOverallStatus("Success");
			    apiExecutionDetailBean.setTimeTaken(timeTaken);
			    Calendar rightNow = Calendar.getInstance();
			    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			    apiExecutionDetailBean.setApiExecutionStartHourOfDay(rightNow.get(Calendar.HOUR_OF_DAY));
			    int startMinuteOfHour = rightNow.get(Calendar.MINUTE)-rightNow.get(Calendar.MINUTE)%5;
			    apiExecutionDetailBean.setApiExecutionStartMinuteOfHour(startMinuteOfHour);
			    int endMinuteOfHour = startMinuteOfHour + 5;
			    int endHourOfDay = rightNow.get(Calendar.HOUR_OF_DAY);
			    if (startMinuteOfHour>=55) {
			    	endMinuteOfHour = 0;
			    	endHourOfDay = rightNow.get(Calendar.HOUR_OF_DAY) + 1;
			    }
			    apiExecutionDetailBean.setApiExecutionEndHourOfDay(endHourOfDay);
			    apiExecutionDetailBean.setApiExecutionEndMinuteOfHour(endMinuteOfHour);
			    apiExecutionDetailBean.setExecutionDate(new SimpleDateFormat("dd/MM/yyyy").parse(dateFormat.format(new Date())));
			    apiExecutionDetailBean.setExecutionTimeinMillis(Calendar.getInstance().getTimeInMillis());
			    apiExecutionDetailBean.setApiName("DoveStoreFinderApi");
			    apiExecutionDetailRepository.save(apiExecutionDetailBean);
			} catch (Exception exception) {
				ApiExecutionDetailBean apiExecutionDetailBean = new ApiExecutionDetailBean();
			    apiExecutionDetailBean.setResponseCode(500);
			    apiExecutionDetailBean.setOverallStatus("Failure");
			    apiExecutionDetailBean.setTimeTaken(0);
			    Calendar rightNow = Calendar.getInstance();
			    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			    apiExecutionDetailBean.setApiExecutionStartHourOfDay(rightNow.get(Calendar.HOUR_OF_DAY));
			    int startMinuteOfHour = rightNow.get(Calendar.MINUTE)-rightNow.get(Calendar.MINUTE)%5;
			    apiExecutionDetailBean.setApiExecutionStartMinuteOfHour(startMinuteOfHour);
			    int endMinuteOfHour = startMinuteOfHour + 5;
			    int endHourOfDay = rightNow.get(Calendar.HOUR_OF_DAY);
			    if (startMinuteOfHour>=55) {
			    	endMinuteOfHour = 0;
			    	endHourOfDay = rightNow.get(Calendar.HOUR_OF_DAY) + 1;
			    }
			    apiExecutionDetailBean.setApiExecutionEndMinuteOfHour(endMinuteOfHour);
			    apiExecutionDetailBean.setApiExecutionEndHourOfDay(endHourOfDay);
			    try {
					apiExecutionDetailBean.setExecutionDate(new SimpleDateFormat("dd/MM/yyyy").parse(dateFormat.format(new Date())));
				} catch (ParseException e) {
					log.info(e.getMessage(), e);
				}
			    apiExecutionDetailBean.setExecutionTimeinMillis(Calendar.getInstance().getTimeInMillis());
			    apiExecutionDetailBean.setApiName("DoveStoreFinderApi");
			    apiExecutionDetailRepository.save(apiExecutionDetailBean);
			}
			
		    return resultString;
		}
		System.out.println("null hai");
		return null;
    }

	public String reliable() {
			ApiExecutionDetailBean apiExecutionDetailBean = new ApiExecutionDetailBean();
	    try {
			apiExecutionDetailBean.setResponseCode(500);
			apiExecutionDetailBean.setOverallStatus("Failure");
		    apiExecutionDetailBean.setTimeTaken(0);
		    Calendar rightNow = Calendar.getInstance();
		    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    apiExecutionDetailBean.setApiExecutionStartHourOfDay(rightNow.get(Calendar.HOUR_OF_DAY));
		    int startMinuteOfHour = rightNow.get(Calendar.MINUTE)-rightNow.get(Calendar.MINUTE)%5;
		    apiExecutionDetailBean.setApiExecutionStartMinuteOfHour(startMinuteOfHour);
		    int endMinuteOfHour = startMinuteOfHour + 5;
		    int endHourOfDay = rightNow.get(Calendar.HOUR_OF_DAY);
		    if (startMinuteOfHour>=55) {
		    	endMinuteOfHour = 0;
		    	endHourOfDay = rightNow.get(Calendar.HOUR_OF_DAY) + 1;
		    }
		    apiExecutionDetailBean.setApiExecutionEndHourOfDay(endHourOfDay);
		    apiExecutionDetailBean.setApiExecutionEndMinuteOfHour(endMinuteOfHour);
			apiExecutionDetailBean.setExecutionDate(new SimpleDateFormat("dd/MM/yyyy").parse(dateFormat.format(new Date())));
		    apiExecutionDetailBean.setExecutionTimeinMillis(Calendar.getInstance().getTimeInMillis());
		    apiExecutionDetailBean.setApiName("DoveStoreFinderApi");
		    apiExecutionDetailRepository.save(apiExecutionDetailBean);
			log.info("API failed");
	    } catch (ParseException e) {
			log.info(e.getMessage(), e);
		}
		return "failed";
	}
	
	@RequestMapping(path="/health/api/{apiName}", method = { RequestMethod.GET })
    public String publishApiHealth(@PathVariable String apiName, 
    		@RequestParam(value = "requestedDateStr", required = false) String requestedDateStr, Model model) {
		Gson gson = new Gson();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date requestedDate = new Date();
		String overallStatus = "Success";
		List<ApiExecutionDetailBean> apiExecutionDetailBeanList = null;
		try {
			requestedDate = new SimpleDateFormat("dd/MM/yyyy").parse(requestedDateStr);
			Sort sort = new Sort(Direction.ASC,"executionDate");
			apiExecutionDetailBeanList = apiExecutionDetailRepository.findByApiNameAndExecutionDate(apiName, requestedDate, sort);
			if (null != apiExecutionDetailBeanList) {
				for (ApiExecutionDetailBean detailBean : apiExecutionDetailBeanList) {
					if (detailBean.getResponseCode() >= 400) {
						overallStatus = "Failure";
					}
				}
				for (ApiExecutionDetailBean detailBean : apiExecutionDetailBeanList) {
					detailBean.setOverallStatus(overallStatus);
				}
			}
			
		} catch (ParseException e) {
			log.info(e.getMessage(), e);
		}
		if (null != apiExecutionDetailBeanList) {
			model.addAttribute(apiExecutionDetailBeanList);
		} else {
			model.addAttribute("Failed to get data due to connectivity or internal issue");
		}
		return "apiHealthDashboard";
	}
	
	@RequestMapping(path="/api/health/{apiName}", method = { RequestMethod.GET })
    public String validateAndPublishApiHealth(@PathVariable String apiName, 
    		@RequestParam(value = "requestedDateStr", required = false) String requestedDateStr, Model model) {
		Gson gson = new Gson();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date requestedDate = new Date();
		String overallStatus = "Success";
		List<ApiExecutionDetailBean> apiExecutionDetailBeanList = null;
		try {
			if (null == requestedDateStr) {
				requestedDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateFormat.format(new Date()));
			} else {
				requestedDate = new SimpleDateFormat("dd/MM/yyyy").parse(requestedDateStr);
			}
			Sort sort = new Sort(Direction.ASC,"executionDate");
			apiExecutionDetailBeanList = apiExecutionDetailRepository.findByApiNameAndExecutionDate(apiName, requestedDate, sort);
			if (null != apiExecutionDetailBeanList) {
				for (ApiExecutionDetailBean detailBean : apiExecutionDetailBeanList) {
					if (detailBean.getResponseCode() >= 400) {
						overallStatus = "Failure";
					}
				}
				for (ApiExecutionDetailBean detailBean : apiExecutionDetailBeanList) {
					detailBean.setOverallStatus(overallStatus);
				}
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage(), e);
		}
		
		return gson.toJson(apiExecutionDetailBeanList);
	}

}
