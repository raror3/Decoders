package com.decoders.bean;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "journeySummary")
public class SummaryPageList {

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	private List<SummaryPageBean> journeyBeanList;
	private String journeyId;
	private String results;
	private String journeyDate;
	private String journeyHour;
	private String journeyMinute;
	private String journeyEndHour;
	public String getJourneyEndHour() {
		return journeyEndHour;
	}

	public void setJourneyEndHour(String journeyEndHour) {
		this.journeyEndHour = journeyEndHour;
	}

	private String journeyEndMinute;

	public String getJourneyEndMinute() {
		return journeyEndMinute;
	}

	public void setJourneyEndMinute(String journeyEndMinute) {
		this.journeyEndMinute = journeyEndMinute;
	}

	public String getJourneyId() {
		return journeyId;
	}

	public String getJourneyHour() {
		return journeyHour;
	}

	public void setJourneyHour(String journeyHour) {
		this.journeyHour = journeyHour;
	}

	public String getJourneyMinute() {
		return journeyMinute;
	}

	public void setJourneyMinute(String journeyMinute) {
		this.journeyMinute = journeyMinute;
	}

	public void setJourneyId(String journeyId) {
		this.journeyId = journeyId;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	/**
	 * @return the journeyBeanList
	 */
	public List<SummaryPageBean> getJourneyBeanList() {
		return journeyBeanList;
	}

	/**
	 * @param journeyBeanList the journeyBeanList to set
	 */
	public void setJourneyBeanList(List<SummaryPageBean> journeyBeanList) {
		this.journeyBeanList = journeyBeanList;
	}
}
