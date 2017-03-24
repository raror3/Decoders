package com.decoders.bean;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailPageBean {

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
	@SerializedName("Action")
	@Expose
	private String action;
	@SerializedName("Host")
	@Expose
	private String host;
	@SerializedName("URL")
	@Expose
	private String uRL;
	@SerializedName("Response Code")
	@Expose
	private Long responseCode;
	@SerializedName("Time to Load (ms)")
	@Expose
	private Long timeToLoadMs;
	@SerializedName("Run")
	@Expose
	private Long run;
	@SerializedName("CDN Provider")
	@Expose
	private String cDNProvider;
	@SerializedName("Initiator")
	@Expose
	private String initiator;

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
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
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
	 * @return the responseCode
	 */
	public Long getResponseCode() {
		return responseCode;
	}
	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(Long responseCode) {
		this.responseCode = responseCode;
	}
	/**
	 * @return the timeToLoadMs
	 */
	public Long getTimeToLoadMs() {
		return timeToLoadMs;
	}
	/**
	 * @param timeToLoadMs the timeToLoadMs to set
	 */
	public void setTimeToLoadMs(Long timeToLoadMs) {
		this.timeToLoadMs = timeToLoadMs;
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
	 * @return the cDNProvider
	 */
	public String getcDNProvider() {
		return cDNProvider;
	}
	/**
	 * @param cDNProvider the cDNProvider to set
	 */
	public void setcDNProvider(String cDNProvider) {
		this.cDNProvider = cDNProvider;
	}
	/**
	 * @return the initiator
	 */
	public String getInitiator() {
		return initiator;
	}
	/**
	 * @param initiator the initiator to set
	 */
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
}
