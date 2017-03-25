package com.decoders.bean;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "apiDetails")
public class ApiExecutionDetailBean {

	private int responseCode;
	private long TimeTaken;
	private Date executionDate;
	private long executionTimeinMillis;
	private String apiName;
	private int apiExecutionStartHourOfDay;
	private int apiExecutionStartMinuteOfHour;
	private int apiExecutionEndMinuteOfHour;
	private String overallStatus;

	/**
	 * @return the overallStatus
	 */
	public String getOverallStatus() {
		return overallStatus;
	}
	/**
	 * @param overallStatus the overallStatus to set
	 */
	public void setOverallStatus(String overallStatus) {
		this.overallStatus = overallStatus;
	}
	/**
	 * @return the apiExecutionEndMinuteOfHour
	 */
	public int getApiExecutionEndMinuteOfHour() {
		return apiExecutionEndMinuteOfHour;
	}
	/**
	 * @param apiExecutionEndMinuteOfHour the apiExecutionEndMinuteOfHour to set
	 */
	public void setApiExecutionEndMinuteOfHour(int apiExecutionEndMinuteOfHour) {
		this.apiExecutionEndMinuteOfHour = apiExecutionEndMinuteOfHour;
	}
	private int apiExecutionEndHourOfDay;

	/**
	 * @return the apiExecutionEndHourOfDay
	 */
	public int getApiExecutionEndHourOfDay() {
		return apiExecutionEndHourOfDay;
	}
	/**
	 * @param apiExecutionEndHourOfDay the apiExecutionEndHourOfDay to set
	 */
	public void setApiExecutionEndHourOfDay(int apiExecutionEndHourOfDay) {
		this.apiExecutionEndHourOfDay = apiExecutionEndHourOfDay;
	}
	/**
	 * @return the apiExecutionStartHourOfDay
	 */
	public int getApiExecutionStartHourOfDay() {
		return apiExecutionStartHourOfDay;
	}
	/**
	 * @param apiExecutionStartHourOfDay the apiExecutionStartHourOfDay to set
	 */
	public void setApiExecutionStartHourOfDay(int apiExecutionStartHourOfDay) {
		this.apiExecutionStartHourOfDay = apiExecutionStartHourOfDay;
	}
	/**
	 * @return the apiExecutionStartMinuteOfHour
	 */
	public int getApiExecutionStartMinuteOfHour() {
		return apiExecutionStartMinuteOfHour;
	}
	/**
	 * @param apiExecutionStartMinuteOfHour the apiExecutionStartMinuteOfHour to set
	 */
	public void setApiExecutionStartMinuteOfHour(int apiExecutionStartMinuteOfHour) {
		this.apiExecutionStartMinuteOfHour = apiExecutionStartMinuteOfHour;
	}
	/**
	 * @return the responseCode
	 */
	public int getResponseCode() {
		return responseCode;
	}
	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	/**
	 * @return the timeTaken
	 */
	public long getTimeTaken() {
		return TimeTaken;
	}
	/**
	 * @param timeTaken the timeTaken to set
	 */
	public void setTimeTaken(long timeTaken) {
		TimeTaken = timeTaken;
	}
	/**
	 * @return the executionDate
	 */
	public Date getExecutionDate() {
		return executionDate;
	}
	/**
	 * @param executiondate the executionDate to set
	 */
	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}
	/**
	 * @return the executionTimeinMillis
	 */
	public long getExecutionTimeinMillis() {
		return executionTimeinMillis;
	}
	/**
	 * @param executionTimeinMillis the executionTimeinMillis to set
	 */
	public void setExecutionTimeinMillis(long executionTimeinMillis) {
		this.executionTimeinMillis = executionTimeinMillis;
	}
	/**
	 * @return the apiName
	 */
	public String getApiName() {
		return apiName;
	}
	/**
	 * @param apiName the apiName to set
	 */
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

}
