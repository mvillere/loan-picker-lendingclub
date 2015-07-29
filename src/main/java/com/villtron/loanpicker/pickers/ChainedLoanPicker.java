package com.villtron.loanpicker.pickers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ypei.loanpicker.ILoanPicker;
import com.ypei.loanpicker.beans.Loan;

/**
 * @author mvillere
 * 
 *         Pick loans filtered through a chain of filter lists.
 * 
 */
public class ChainedLoanPicker implements ILoanPicker {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(ChainedLoanPicker.class);

	private List<ILoanPicker> loanPickers = new ArrayList<ILoanPicker>();

	public ChainedLoanPicker(ILoanPicker... loanPickers) {
		for (ILoanPicker loanPicker : loanPickers) {
			this.loanPickers.add(loanPicker);
		}
	}

	public List<Loan> pickLoans(List<Loan> loansLoaded) {
		List<Loan> loansPicked = new ArrayList<Loan>();
		loansPicked.addAll(loansLoaded);

		for (ILoanPicker loanPicker : loanPickers) {
			loansPicked = loanPicker.pickLoans(loansPicked);
		}

		return loansPicked;
	}
}