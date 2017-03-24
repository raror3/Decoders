package com.decoders.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailPageBean {

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getURL() {
		return uRL;
	}

	public void setURL(String uRL) {
		this.uRL = uRL;
	}

	public Long getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Long responseCode) {
		this.responseCode = responseCode;
	}

	public Long getTimeToLoadMs() {
		return timeToLoadMs;
	}

	public void setTimeToLoadMs(Long timeToLoadMs) {
		this.timeToLoadMs = timeToLoadMs;
	}

	public Long getRun() {
		return run;
	}

	public void setRun(Long run) {
		this.run = run;
	}

	public String getCDNProvider() {
		return cDNProvider;
	}

	public void setCDNProvider(String cDNProvider) {
		this.cDNProvider = cDNProvider;
	}

	public String getInitiator() {
		return initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}

}
