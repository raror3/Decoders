/**
 * 
 */
package com.decoders.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author raror3
 *
 */
@Component
@ConfigurationProperties(prefix="org.site.lifeline.constants")
public class Configurations {

	private String port;
	private String host;
	private String schedulerHostUrl;

	private String emptySpace = " ";

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
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
	 * @return the schedulerHostUrl
	 */
	public String getSchedulerHostUrl() {
		return schedulerHostUrl;
	}

	/**
	 * @param schedulerHostUrl the schedulerHostUrl to set
	 */
	public void setSchedulerHostUrl(String schedulerHostUrl) {
		this.schedulerHostUrl = schedulerHostUrl;
	}

	/**
	 * @return the emptySpace
	 */
	public String getEmptySpace() {
		return emptySpace;
	}

	/**
	 * @param emptySpace the emptySpace to set
	 */
	public void setEmptySpace(String emptySpace) {
		this.emptySpace = emptySpace;
	}

}
