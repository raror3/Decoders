package com.decoders.bean;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SummaryPageBean {

	@Id
	private String journeyIdentifier;
	@SerializedName("Date")
	@Expose
	private String date;
	@SerializedName("Time")
	@Expose
	private String time;
	@SerializedName("Event Name")
	@Expose
	private String eventName;
	@SerializedName("URL")
	@Expose
	private String uRL;
	@SerializedName("Load Time (ms)")
	@Expose
	private Long loadTimeMs;
	@SerializedName("Browser Name")
	@Expose
	private String browserName;
	@SerializedName("Browser Version")
	@Expose
	private String browserVersion;
	@SerializedName("Base Page CDN")
	@Expose
	private String basePageCDN;
	@SerializedName("Run")
	@Expose
	private Long run;
	@SerializedName("Speed Index")
	@Expose
	private Long speedIndex;
	@SerializedName("Base Page Result")
	@Expose
	private String basePageResult;
	public String getBasePageResult() {
		return basePageResult;
	}
	public void setBasePageResult(String basePageResult) {
		this.basePageResult = basePageResult;
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	@SerializedName("Page Title")
	@Expose
	private String pageTitle;
	
	
	/**
	 * @return the journeyIdentifier
	 */
	public String getJourneyIdentifier() {
		return journeyIdentifier;
	}
	/**
	 * @param journeyIdentifier the journeyIdentifier to set
	 */
	public void setJourneyIdentifier(String journeyIdentifier) {
		this.journeyIdentifier = journeyIdentifier;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}
	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	/**
	 * @return the uRL
	 */
	public String getuRL() {
		return uRL;
	}
	/**
	 * @param uRL the uRL to set
	 */
	public void setuRL(String uRL) {
		this.uRL = uRL;
	}
	/**
	 * @return the loadTimeMs
	 */
	public Long getLoadTimeMs() {
		return loadTimeMs;
	}
	/**
	 * @param loadTimeMs the loadTimeMs to set
	 */
	public void setLoadTimeMs(Long loadTimeMs) {
		this.loadTimeMs = loadTimeMs;
	}
	/**
	 * @return the browserName
	 */
	public String getBrowserName() {
		return browserName;
	}
	/**
	 * @param browserName the browserName to set
	 */
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	/**
	 * @return the browserVersion
	 */
	public String getBrowserVersion() {
		return browserVersion;
	}
	/**
	 * @param browserVersion the browserVersion to set
	 */
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}
	/**
	 * @return the basePageCDN
	 */
	public String getBasePageCDN() {
		return basePageCDN;
	}
	/**
	 * @param basePageCDN the basePageCDN to set
	 */
	public void setBasePageCDN(String basePageCDN) {
		this.basePageCDN = basePageCDN;
	}
	/**
	 * @return the run
	 */
	public Long getRun() {
		return run;
	}
	/**
	 * @param run the run to set
	 */
	public void setRun(Long run) {
		this.run = run;
	}
	/**
	 * @return the speedIndex
	 */
	public Long getSpeedIndex() {
		return speedIndex;
	}
	/**
	 * @param speedIndex the speedIndex to set
	 */
	public void setSpeedIndex(Long speedIndex) {
		this.speedIndex = speedIndex;
	}

}
