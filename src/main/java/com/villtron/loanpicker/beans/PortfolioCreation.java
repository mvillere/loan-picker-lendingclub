package com.villtron.loanpicker.beans;

import com.google.api.client.util.Key;

/**
 * @author mvillere
 *
 */
public class PortfolioCreation {
	@Key
	public Integer aid;
	@Key
	public String portfolioName;
	@Key
	public String portfolioDescription;
	
	public PortfolioCreation(String portfolioName, String portfolioDescription) {
		super();
		this.aid = 0; //should be overriden prior to use.
		this.portfolioName = portfolioName;
		this.portfolioDescription = portfolioDescription;
	}
}
