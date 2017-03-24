package com.decoders.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SummaryPageList {

	private List<SummaryPageBean> journeyBeanList;

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
