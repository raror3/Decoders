package com.decoders.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SummaryPageBean {

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

	public String getURL() {
		return uRL;
	}

	public void setURL(String uRL) {
		this.uRL = uRL;
	}

	public Long getLoadTimeMs() {
		return loadTimeMs;
	}

	public void setLoadTimeMs(Long loadTimeMs) {
		this.loadTimeMs = loadTimeMs;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public String getBasePageCDN() {
		return basePageCDN;
	}

	public void setBasePageCDN(String basePageCDN) {
		this.basePageCDN = basePageCDN;
	}

	public Long getRun() {
		return run;
	}

	public void setRun(Long run) {
		this.run = run;
	}

	public Long getSpeedIndex() {
		return speedIndex;
	}

	public void setSpeedIndex(Long speedIndex) {
		this.speedIndex = speedIndex;
	}

}
