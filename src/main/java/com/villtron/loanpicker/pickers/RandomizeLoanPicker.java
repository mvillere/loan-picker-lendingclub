package com.villtron.loanpicker.pickers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.ypei.loanpicker.ILoanPicker;
import com.ypei.loanpicker.beans.Loan;

/**
 * @author mvillere
 * 
 *         Randomize a set of loans.
 * 
 */
public class RandomizeLoanPicker implements ILoanPicker {
	private static Logger logger = Logger.getLogger(RandomizeLoanPicker.class);

	public List<Loan> pickLoans(List<Loan> loansLoaded) {
		List<Loan> loansPicked = new ArrayList<Loan>();
		loansPicked.addAll(loansLoaded);

		// Randomize picked loans.
		logger.info("-----------------------------------------------");
		logger.info("Randomized notes order in the list...");
		long seed = System.nanoTime();
		Collections.shuffle(loansPicked, new Random(seed));

		return loansPicked;
	}
}