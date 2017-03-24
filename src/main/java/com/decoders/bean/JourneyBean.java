package com.decoders.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JourneyBean {

	private List<PageBean> journeyBeanList;

	/**
	 * @return the journeyBeanList
	 */
	public List<PageBean> getJourneyBeanList() {
		return journeyBeanList;
	}

	/**
	 * @param journeyBeanList the journeyBeanList to set
	 */
	public void setJourneyBeanList(List<PageBean> journeyBeanList) {
		this.journeyBeanList = journeyBeanList;
	}

}
