package com.villtron.loanpicker;

import java.util.List;

import org.apache.log4j.Logger;

import com.villtron.loanpicker.apiclient.PortfolioCreator;
import com.villtron.loanpicker.apiclient.PortfolioLoader;
import com.villtron.loanpicker.beans.Portfolio;
import com.villtron.loanpicker.beans.PortfolioCreation;
import com.ypei.loanpicker.Cfg;
import com.ypei.loanpicker.ConfigLoader;

/**
 * Starting point 1. load config 2. 
 * 
 * @author mvillere
 */
public class PortfolioCreatorApp {
	private static Logger logger = Logger.getLogger(PortfolioCreatorApp.class);

	public static Portfolio ManagePortfolios(boolean createAPortfolio) {

		logger.info("***********START_PORTFOLIO_PROCESS***********");

		Portfolio portfolioCreated = null;
		
		if (createAPortfolio) {
			portfolioCreated = PortfolioCreator.createPortfolio(new PortfolioCreation("Java-Portfolio-" + System.currentTimeMillis(), "Portfolio Created via Java"));
		}
		
		List<Portfolio> portfoliosLoaded = PortfolioLoader.loadPortfolios();
		
		logger.info("-----------------------------------------------");
		logger.info("PORTFOLIO_CONFIRMATION_COUNT: " + portfoliosLoaded.size());

		logger.info("***********END_PORTFOLIO_PROCESS***********");
		
		return portfolioCreated;
	}

	public static void runPortfolioWrapper() {
		logger.info("***********Welcome to Loan Picker for Lendng Club. By Yuanteng Jeff Pei***********");
		logger.info("***********Make sure application.conf is under current directory. ***********");
		logger.info("***********Github: https://github.com/jeffpeiyt/loan-picker-lendingclub***********");
		logger.info("***********Change application.conf to run as a scheduler or a one time executor ***********");

		ConfigLoader.loadConfig();

		Boolean createPortfolio = new Boolean(Cfg.m.get(Cfg.T.CREATE_PORTFOLIO
				.name()));
		
		ManagePortfolios(createPortfolio);
	}

	public static void main(String[] args) {
		runPortfolioWrapper();
	}
}
