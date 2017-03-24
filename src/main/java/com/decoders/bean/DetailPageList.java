package com.decoders.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailPageList {

	private List<DetailPageBean> journeyBeanList;

	/**
	 * @return the journeyBeanList
	 */
	public List<DetailPageBean> getJourneyBeanList() {
		return journeyBeanList;
	}

	/**
	 * @param journeyBeanList the journeyBeanList to set
	 */
	public void setJourneyBeanList(List<DetailPageBean> journeyBeanList) {
		this.journeyBeanList = journeyBeanList;
	}

}
