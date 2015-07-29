package com.villtron.loanpicker;

import java.util.List;

import org.apache.log4j.Logger;

import com.villtron.loanpicker.customfilters.NoOwnedLoansFilter;
import com.villtron.loanpicker.customfilters.YpeiFilter;
import com.villtron.loanpicker.filtering.FilterRule;
import com.villtron.loanpicker.pickers.ChainedLoanPicker;
import com.villtron.loanpicker.pickers.FilterRuleLoanPicker;
import com.villtron.loanpicker.pickers.RandomizeLoanPicker;
import com.ypei.loanpicker.ConfigLoader;
import com.ypei.loanpicker.ILoanPicker;
import com.ypei.loanpicker.IRule;
import com.ypei.loanpicker.LoanLoader;
import com.ypei.loanpicker.OwnedNoteLoader;
import com.ypei.loanpicker.beans.Loan;

/**
 * Filter all loans based on a set of rules.
 * 
 * @author mvillere
 */
public class FilteringApp {
	private static Logger logger = Logger.getLogger(FilteringApp.class);

	public static List<Loan> loadAndFilterLoans() {

		logger.info("***********START_NEW_LOAN_PICKER_PROCESS***********");

		// Filter already owned loans
		IRule noOwnedLoansRule = new FilterRule(new NoOwnedLoansFilter(
				OwnedNoteLoader.loadOwnedNotes()));
		IRule ypeiRule = new FilterRule(new YpeiFilter());

		ILoanPicker chainedPicker = new ChainedLoanPicker(
				new FilterRuleLoanPicker(noOwnedLoansRule),
				new FilterRuleLoanPicker(ypeiRule),
				new RandomizeLoanPicker());

		List<Loan> loansLoaded = LoanLoader.loadLoans();

		List<Loan> randomizedPickedLoans = chainedPicker.pickLoans(loansLoaded);

		logger.info("***********END_NEW_LOAN_PICKER_PROCESS***********");

		return randomizedPickedLoans;
	}

	public static void runFilterWrapper() {
		logger.info("***********Welcome to Loan Picker for Lendng Club. By Yuanteng Jeff Pei***********");
		logger.info("***********Make sure application.conf is under current directory. ***********");
		logger.info("***********Github: https://github.com/jeffpeiyt/loan-picker-lendingclub***********");
		logger.info("***********Change application.conf to run as a scheduler or a one time executor ***********");

		ConfigLoader.loadConfig();

		loadAndFilterLoans();
	}

	public static void main(String[] args) {
		runFilterWrapper();
	}
}
