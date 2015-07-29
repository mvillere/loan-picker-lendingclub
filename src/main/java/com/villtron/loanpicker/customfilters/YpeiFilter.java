package com.villtron.loanpicker.customfilters;

import com.villtron.loanpicker.filtering.FilterFailure;
import com.villtron.loanpicker.filtering.ILoanFilter;
import com.ypei.loanpicker.PickRule;
import com.ypei.loanpicker.beans.Loan;

/**
 * @author mvillere
 * 
 *         Perform the "Ypei" filter, found in {@link PickRule}.
 */
public class YpeiFilter implements ILoanFilter {
	public String Name() {
		return "YpeiFilter";
	}

	public FilterFailure FilterLoan(Loan loan) {
		if (new PickRule().pickBasedOnRule(loan)){
			return null; // loan is picked, and therefore not filtered.
		} else {
			return new FilterFailure(null, null, "Loan not picked due to Ypei filter.");			
		}
	}
}
