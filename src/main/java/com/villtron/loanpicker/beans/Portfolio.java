package com.villtron.loanpicker.beans;

import com.google.api.client.util.Key;

/**
 * @author mvillere
 *
 */
public class Portfolio {
	@Key
	public Integer portfolioId;
	@Key
	public String portfolioName;
	@Key
	public String portfolioDescription;

	public Portfolio() {
	}

	public Portfolio(Integer portfolioId, String portfolioName,
			String portfolioDescription) {
		super();
		this.portfolioId = portfolioId;
		this.portfolioName = portfolioName;
		this.portfolioDescription = portfolioDescription;
	}

	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + ", portfolioName="
				+ portfolioName + ", portfolioDescription="
				+ portfolioDescription + "]";
	}
}
